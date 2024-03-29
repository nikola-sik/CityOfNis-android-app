package org.unibl.etf.cityofnis.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.activity.AttractionPreviewActivity;
import org.unibl.etf.cityofnis.activity.MuseumPreviewActivity;
import org.unibl.etf.cityofnis.adapter.AttractionAdapter;

import org.unibl.etf.cityofnis.dto.Attraction;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AttractionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AttractionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttractionFragment extends Fragment implements ItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private  RecyclerView recyclerView;
    private  AttractionAdapter attractionAdapter;
    private List<Attraction> attractionList;
    private  SearchView searchView;
    private AttractionFragment.OnFragmentInteractionListener mListener;
    private String language;



    public AttractionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AttractionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AttractionFragment newInstance(String param1, String param2) {
        AttractionFragment fragment = new AttractionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        attractionList = AppController.appDatabase.attractionDAO().getAll();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        language = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key), getString(R.string.language_value_en));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.attraction_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        attractionAdapter = new AttractionAdapter(getContext(), attractionList);
        recyclerView.setAdapter(attractionAdapter);
        attractionAdapter.setItemClickListener(this);
        attractionAdapter.notifyDataSetChanged();
        setHasOptionsMenu(true);
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
        if (context instanceof AttractionFragment.OnFragmentInteractionListener) {
            mListener = (AttractionFragment.OnFragmentInteractionListener) context;
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.main, menu);
        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search_toolbar).getActionView();

        if(searchView!=null)
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String queryText) {
                queryText = queryText.toLowerCase();
                List<Attraction> filteredattractionList = new ArrayList<>();

                if ("en".equals(language)) {
                    for (Attraction attraction : attractionList) {
                        if (attraction.getNameEn().toLowerCase().contains(queryText)) {
                            filteredattractionList.add(attraction);
                        }
                    }
                }
                else{
                    for (Attraction museum : attractionList) {
                        if (museum.getNameSr().toLowerCase().contains(queryText)) {
                            filteredattractionList.add(museum);
                        }
                    }

                }
                attractionAdapter.setFilter(filteredattractionList);
                return true;
            }
        });
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(getActivity(), AttractionPreviewActivity.class);
        Attraction item = attractionAdapter.getAttractionItem(position);

        if ("en".equals(language)) {

            intent.putExtra("name", item.getNameEn());
            intent.putExtra("image", item.getImage());
            intent.putExtra("description", item.getDescriptionEn());
            intent.putExtra("lat", item.getLatitude());
            intent.putExtra("lon", item.getLongitude());
        }else{

            intent.putExtra("name", item.getNameSr());
            intent.putExtra("image", item.getImage());
            intent.putExtra("description", item.getDescriptionSr());
            intent.putExtra("lat",item.getLatitude());
            intent.putExtra("lon",item.getLongitude());
        }

        startActivity(intent);
    }

}
