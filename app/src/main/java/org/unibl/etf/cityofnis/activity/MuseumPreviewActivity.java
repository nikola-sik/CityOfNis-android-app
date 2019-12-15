package org.unibl.etf.cityofnis.activity;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.dto.Museum;

public class MuseumPreviewActivity extends AppCompatActivity {


    private Museum item = new Museum();
    private ImageView image;
    private TextView name;
    private LinearLayout detailsLayout;
    private TextView museumDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_preview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.museum_preview_toolbar);
        toolbar.setTitle(R.string.museum_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        museumDescription = (TextView)findViewById(R.id.museum_description);
        name = (TextView)findViewById(R.id.museum_name);
        image = (ImageView)findViewById(R.id.museum_image);
        detailsLayout = (LinearLayout)findViewById(R.id.museum_data_layout);

        item.setNameSr(getIntent().getExtras().getString("name"));
        item.setImage(getIntent().getExtras().getString("image"));
        item.setDescriptionSr(getIntent().getExtras().getString("description"));
try{
        Resources resources = MuseumPreviewActivity.this.getResources();
        final int resourceId = resources.getIdentifier(item.getImage(), "drawable",
                MuseumPreviewActivity.this.getPackageName());

        name.setText(item.getNameSr());
        museumDescription.setText(item.getDescriptionSr());
        image.setImageDrawable(resources.getDrawable(resourceId));
        detailsLayout.setVisibility(View.VISIBLE);

}catch (Exception e){

    e.printStackTrace();
}


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case android.R.id.home:
                MuseumPreviewActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
