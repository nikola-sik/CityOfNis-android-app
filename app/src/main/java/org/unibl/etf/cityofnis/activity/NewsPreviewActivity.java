package org.unibl.etf.cityofnis.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.dto.News;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Locale;

import javax.annotation.Nullable;

public class NewsPreviewActivity extends AppCompatActivity {

    private WebView webview;
    public ProgressBar progressBar;
    public String link;
    private Toolbar toolbar;
    String lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

          super.onCreate(savedInstanceState);

       ////////////
        lang=getIntent().getExtras().getString("lang");
//////////////////
        setContentView(R.layout.activity_news_preview);

        toolbar = (Toolbar) findViewById(R.id.news_preview_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        link=getIntent().getExtras().getString("link");
        webview = findViewById(R.id.web_view_news);


        progressBar = (ProgressBar) findViewById(R.id.progress_bar_news);

        webview.setWebViewClient(new myWebClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        if(isNetworkConnected())
        webview.loadUrl(link);
else webview.loadData(getString(R.string.no_internet_connection), "text/html; charset=utf-8", "utf-8");
    }


    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
          // progressBar.setVisibility(View.VISIBLE);
            if (url.equals(link)) {
               progressBar.setVisibility(View.VISIBLE);
                view.loadUrl(url);
            }

            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                NewsPreviewActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

    }




}

