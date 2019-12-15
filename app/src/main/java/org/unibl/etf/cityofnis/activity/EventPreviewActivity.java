package org.unibl.etf.cityofnis.activity;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.dto.Event;


public class EventPreviewActivity extends AppCompatActivity {

    private Event item = new Event();
    private ImageView image;
    private TextView name;
    private LinearLayout detailsLayout;
    private TextView eventDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_preview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.event_preview_toolbar);
        toolbar.setTitle(R.string.event_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        eventDescription = (TextView)findViewById(R.id.event_description);
        name = (TextView)findViewById(R.id.event_name);
        image = (ImageView)findViewById(R.id.event_image);
        detailsLayout = (LinearLayout)findViewById(R.id.event_data_layout);

        item.setNameSr(getIntent().getExtras().getString("name"));
        item.setImage(getIntent().getExtras().getString("image"));
        item.setDescriptionSr(getIntent().getExtras().getString("description"));
        try{
            Resources resources = EventPreviewActivity.this.getResources();
            final int resourceId = resources.getIdentifier(item.getImage(), "drawable",
                    EventPreviewActivity.this.getPackageName());

            name.setText(item.getNameSr());
            eventDescription.setText(item.getDescriptionSr());
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
                EventPreviewActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}

