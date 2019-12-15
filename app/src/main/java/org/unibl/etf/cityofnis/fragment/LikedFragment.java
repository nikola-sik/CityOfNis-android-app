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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.activity.LikedPreviewActivity;
import org.unibl.etf.cityofnis.activity.MuseumPreviewActivity;
import org.unibl.etf.cityofnis.adapter.AttractionAdapter;
import org.unibl.etf.cityofnis.adapter.LikedAdapter;
import org.unibl.etf.cityofnis.dto.Adventure;
import org.unibl.etf.cityofnis.dto.Attraction;
import org.unibl.etf.cityofnis.dto.CityInstitution;
import org.unibl.etf.cityofnis.dto.Event;
import org.unibl.etf.cityofnis.dto.Hotel;
import org.unibl.etf.cityofnis.dto.Liked;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.dto.Restaurant;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LikedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LikedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LikedFragment extends Fragment implements ItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private  RecyclerView recyclerView;
    private  LikedAdapter likedAdapter;
    private List<Liked> likedList;

    private List<Museum> museumList;
    private List<Attraction> attractionList;
    private List<CityInstitution> cityInstitutionList;
    private List<Hotel> hotelList;
    private List<Event> eventList;
    private List<Restaurant> restaurantList;
    private List<Adventure> adventureList;
    private  SearchView searchView;
    private AttractionFragment.OnFragmentInteractionListener mListener;
    private String language;
    private Liked likedItem;


    public LikedFragment() {
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
        museumList=AppController.appDatabase.museumDAO().getAllLiked(true);
        cityInstitutionList=AppController.appDatabase.cityInstitutionDAO().getAllLiked(true);
        attractionList=AppController.appDatabase.attractionDAO().getAllLiked(true);
        hotelList=AppController.appDatabase.hotelDAO().getAllLiked(true);
        eventList=AppController.appDatabase.eventDAO().getAllLiked(true);
        restaurantList=AppController.appDatabase.restaurantDAO().getAllLiked(true);
        adventureList=AppController.appDatabase.adventureDAO().getAllLiked(true);
        likedList=new ArrayList<>();

      //  AppController.appDatabase.likedDAO().deleteAll();
        for(Museum m:museumList){

            likedItem=new Liked();
                likedItem.setDescriptionEn(m.getDescriptionEn());
                likedItem.setDescriptionSr(m.getDescriptionSr());
                likedItem.setFavourite(m.isFavourite());
                likedItem.setNameEn(m.getNameEn());
                likedItem.setNameSr(m.getNameSr());
                likedItem.setLatitude(m.getLatitude());
                likedItem.setLongitude(m.getLongitude());
                likedItem.setImage(m.getImage());
                likedList.add(likedItem);

            }
        for(Attraction a:attractionList){
            likedItem=new Liked();
                likedItem.setDescriptionEn(a.getDescriptionEn());
                likedItem.setDescriptionSr(a.getDescriptionSr());
                likedItem.setFavourite(a.isFavourite());
                likedItem.setNameEn(a.getNameEn());
                likedItem.setNameSr(a.getNameSr());
                likedItem.setLatitude(a.getLatitude());
                likedItem.setLongitude(a.getLongitude());
                likedItem.setImage(a.getImage());
                likedList.add(likedItem);

        }
        for(CityInstitution ci:cityInstitutionList){
            likedItem=new Liked();
            likedItem.setDescriptionEn(ci.getDescriptionEn());
            likedItem.setDescriptionSr(ci.getDescriptionSr());
            likedItem.setFavourite(ci.isFavourite());
            likedItem.setNameEn(ci.getNameEn());
            likedItem.setNameSr(ci.getNameSr());
            likedItem.setLatitude(ci.getLatitude());
            likedItem.setLongitude(ci.getLongitude());
            likedItem.setImage(ci.getImage());
            likedList.add(likedItem);

        }
        for(Hotel h:hotelList){

            likedItem=new Liked();
            likedItem.setDescriptionEn(h.getDescriptionEn());
            likedItem.setDescriptionSr(h.getDescriptionSr());
            likedItem.setFavourite(h.isFavourite());
            likedItem.setNameEn(h.getNameEn());
            likedItem.setNameSr(h.getNameSr());
            likedItem.setLatitude(h.getLatitude());
            likedItem.setLongitude(h.getLongitude());
            likedItem.setImage(h.getImage());
            likedList.add(likedItem);

        }
        for(Event e:eventList){

            likedItem=new Liked();
            likedItem.setDescriptionEn(e.getDescriptionEn());
            likedItem.setDescriptionSr(e.getDescriptionSr());
            likedItem.setFavourite(e.isFavourite());
            likedItem.setNameEn(e.getNameEn());
            likedItem.setNameSr(e.getNameSr());
            likedItem.setLatitude(e.getLatitude());
            likedItem.setLongitude(e.getLongitude());
            likedItem.setImage(e.getImage());
            likedList.add(likedItem);

        }

        for(Restaurant r:restaurantList){

            likedItem=new Liked();
            likedItem.setDescriptionEn(r.getDescriptionEn());
            likedItem.setDescriptionSr(r.getDescriptionSr());
            likedItem.setFavourite(r.isFavourite());
            likedItem.setNameEn(r.getNameEn());
            likedItem.setNameSr(r.getNameSr());
            likedItem.setLatitude(r.getLatitude());
            likedItem.setLongitude(r.getLongitude());
            likedItem.setImage(r.getImage());
            likedList.add(likedItem);

        }

        for(Adventure ad:adventureList){

            likedItem=new Liked();
            likedItem.setDescriptionEn(ad.getDescriptionEn());
            likedItem.setDescriptionSr(ad.getDescriptionSr());
            likedItem.setFavourite(ad.isFavourite());
            likedItem.setNameEn(ad.getNameEn());
            likedItem.setNameSr(ad.getNameSr());
            likedItem.setLatitude(ad.getLatitude());
            likedItem.setLongitude(ad.getLongitude());
            likedItem.setImage(ad.getImage());
            likedList.add(likedItem);

        }
      //  AppController.appDatabase.likedDAO().insertAll(likedList);
        for(Liked mu:likedList){

        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        language = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key), getString(R.string.language_value_en));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.attraction_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        likedAdapter = new LikedAdapter(getContext(), likedList);
        recyclerView.setAdapter(likedAdapter);
        likedAdapter.setItemClickListener(this);
        likedAdapter.notifyDataSetChanged();
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
                List<Liked> filteredLikedList = new ArrayList<>();

                if ("en".equals(language)) {
                    for (Liked liked : likedList) {
                        if (liked.getNameEn().toLowerCase().contains(queryText)) {
                            filteredLikedList.add(liked);
                        }
                    }
                }
                else{
                    for (Liked liked : likedList) {
                        if (liked.getNameSr().toLowerCase().contains(queryText)) {
                            filteredLikedList.add(liked);
                        }
                    }

                }
                likedAdapter.setFilter(filteredLikedList);
                return true;
            }
        });
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(getActivity(), LikedPreviewActivity.class);
        Liked item = likedAdapter.getLikedItem(position);

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
