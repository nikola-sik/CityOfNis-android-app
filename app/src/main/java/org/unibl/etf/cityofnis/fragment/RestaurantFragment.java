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

import org.unibl.etf.cityofnis.activity.RestaurantPreviewActivity;
import org.unibl.etf.cityofnis.adapter.RestaurantAdapter;
import org.unibl.etf.cityofnis.dto.Restaurant;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RestaurantFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RestaurantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantFragment extends Fragment implements ItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;//s
    private RestaurantAdapter restaurantAdapter;//s
    private List<Restaurant> restaurantList;
    private SearchView searchView;//s
    private OnFragmentInteractionListener mListener;
    private String language;



    public RestaurantFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MuseumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestaurantFragment newInstance(String param1, String param2) {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurantList = AppController.appDatabase.restaurantDAO().getAll();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        language = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key), getString(R.string.language_value_en));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.restaurant_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        restaurantAdapter = new RestaurantAdapter(getContext(), restaurantList);
        recyclerView.setAdapter(restaurantAdapter);
        restaurantAdapter.setItemClickListener(this);
        restaurantAdapter.notifyDataSetChanged();
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
        if (context instanceof RestaurantFragment.OnFragmentInteractionListener) {
            mListener = (RestaurantFragment.OnFragmentInteractionListener) context;
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
                List<Restaurant> filteredRestaurantList = new ArrayList<>();

                if ("en".equals(language)) {
                    for (Restaurant restaurant : restaurantList) {
                        if (restaurant.getNameEn().toLowerCase().contains(queryText)) {
                            filteredRestaurantList.add(restaurant);
                        }
                    }
                }
                else{
                    for (Restaurant restaurant : restaurantList) {
                        if (restaurant.getNameSr().toLowerCase().contains(queryText)) {
                            filteredRestaurantList.add(restaurant);
                        }
                    }

                }
                restaurantAdapter.setFilter(filteredRestaurantList);
                return true;
            }
        });
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(getActivity(), RestaurantPreviewActivity.class);
        Restaurant item = restaurantAdapter.getRestaurantItem(position);

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
