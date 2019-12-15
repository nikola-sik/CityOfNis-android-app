package org.unibl.etf.cityofnis.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import org.unibl.etf.cityofnis.R;

import java.util.Locale;
@SuppressWarnings("deprecation")
public class SettingsActivity  extends PreferenceActivity{


    private ListPreference languageListPreference;
    private CheckBoxPreference cachingNewsDataCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addPreferencesFromResource(R.xml.preferences);
        setTitle(R.string.action_settings);
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        String localePref = sharedPreferences.getString(getString(R.string.shared_preferences_locale_key),getString(R.string.language_value_en));
        Locale locale = new Locale(localePref);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        languageListPreference = (ListPreference) findPreference(getString(R.string.language_preference_key));
        if("en".equals(localePref)){
            languageListPreference.setValue(getString(R.string.language_value_en));
        }else{
            languageListPreference.setValue(getString(R.string.language_value_sr));
        }





        SharedPreferences sharedPreferencesCaching = getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
        final boolean cachingNewsDataPref = sharedPreferencesCaching.getBoolean(getString(R.string.caching_news_data_boolean), true);
        cachingNewsDataCheckBox = (CheckBoxPreference) findPreference(getString(R.string.caching_preference_key));
        if (cachingNewsDataPref) {
            cachingNewsDataCheckBox.setChecked(cachingNewsDataPref);
        } else {
            cachingNewsDataCheckBox.setChecked(cachingNewsDataPref);
        }
        cachingNewsDataCheckBox.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue instanceof Boolean && newValue != null) {
                    Boolean cachingNewsData = (Boolean) newValue;
                    cachingNewsDataCheckBox.setChecked(cachingNewsData);
                    SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(getString(R.string.caching_news_data_boolean), cachingNewsData);
                    editor.apply();
                    recreate();
                }
                return false;
            }
        });






        //language
        languageListPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Locale locale = null;

                if (o.toString().equals(getString(R.string.language_value_en))) {
                    locale = new Locale(getString(R.string.language_value_en));
                } else {
                    locale = new Locale(getString(R.string.language_value_sr));
                }
                Locale.setDefault(locale);
                Resources resources = getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.locale = locale;
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());

                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences_key), MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.string.shared_preferences_locale_key), locale.getLanguage());
                editor.apply();
                restartActivity();

                return false;
            }
        });

    }


    private void restartActivity(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        restartActivity();
    }



}
