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
import org.unibl.etf.cityofnis.dto.Adventure;


public class AdventurePreviewActivity extends AppCompatActivity {



    private Adventure item = new Adventure();
    private ImageView image;
    private TextView name;
    private LinearLayout detailsLayout;
    private TextView adventureDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_preview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.adventure_preview_toolbar);
        toolbar.setTitle(R.string.adventure_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        adventureDescription = (TextView)findViewById(R.id.adventure_description);
        name = (TextView)findViewById(R.id.adventure_name);
        image = (ImageView)findViewById(R.id.adventure_image);
        detailsLayout = (LinearLayout)findViewById(R.id.adventure_data_layout);

        item.setNameSr(getIntent().getExtras().getString("name"));
        item.setImage(getIntent().getExtras().getString("image"));
        item.setDescriptionSr(getIntent().getExtras().getString("description"));
        try{
            Resources resources = AdventurePreviewActivity.this.getResources();
            final int resourceId = resources.getIdentifier(item.getImage(), "drawable",
                    AdventurePreviewActivity.this.getPackageName());

            name.setText(item.getNameSr());
            adventureDescription.setText(item.getDescriptionSr());
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
                AdventurePreviewActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
