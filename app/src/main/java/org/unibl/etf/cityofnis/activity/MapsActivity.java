package org.unibl.etf.cityofnis.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.dto.Attraction;
import org.unibl.etf.cityofnis.dto.CityInstitution;
import org.unibl.etf.cityofnis.dto.Event;
import org.unibl.etf.cityofnis.dto.Hotel;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.dto.Restaurant;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.OnMapAndViewReadyListener;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnInfoWindowCloseListener,
        OnMapAndViewReadyListener.OnGlobalLayoutAndMapReadyListener{


    private GoogleMap googleMap;
    private Museum lastSelectedMuseum;
    private List<Museum> museumsList = new ArrayList<>();
    private Attraction lastSelectedAttraction;
    private List<Attraction> attractionsList = new ArrayList<>();
    private CityInstitution lastSelectedCityInstitution;
    private List<CityInstitution> cityInstitutionList = new ArrayList<>();
    private Hotel lastSelectedHotel;
    private List<Hotel> hotelList = new ArrayList<>();
    private List<Event> eventList = new ArrayList<>();
    private Event lastSelectedEvent;
    private List<Restaurant> restaurantList = new ArrayList<>();
    private Restaurant lastSelectedRestaurant;
    /**
     * Keeps track of the last selected marker (though it may no longer be selected).  This is
     * useful for refreshing the info window.
     */
    private Marker mLastSelectedMarker;


    private final List<Marker> gMarkerList = new ArrayList<>();
    private static final LatLng NORTHWEST = new LatLng(43.3469737, 21.8638858);
    private static final LatLng SOUTHEAST = new LatLng(43.2850718, 22.0597015);
    private String language="en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if(!isNetworkConnected())
            Toast.makeText(MapsActivity.this, getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();


        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        language = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key), getString(R.string.language_value_en));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.city_map);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        new OnMapAndViewReadyListener(mapFragment, this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                MapsActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = null;
        if ("en".equals(language)) {

            if (lastSelectedMuseum != null) {
                intent = new Intent(MapsActivity.this, MuseumPreviewActivity.class);
                intent.putExtra("name", lastSelectedMuseum.getNameEn());
                intent.putExtra("image", lastSelectedMuseum.getImage());
                intent.putExtra("description", lastSelectedMuseum.getDescriptionEn());

            } else if (lastSelectedAttraction != null) {
                intent = new Intent(MapsActivity.this, AttractionPreviewActivity.class);
                intent.putExtra("name", lastSelectedAttraction.getNameEn());
                intent.putExtra("image", lastSelectedAttraction.getImage());
                intent.putExtra("description", lastSelectedAttraction.getDescriptionEn());

            } else if (lastSelectedCityInstitution != null) {
                intent = new Intent(MapsActivity.this, CityInstitutionPreviewActivity.class);
                intent.putExtra("name", lastSelectedCityInstitution.getNameEn());
                intent.putExtra("image", lastSelectedCityInstitution.getImage());
                intent.putExtra("description", lastSelectedCityInstitution.getDescriptionEn());

            } else if (lastSelectedHotel != null) {
                intent = new Intent(MapsActivity.this, HotelPreviewActivity.class);
                intent.putExtra("name", lastSelectedHotel.getNameEn());
                intent.putExtra("image", lastSelectedHotel.getImage());
                intent.putExtra("description", lastSelectedHotel.getDescriptionEn());

            } else if (lastSelectedEvent != null) {
                intent = new Intent(MapsActivity.this, EventPreviewActivity.class);
                intent.putExtra("name", lastSelectedEvent.getNameEn());
                intent.putExtra("image", lastSelectedEvent.getImage());
                intent.putExtra("description", lastSelectedEvent.getDescriptionEn());
            } else if (lastSelectedRestaurant != null) {
                intent = new Intent(MapsActivity.this, RestaurantPreviewActivity.class);
                intent.putExtra("name", lastSelectedRestaurant.getNameEn());
                intent.putExtra("image", lastSelectedRestaurant.getImage());
                intent.putExtra("description", lastSelectedRestaurant.getDescriptionEn());
            }
        }
                else

        if ("sr".equals(language)) {
                if (lastSelectedMuseum != null) {
                    intent = new Intent(MapsActivity.this, MuseumPreviewActivity.class);
                    intent.putExtra("name", lastSelectedMuseum.getNameSr());
                    intent.putExtra("image", lastSelectedMuseum.getImage());
                    intent.putExtra("description", lastSelectedMuseum.getDescriptionSr());
                } else if (lastSelectedAttraction != null) {
                    intent = new Intent(MapsActivity.this, AttractionPreviewActivity.class);
                    intent.putExtra("name", lastSelectedAttraction.getNameSr());
                    intent.putExtra("image", lastSelectedAttraction.getImage());
                    intent.putExtra("description", lastSelectedAttraction.getDescriptionSr());
                } else if (lastSelectedCityInstitution != null) {
                    intent = new Intent(MapsActivity.this, CityInstitutionPreviewActivity.class);
                    intent.putExtra("name", lastSelectedCityInstitution.getNameSr());
                    intent.putExtra("image", lastSelectedCityInstitution.getImage());
                    intent.putExtra("description", lastSelectedCityInstitution.getDescriptionSr());
                } else if (lastSelectedHotel != null) {
                    intent = new Intent(MapsActivity.this, HotelPreviewActivity.class);
                    intent.putExtra("name", lastSelectedHotel.getNameSr());
                    intent.putExtra("image", lastSelectedHotel.getImage());
                    intent.putExtra("description", lastSelectedHotel.getDescriptionSr());

                } else if (lastSelectedEvent != null) {
                    intent = new Intent(MapsActivity.this, EventPreviewActivity.class);
                    intent.putExtra("name", lastSelectedEvent.getNameSr());
                    intent.putExtra("image", lastSelectedEvent.getImage());
                    intent.putExtra("description", lastSelectedEvent.getDescriptionSr());
                }
                if (lastSelectedRestaurant != null) {
                    intent = new Intent(MapsActivity.this, RestaurantPreviewActivity.class);
                    intent.putExtra("name", lastSelectedRestaurant.getNameSr());
                    intent.putExtra("image", lastSelectedRestaurant.getImage());
                    intent.putExtra("description", lastSelectedRestaurant.getDescriptionSr());
                }

        }


        if (intent != null)
            startActivity(intent);

    }

    @Override
    public void onInfoWindowClose(Marker marker) {

    }

    @Override
    public boolean onMarkerClick(final Marker marker)
    {
        mLastSelectedMarker = marker;
        return false;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;

        // Hide the zoom controls as the button panel will cover it.
        googleMap.getUiSettings().setZoomControlsEnabled(false);

        // Add lots of markers to the map.
        addMarkersToMap();

        // Setting an info window adapter allows us to change the both the contents and look of the
        // info window.
        googleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));

        // Set listeners for marker events.  See the bottom of this class for their behavior.
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnInfoWindowClickListener(this);
        googleMap.setOnInfoWindowCloseListener(this);

        // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localised.
        googleMap.setContentDescription(getResources().getString(R.string.action_map));

        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(NORTHWEST)
                .include(SOUTHEAST)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));

    }

    private void addMarkersToMap() {

        Marker marker = null;
        museumsList = AppController.appDatabase.museumDAO().getAll();
        attractionsList = AppController.appDatabase.attractionDAO().getAll();
        cityInstitutionList=AppController.appDatabase.cityInstitutionDAO().getAll();
        hotelList=AppController.appDatabase.hotelDAO().getAll();
        eventList=AppController.appDatabase.eventDAO().getAll();
        restaurantList=AppController.appDatabase.restaurantDAO().getAll();


        if ("en".equals(language)) {
            for (Museum i : museumsList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(i.getLatitude(), i.getLongitude()))
                        .title(i.getNameEn())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                gMarkerList.add(marker);
            }
            for (Attraction a : attractionsList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(a.getLatitude(), a.getLongitude()))
                        .title(a.getNameEn())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                gMarkerList.add(marker);
            }
            for (CityInstitution s : cityInstitutionList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(s.getLatitude(), s.getLongitude()))
                        .title(s.getNameEn())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                gMarkerList.add(marker);
            }
            for (Hotel h : hotelList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(h.getLatitude(), h.getLongitude()))
                        .title(h.getNameEn())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                gMarkerList.add(marker);
            }
            for (Event e : eventList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(e.getLatitude(), e.getLongitude()))
                        .title(e.getNameEn())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                gMarkerList.add(marker);
            }
            for (Restaurant r : restaurantList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(r.getLatitude(), r.getLongitude()))
                        .title(r.getNameEn())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
                gMarkerList.add(marker);
            }
        }
        else
        if ("sr".equals(language)) {
            for (Museum m : museumsList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(m.getLatitude(), m.getLongitude()))
                        .title(m.getNameSr())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                gMarkerList.add(marker);
            }
            for (Attraction a : attractionsList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(a.getLatitude(), a.getLongitude()))
                        .title(a.getNameSr())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                gMarkerList.add(marker);
            }
            for (CityInstitution s : cityInstitutionList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(s.getLatitude(), s.getLongitude()))
                        .title(s.getNameSr())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                gMarkerList.add(marker);
            }
            for (Hotel h : hotelList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(h.getLatitude(), h.getLongitude()))
                        .title(h.getNameSr())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                gMarkerList.add(marker);
            }
            for (Event e : eventList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(e.getLatitude(), e.getLongitude()))
                        .title(e.getNameSr())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
                gMarkerList.add(marker);
            }
            for (Restaurant r : restaurantList) {
                marker = googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(r.getLatitude(), r.getLongitude()))
                        .title(r.getNameSr())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
                gMarkerList.add(marker);
            }
        }


    }

    private BitmapDescriptor vectorToBitmap(@DrawableRes int id, @ColorInt int color) {
        Drawable vectorDrawable = ResourcesCompat.getDrawable(getResources(), id, null);
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        DrawableCompat.setTint(vectorDrawable, color);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }




    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        // These are both viewgroups containing an ImageView with id "badge" and two TextViews with id

        private final View mWindow;
        private Context context;


        CustomInfoWindowAdapter(Context context) {
            mWindow = getLayoutInflater().inflate(R.layout.custom_info_window, null);
           this.context = context;
        }

        @Override
        public View getInfoWindow(Marker marker) {

            render(marker, mWindow);
            return mWindow;

        }

        @Override
        public View getInfoContents(Marker marker) {

            return null;
        }

        private void render(Marker marker, View view) {
            int badge;
            // Use the equals() method on a Marker to check for equals.  Do not use ==.
            boolean find = false;
            LatLng latLng = null;
            ImageView imageBadgeMap = (ImageView) view.findViewById(R.id.badge);
            for (Marker m : gMarkerList) {
                if (marker.equals(m)) {
                    latLng = marker.getPosition();
                    break;
                }
            }
            if (latLng != null) {
                for (Museum i : museumsList) {
                    if (i.getLatitude() == latLng.latitude && i.getLongitude() == latLng.longitude) {
                        lastSelectedMuseum = i;
                        lastSelectedAttraction=null;
                        lastSelectedCityInstitution=null;
                        lastSelectedHotel=null;
                        lastSelectedEvent=null;
                        lastSelectedRestaurant=null;
                        imageBadgeMap.setImageResource(R.drawable.ic_action_historical_sight);
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    for (Attraction a : attractionsList) {
                        if (a.getLatitude() == latLng.latitude && a.getLongitude() == latLng.longitude) {
                            lastSelectedAttraction = a;
                            lastSelectedMuseum=null;
                            lastSelectedCityInstitution=null;
                            lastSelectedHotel=null;
                            lastSelectedEvent=null;
                            lastSelectedRestaurant=null;
                            imageBadgeMap.setImageResource(R.drawable.ic_action_attraction);
                            find = true;
                            break;
                        }
                    }
                }
                if (!find) {
                    for (CityInstitution s : cityInstitutionList) {
                        if (s.getLatitude() == latLng.latitude && s.getLongitude() == latLng.longitude) {
                            lastSelectedCityInstitution = s;
                            lastSelectedMuseum=null;
                            lastSelectedAttraction=null;
                            lastSelectedHotel=null;
                            lastSelectedEvent=null;
                            lastSelectedRestaurant=null;
                            imageBadgeMap.setImageResource(R.drawable.ic_action_city_institution);
                            find = true;
                            break;
                        }
                    }
                }
                if (!find) {
                    for (Hotel h : hotelList) {
                        if (h.getLatitude() == latLng.latitude && h.getLongitude() == latLng.longitude) {
                            lastSelectedHotel = h;
                            lastSelectedCityInstitution = null;
                            lastSelectedMuseum=null;
                            lastSelectedAttraction=null;
                            lastSelectedEvent=null;
                            lastSelectedRestaurant=null;
                            imageBadgeMap.setImageResource(R.drawable.ic_action_hotel);
                            find = true;
                            break;
                        }
                    }
                }
                if (!find) {
                    for (Event e : eventList) {
                        if (e.getLatitude() == latLng.latitude && e.getLongitude() == latLng.longitude) {
                            lastSelectedEvent = e;
                            lastSelectedMuseum=null;
                            lastSelectedHotel=null;
                            lastSelectedAttraction=null;
                            lastSelectedCityInstitution=null;
                            lastSelectedRestaurant=null;
                            imageBadgeMap.setImageResource(R.drawable.ic_action_event);
                            find = true;
                            break;
                        }
                    }
                }
                if (!find) {
                    for (Restaurant r : restaurantList) {
                        if (r.getLatitude() == latLng.latitude && r.getLongitude() == latLng.longitude) {
                            lastSelectedRestaurant = r;
                            lastSelectedMuseum=null;
                            lastSelectedHotel=null;
                            lastSelectedAttraction=null;
                            lastSelectedCityInstitution=null;
                            lastSelectedEvent = null;
                            imageBadgeMap.setImageResource(R.drawable.ic_action_restaurant);
                            find = true;
                            break;
                        }
                    }
                }
            }

            String title = marker.getTitle();
            TextView titleUi = ((TextView) view.findViewById(R.id.titleMarker));
            if (title != null) {
                // Spannable string allows us to edit the formatting of the text.
                SpannableString titleText = new SpannableString(title);
                titleText.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark)), 0, titleText.length(), 0);
                titleUi.setText(titleText);
            } else {
                titleUi.setText("");
            }
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
