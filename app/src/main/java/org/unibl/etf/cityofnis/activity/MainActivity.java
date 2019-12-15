package org.unibl.etf.cityofnis.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.database.AppDatabase;
import org.unibl.etf.cityofnis.dto.Attraction;
import org.unibl.etf.cityofnis.dto.CityInstitution;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.dto.Restaurant;
import org.unibl.etf.cityofnis.fragment.AdventureFragment;
import org.unibl.etf.cityofnis.fragment.AttractionFragment;
import org.unibl.etf.cityofnis.fragment.CityInstitutionFragment;
import org.unibl.etf.cityofnis.fragment.EventFragment;
import org.unibl.etf.cityofnis.fragment.HotelFragment;
import org.unibl.etf.cityofnis.fragment.LikedFragment;
import org.unibl.etf.cityofnis.fragment.MuseumFragment;
import org.unibl.etf.cityofnis.fragment.NewsFragment;
import org.unibl.etf.cityofnis.fragment.RestaurantFragment;
import org.unibl.etf.cityofnis.util.AppController;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, NewsFragment.OnFragmentInteractionListener,MuseumFragment.OnFragmentInteractionListener,AttractionFragment.OnFragmentInteractionListener,LikedFragment.OnFragmentInteractionListener,CityInstitutionFragment.OnFragmentInteractionListener,HotelFragment.OnFragmentInteractionListener,EventFragment.OnFragmentInteractionListener,RestaurantFragment.OnFragmentInteractionListener,AdventureFragment.OnFragmentInteractionListener {

    public static SearchView searchView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        String localePref = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key), getString(R.string.language_value_en));
        Locale locale = new Locale(localePref);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        setContentView(R.layout.activity_main);


        AppController appController = AppController.getmInstance();
        appController.appDatabase = AppDatabase.getAppDatabase(this);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.news);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        NewsFragment newsFragment = new NewsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, newsFragment).commit();

        if(!isNetworkConnected())
        Toast.makeText(MainActivity.this, getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

       // getMenuInflater().inflate(R.menu.main, menu);
     return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.action_settings)
            {Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);}


                NewsFragment fragment = NewsFragment.newInstance("param1", "param2");
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;


        if (id == R.id.nav_news) {
            fragment = new NewsFragment();
            toolbar.setTitle(R.string.action_news);

        } else if (id == R.id.nav_city_attraction) {
            fragment = new AttractionFragment();
            toolbar.setTitle(R.string.city_attraction);

        } else if (id == R.id.nav_city_institution) {

            fragment = new CityInstitutionFragment();
            toolbar.setTitle(R.string.action_city_institution);

        } else if (id == R.id.nav_hotel) {
            fragment = new HotelFragment();
            toolbar.setTitle(R.string.action_hotel);

        } else if (id == R.id.nav_event) {
            fragment = new EventFragment();
            toolbar.setTitle(R.string.action_event);
        }else if(id==R.id.nav_about){

            Intent i = new Intent(this, AboutActivity.class);
            startActivity(i);

        }else if (id == R.id.nav_museums) {

            fragment = new MuseumFragment();

            toolbar.setTitle(R.string.action_museums);

        } else if (id == R.id.nav_liked) {
            fragment = new LikedFragment();
            toolbar.setTitle(R.string.action_liked);

        } else if (id == R.id.nav_map) {
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_weather) {
            Intent i = new Intent(this, WeatherActivity.class);
            startActivity(i);
        }
        else if (id == R.id.nav_restaurant) {
            fragment = new RestaurantFragment();
            toolbar.setTitle(R.string.action_restaurant);
        }
        else if (id == R.id.nav_adventure) {
            fragment = new AdventureFragment();
            toolbar.setTitle(R.string.adventure_details);
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }




    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
