package org.unibl.etf.cityofnis.adapter;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.unibl.etf.cityofnis.R;

import org.unibl.etf.cityofnis.dto.Restaurant;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RestaurantAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Restaurant> listRestaurant = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private String language;


    public RestaurantAdapter(Context context, List<Restaurant> list) {
        this.context = context;
        this.listRestaurant = list;
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
        listRestaurant.clear();
        notifyDataSetChanged();
    }

    public void setFilter(List<Restaurant> list){
        this.listRestaurant=new ArrayList<>();
        this.listRestaurant.addAll(list);
        notifyDataSetChanged();
    }


    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewRestaurant;
        private ImageView imageViewRestaurant;
        private ToggleButton toggleButtonRestaurant;


        public RestaurantViewHolder(View itemView) {
            super(itemView);
            textViewRestaurant = itemView.findViewById(R.id.restaurant_item_name);
            imageViewRestaurant = itemView.findViewById(R.id.restaurant_item_image_view);
            toggleButtonRestaurant=itemView.findViewById(R.id.restaurant_toggle_button);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.restaurant_list_item,parent,false);
        RestaurantAdapter.RestaurantViewHolder holder = new RestaurantAdapter.RestaurantViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof RestaurantAdapter.RestaurantViewHolder){
            RestaurantAdapter.RestaurantViewHolder myViewHolder= (RestaurantAdapter.RestaurantViewHolder)holder;
            myViewHolder.textViewRestaurant.setText(listRestaurant.get(position).getNameEn());
            if ("en".equals(language)) {

                myViewHolder.textViewRestaurant.setText(listRestaurant.get(position).getNameEn());

            }else{
                myViewHolder.textViewRestaurant.setText(listRestaurant.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
            try {



                resourceId = resources.getIdentifier(listRestaurant.get(position).getImage(), "drawable",
                        context.getPackageName());
                //  resources.getDrawable(resourceId);

                myViewHolder.imageViewRestaurant.setImageDrawable(resources.getDrawable(resourceId));
                myViewHolder.toggleButtonRestaurant.setChecked(listRestaurant.get(position).isFavourite());
                myViewHolder.toggleButtonRestaurant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        buttonView.setChecked(isChecked);
                        listRestaurant.get(position).setFavourite(isChecked);
                        AppController.appDatabase.restaurantDAO().update(listRestaurant.get(position));
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return listRestaurant.size();
    }

    public Restaurant getRestaurantItem(int position){
        return listRestaurant.get(position);
    }


}

