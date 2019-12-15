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
import org.unibl.etf.cityofnis.dto.Attraction;
import org.unibl.etf.cityofnis.dto.Liked;
import org.unibl.etf.cityofnis.dto.Museum;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class AttractionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private List<Attraction> listAttraction = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private String language;
    private Liked likedItem;

    public AttractionAdapter(Context context, List<Attraction> list) {
        this.context = context;
        this.listAttraction = list;
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
        listAttraction.clear();
        notifyDataSetChanged();
    }

    public void setFilter(List<Attraction> list){
        this.listAttraction=new ArrayList<>();
        this.listAttraction.addAll(list);
        notifyDataSetChanged();
    }


    public class AttractionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewAttraction;
        private ImageView imageViewAttraction;
        private ToggleButton toggleButtonAttraction;


        public AttractionViewHolder(View itemView) {
            super(itemView);
            textViewAttraction = itemView.findViewById(R.id.attraction_item_name);
            imageViewAttraction = itemView.findViewById(R.id.attraction_item_image_view);
            toggleButtonAttraction=itemView.findViewById(R.id.attraction_toggle_button);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public AttractionAdapter.AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.attraction_list_item,parent,false);
        AttractionAdapter.AttractionViewHolder holder = new AttractionAdapter.AttractionViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof AttractionAdapter.AttractionViewHolder){
            AttractionAdapter.AttractionViewHolder myViewHolder= (AttractionAdapter.AttractionViewHolder)holder;
            myViewHolder.textViewAttraction.setText(listAttraction.get(position).getNameEn());
            if ("en".equals(language)) {

                myViewHolder.textViewAttraction.setText(listAttraction.get(position).getNameEn());

            }else{
                myViewHolder.textViewAttraction.setText(listAttraction.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
            try {



                resourceId = resources.getIdentifier(listAttraction.get(position).getImage(), "drawable",
                        context.getPackageName());


                myViewHolder.imageViewAttraction.setImageDrawable(resources.getDrawable(resourceId));
                myViewHolder.toggleButtonAttraction.setChecked(listAttraction.get(position).isFavourite());
                myViewHolder.toggleButtonAttraction.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        buttonView.setChecked(isChecked);
                        listAttraction.get(position).setFavourite(isChecked);

                        AppController.appDatabase.attractionDAO().update(listAttraction.get(position));


                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return listAttraction.size();
    }

    public Attraction getAttractionItem(int position){
        return listAttraction.get(position);
    }


}
