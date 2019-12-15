package org.unibl.etf.cityofnis.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.activity.MuseumPreviewActivity;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class MuseumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Museum> listMuseums = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private String language;


    public MuseumAdapter(Context context, List<Museum> list) {
        this.context = context;
        this.listMuseums = list;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_key), MODE_PRIVATE);
        language = sharedPreferences.getString(context.getString(R.string.shared_preferences_locale_key), context.getString(R.string.language_value_en));

    }


    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void clear(){
        listMuseums.clear();
        notifyDataSetChanged();
    }

    public void setFilter(List<Museum> list){
        this.listMuseums=new ArrayList<>();
        this.listMuseums.addAll(list);
        notifyDataSetChanged();
    }


    public class MuseumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewMuseum;
        private ImageView imageViewMuseum;
        private ToggleButton toggleButtonMuseum;


        public MuseumViewHolder(View itemView) {
            super(itemView);
            textViewMuseum = itemView.findViewById(R.id.museum_item_name);
            imageViewMuseum = itemView.findViewById(R.id.museum_item_image_view);
            toggleButtonMuseum=itemView.findViewById(R.id.museum_toggle_button);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public MuseumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.museum_list_item,parent,false);
        MuseumViewHolder holder = new MuseumViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof MuseumViewHolder){
            MuseumViewHolder myViewHolder= (MuseumViewHolder)holder;
            myViewHolder.textViewMuseum.setText(listMuseums.get(position).getNameEn());
            if ("en".equals(language)) {

                myViewHolder.textViewMuseum.setText(listMuseums.get(position).getNameEn());

            }else{
                myViewHolder.textViewMuseum.setText(listMuseums.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
try {



             resourceId = resources.getIdentifier(listMuseums.get(position).getImage(), "drawable",
                    context.getPackageName());
          //  resources.getDrawable(resourceId);

            myViewHolder.imageViewMuseum.setImageDrawable(resources.getDrawable(resourceId));
            myViewHolder.toggleButtonMuseum.setChecked(listMuseums.get(position).isFavourite());
            myViewHolder.toggleButtonMuseum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    buttonView.setChecked(isChecked);
                    listMuseums.get(position).setFavourite(isChecked);
                    AppController.appDatabase.museumDAO().update(listMuseums.get(position));
                }
            });
}catch (Exception e){
    e.printStackTrace();
}
        }
    }

    @Override
    public int getItemCount() {
        return listMuseums.size();
    }

    public Museum getMuseumItem(int position){
        return listMuseums.get(position);
    }


}
