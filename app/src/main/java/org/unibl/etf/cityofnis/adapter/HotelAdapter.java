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

import org.unibl.etf.cityofnis.dto.Hotel;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class HotelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Hotel> listHotel = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private String language;


    public HotelAdapter(Context context, List<Hotel> list) {
        this.context = context;
        this.listHotel = list;
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
        listHotel.clear();
        notifyDataSetChanged();
    }

    public void setFilter(List<Hotel> list){
        this.listHotel=new ArrayList<>();
        this.listHotel.addAll(list);
        notifyDataSetChanged();
    }


    public class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewHotel;
        private ImageView imageViewHotel;
        private ToggleButton toggleButtonHotel;


        public HotelViewHolder(View itemView) {
            super(itemView);
            textViewHotel = itemView.findViewById(R.id.hotel_item_name);
            imageViewHotel = itemView.findViewById(R.id.hotel_item_image_view);
            toggleButtonHotel=itemView.findViewById(R.id.hotel_toggle_button);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public HotelAdapter.HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.hotel_list_item,parent,false);
        HotelAdapter.HotelViewHolder holder = new HotelAdapter.HotelViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof HotelAdapter.HotelViewHolder){
            HotelAdapter.HotelViewHolder myViewHolder= (HotelAdapter.HotelViewHolder)holder;
            myViewHolder.textViewHotel.setText(listHotel.get(position).getNameEn());
            if ("en".equals(language)) {

                myViewHolder.textViewHotel.setText(listHotel.get(position).getNameEn());

            }else{
                myViewHolder.textViewHotel.setText(listHotel.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
            try {



                resourceId = resources.getIdentifier(listHotel.get(position).getImage(), "drawable",
                        context.getPackageName());


                myViewHolder.imageViewHotel.setImageDrawable(resources.getDrawable(resourceId));
                myViewHolder.toggleButtonHotel.setChecked(listHotel.get(position).isFavourite());
                myViewHolder.toggleButtonHotel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        buttonView.setChecked(isChecked);
                        listHotel.get(position).setFavourite(isChecked);
                        AppController.appDatabase.hotelDAO().update(listHotel.get(position));
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return listHotel.size();
    }

    public Hotel getHotelItem(int position){
        return listHotel.get(position);
    }


}

