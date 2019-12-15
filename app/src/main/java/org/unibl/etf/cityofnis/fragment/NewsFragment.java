package org.unibl.etf.cityofnis.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.activity.MainActivity;
import org.unibl.etf.cityofnis.activity.NewsPreviewActivity;
import org.unibl.etf.cityofnis.adapter.NewsAdapter;
import org.unibl.etf.cityofnis.database.dao.NewsDAO;
import org.unibl.etf.cityofnis.dto.News;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment implements ItemClickListener,SwipeRefreshLayout.OnRefreshListener  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private SwipeRefreshLayout swipeRefreshContainer;
    private  RecyclerView recyclerView;//s
    private  NewsAdapter newsAdapter;//s
    private  List<News> newsList;//s
    private  SearchView searchView; //s
    private View view;

    private NewsFeedTask newsFeedTask;
    String   language;

    private OnFragmentInteractionListener mListener;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.news_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        newsAdapter = new NewsAdapter(getActivity(), newsList);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setItemClickListener(this);
        newsAdapter.notifyDataSetChanged();
        setHasOptionsMenu(true);

        swipeRefreshContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_container);
        swipeRefreshContainer.setOnRefreshListener(this);
        swipeRefreshContainer.setColorSchemeResources(
                R.color.colorPrimary,
                android.R.color.holo_blue_dark,
                android.R.color.holo_blue_light,
                android.R.color.holo_blue_bright);

        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_preferences_key), getActivity().MODE_PRIVATE);
        language = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key), getString(R.string.language_value_en));



        swipeRefreshContainer.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshContainer.setRefreshing(true);

                loadNewsData();
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view, int position) {


        Intent intent = new Intent(getActivity(), NewsPreviewActivity.class);
        News item = newsAdapter.getNews(position);
        intent.putExtra("link", item.getLink());//"https" + item.getLink().substring(4));
        intent.putExtra("lang", language);
        startActivity(intent);

    }

    @Override
    public void onRefresh() {

        if(!isNetworkConnected())
            Toast.makeText(getActivity(), getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();

        loadNewsData();
    }

    private void loadNewsData() {
        newsFeedTask = new NewsFeedTask(getActivity());
        newsFeedTask.execute(null, null);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private boolean isTaskRunning() {
        return (newsFeedTask != null) && (newsFeedTask.getStatus() == AsyncTask.Status.RUNNING);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isTaskRunning()) {
            newsFeedTask.cancel(true);
        }
    }


    public class NewsFeedTask extends AsyncTask<Void, Void, List<News>> {
        private String urlLink = getString(R.string.news_feed_url);



        private Context context;

        public NewsFeedTask(Context context) {
            this.context = context;
 }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<News> doInBackground(Void... voids) {

            List<News> news = null;
            if (TextUtils.isEmpty(urlLink))
                return null;

            try {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_preferences_key), getActivity().MODE_PRIVATE);
                final boolean cachingNewsData = sharedPreferences.getBoolean(getString(R.string.caching_news_data_boolean), true);
                NewsDAO newsDAO = AppController.appDatabase.newsDAO();

                if (isNetworkConnected()) {
                    URL url = new URL(urlLink);
                    InputStream inputStream = url.openConnection().getInputStream();
                    news = parseFeed(inputStream);
                    if (cachingNewsData) {
                        newsDAO.deleteAll();
                        newsDAO.insertAll(news);
                    }
                } else {
                    news = newsDAO.getAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return news;
        }

        @Override
        protected void onPostExecute(List<News> news) {
            super.onPostExecute(news);
            swipeRefreshContainer.setRefreshing(false);
            if (news == null) {
                newsList = new ArrayList<>();
            }

            newsList = news;
            newsAdapter.setNewsList(newsList);
            newsAdapter.notifyDataSetChanged();
        }



        public ArrayList<News> parseFeed(InputStream inputStream) throws XmlPullParserException, IOException {
            String title = null;
            String link = null;
            String description = null;
            String shortDescription = null;
            String image = null;
            boolean isItem = false;
            ArrayList<News> items = new ArrayList<>();

            try {

                XmlPullParser xmlPullParser = Xml.newPullParser();
                xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                xmlPullParser.setInput(inputStream, null);

                xmlPullParser.nextTag();
                while (xmlPullParser.next() != XmlPullParser.END_DOCUMENT) {

                    int eventType = xmlPullParser.getEventType();
                    String name = xmlPullParser.getName();


                    if (name == null)
                        continue;

                    if (eventType == XmlPullParser.END_TAG) {
                        if ("item".equalsIgnoreCase(name)) {
                            isItem = false;
                        }
                        continue;
                    }

                    if (eventType == XmlPullParser.START_TAG) {
                        if ("item".equalsIgnoreCase(name)) {
                            isItem = true;
                            continue;
                        }
                    }


                    String result = "";
                    if (xmlPullParser.next() == XmlPullParser.TEXT) {
                        result = xmlPullParser.getText();
                        xmlPullParser.nextTag();
                    }

                    String pom="";
                    //niske vesti
                    if ("title".equalsIgnoreCase(name)) {
                        title = result;
                    } else if ("link".equalsIgnoreCase(name)) {
                        link ="http" + result.substring(5);
                    } else if ("description".equalsIgnoreCase(name) && isItem) {
                        description = result;
                    }
                    if ("description".equalsIgnoreCase(name) && isItem) {

                        try {
                            if(result.substring(result.indexOf("\" />")).length()>=80)
                            {  pom=result.substring(result.indexOf("\" />")+4);
                                pom=pom.substring(0,pom.indexOf("</"));
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    shortDescription=Html.fromHtml(pom, Html.FROM_HTML_MODE_COMPACT).toString();
                                } else {
                                    shortDescription=(Html.fromHtml(pom)).toString();
                                }

                            }
                            else
                                shortDescription="Otvori za više detalja...";
                        }catch (Exception e){
                            e.printStackTrace();
                            shortDescription="Otvori za više detalja...";
                        }

                    }

                    if ("description".equalsIgnoreCase(name) && isItem) {
                        try {
                        if (!result.contains("src="))
                            image ="none";
                        else {
                            if (result.contains(".jpg"))
                                image = "http://" + result.substring(result.indexOf("src=") + 13, result.indexOf(".jpg") + 4);
                            else if (result.contains(".png"))
                                image = "http://" + result.substring(result.indexOf("src=") + 13, result.indexOf(".png") + 4);
                            else if (result.contains(".gif"))
                                image = "http://" + result.substring(result.indexOf("src=") + 13, result.indexOf(".gif") + 4);
                            else if (result.contains(".bmp"))
                                image = "http://" + result.substring(result.indexOf("src=") + 13, result.indexOf(".bmp") + 4);

                            else image ="none";

                        }
                        }catch (Exception e){
                            e.printStackTrace();
                            image="none";
                        }
                    }


                    int i = 0;
                    if (title != null && link != null && description!= null && shortDescription!= null && image != null) {
                        if (isItem) {
                            News item = new News();
                            item.setTitle(title);
                            item.setLink(link);
                            item.setDescription(description);
                            item.setShortDescription(shortDescription);
                            item.setImageUrl(image);
                            items.add(item);
                        }

                        title = null;
                        link = null;
                        description = null;
                        shortDescription=null;
                        image = null;
                        isItem = false;
                    }
                }
                return items;
            } finally {
                inputStream.close();
            }
        }


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView =
                (SearchView) menu.findItem(R.id.action_search_toolbar).getActionView();
        if (searchView != null)
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String queryText) {
                queryText = queryText.toLowerCase();
                List<News> filteredNewsList = new ArrayList<>();
                for (News newsItem : newsList) {
                    if (newsItem.getTitle().toLowerCase().contains(queryText)) {
                        filteredNewsList.add(newsItem);
                    }
                }
                newsAdapter.setFilter(filteredNewsList);
                return true;
            }
        });
    }
    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
