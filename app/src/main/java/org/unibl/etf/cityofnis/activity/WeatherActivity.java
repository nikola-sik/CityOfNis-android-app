package org.unibl.etf.cityofnis.activity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.util.VolleyHelper;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherActivity extends AppCompatActivity {


    String weatherUrl;
    TextView humidity;
    TextView pressure;
    TextView description;
    TextView currentTemperature;
    TextView wind;
    ImageView weatherIcon;
    private  String idIcon;

    String language;
    String languageWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.weather_forecast);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        language = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key), getString(R.string.language_value_en));
        languageWeather = "sr".equals(language) ? "hr" : "en";
        weatherUrl="http://api.openweathermap.org/data/2.5/weather?lang="+languageWeather+"&units=metric&q=Nis&appid=8e38ad07b270d24984b83881bf0f59bd";
        humidity=(TextView)findViewById(R.id.textViewWeatherHumidity);
        currentTemperature=(TextView)findViewById(R.id.textViewTemperature);
        pressure=(TextView)findViewById(R.id.textViewWeatherPressure);
        description=(TextView)findViewById(R.id.textViewWeatherDescription);
        weatherIcon=(ImageView)findViewById(R.id.imageViewWeather);
        wind=(TextView) findViewById(R.id.textViewWeatherWind);
        // Initialize a new JsonObjectRequest instance
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                weatherUrl,
                 null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        try{

                                 JSONObject jsonObject = response.getJSONObject("main");
                            currentTemperature.setText(jsonObject.getString("temp")+" ℃");
                            pressure.setText(getString(R.string.pressure)+" "+jsonObject.getString("pressure")+" hPa");

                            humidity.setText(getString(R.string.humidity)+" "+jsonObject.getString("humidity")+" %");
                            jsonObject = response.getJSONObject("wind");

                            wind.setText(getString(R.string.wind_speed)+" "+jsonObject.getString("speed")+" m/s");
                            JSONArray jsonArray = response.getJSONArray("weather");
                            description.setText(jsonArray.getJSONObject(0).getString("description"));
                            idIcon=jsonArray.getJSONObject(0).getString("icon");
                            Resources resources = WeatherActivity.this.getResources();
                            final int resourceId = resources.getIdentifier("w"+idIcon, "drawable",
                                    WeatherActivity.this.getPackageName());

                            weatherIcon.setImageDrawable(resources.getDrawable(resourceId));
                            if(idIcon.contains("n")){
                                viewGroup.setBackgroundColor(getResources().getColor(R.color.weatherNight));
                                currentTemperature.setTextColor(getResources().getColor(R.color.weatherNightText));
                                description.setTextColor(getResources().getColor(R.color.weatherNightText));
                                wind.setTextColor(getResources().getColor(R.color.weatherNightText));
                                pressure.setTextColor(getResources().getColor(R.color.weatherNightText));
                                humidity.setTextColor(getResources().getColor(R.color.weatherNightText));
                            }else {
                                viewGroup.setBackgroundColor(getResources().getColor(R.color.weatherDay));
                                currentTemperature.setTextColor(getResources().getColor(R.color.weatherDayText));
                                description.setTextColor(getResources().getColor(R.color.weatherDayText));
                                wind.setTextColor(getResources().getColor(R.color.weatherDayText));
                                pressure.setTextColor(getResources().getColor(R.color.weatherDayText));
                                humidity.setTextColor(getResources().getColor(R.color.weatherDayText));
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred
                        Toast.makeText(WeatherActivity.this, getString(R.string.toast_service_not_available),
                                Toast.LENGTH_LONG).show();
                    }
                }
        );

        // Add JsonObjectRequest to the RequestQueue
        VolleyHelper.getVolleyHelperInstance(WeatherActivity.this).addToRequesQueue(jsonObjectRequest);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case android.R.id.home:
                WeatherActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() { ;
        super.onDestroy();
    }


}
