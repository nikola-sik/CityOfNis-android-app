package org.unibl.etf.cityofnis.adapter;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.unibl.etf.cityofnis.R;

import org.unibl.etf.cityofnis.dto.Liked;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class LikedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private List<Liked> listLiked = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private String language;


    public LikedAdapter(Context context, List<Liked> list) {
        this.context = context;
        this.listLiked = list;
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
        listLiked.clear();
        notifyDataSetChanged();
    }

    public void setFilter(List<Liked> list){
        this.listLiked=new ArrayList<>();
        this.listLiked.addAll(list);
        notifyDataSetChanged();
    }


    public class LikedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewLiked;
        private ImageView imageViewLiked;
        private ToggleButton toggleButtonLiked;


        public LikedViewHolder(View itemView) {
            super(itemView);
            textViewLiked = itemView.findViewById(R.id.liked_item_name);
            imageViewLiked = itemView.findViewById(R.id.liked_item_image_view);
            toggleButtonLiked=itemView.findViewById(R.id.liked_toggle_button);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public LikedAdapter.LikedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.liked_list_item,parent,false);
        LikedAdapter.LikedViewHolder holder = new LikedAdapter.LikedViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof LikedAdapter.LikedViewHolder){
           final   LikedAdapter.LikedViewHolder myViewHolder= (LikedAdapter.LikedViewHolder)holder;

            myViewHolder.toggleButtonLiked.setChecked(listLiked.get(position).isFavourite());



            myViewHolder.toggleButtonLiked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              //  LikedAdapter.LikedViewHolder myholder=myViewHolder;

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    buttonView.setChecked(isChecked);
                  listLiked.get(myViewHolder.getAdapterPosition()).setFavourite(isChecked);

                    if(!isChecked){

                        AppController.appDatabase.museumDAO().updateLiked(listLiked.get(myViewHolder.getAdapterPosition()).getNameEn());
                        AppController.appDatabase.attractionDAO().updateLiked(listLiked.get(myViewHolder.getAdapterPosition()).getNameEn());
                        AppController.appDatabase.cityInstitutionDAO().updateLiked(listLiked.get(myViewHolder.getAdapterPosition()).getNameEn());
                        AppController.appDatabase.hotelDAO().updateLiked(listLiked.get(myViewHolder.getAdapterPosition()).getNameEn());

                        AppController.appDatabase.eventDAO().updateLiked(listLiked.get(myViewHolder.getAdapterPosition()).getNameEn());
                        AppController.appDatabase.restaurantDAO().updateLiked(listLiked.get(myViewHolder.getAdapterPosition()).getNameEn());
                        AppController.appDatabase.adventureDAO().updateLiked(listLiked.get(myViewHolder.getAdapterPosition()).getNameEn());

                        listLiked.remove(myViewHolder.getAdapterPosition());
                        notifyItemRemoved(myViewHolder.getAdapterPosition());
                        notifyItemRangeChanged(myViewHolder.getAdapterPosition(),listLiked.size());

                    }


                }
            });



            if ("en".equals(language)) {

                myViewHolder.textViewLiked.setText(listLiked.get(position).getNameEn());
            }else{
                myViewHolder.textViewLiked.setText(listLiked.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
            try {



                resourceId = resources.getIdentifier(listLiked.get(myViewHolder.getAdapterPosition()).getImage(), "drawable",
                        context.getPackageName());


                myViewHolder.imageViewLiked.setImageDrawable(resources.getDrawable(resourceId));

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return listLiked.size();
    }

    public Liked getLikedItem(int position){
        return listLiked.get(position);
    }


}
