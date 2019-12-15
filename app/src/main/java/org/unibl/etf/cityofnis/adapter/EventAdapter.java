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

import org.unibl.etf.cityofnis.dto.Event;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Event> listEvent = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private String language;


    public EventAdapter(Context context, List<Event> list) {
        this.context = context;
        this.listEvent = list;
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
        listEvent.clear();
        notifyDataSetChanged();
    }

    public void setFilter(List<Event> list){
        this.listEvent=new ArrayList<>();
        this.listEvent.addAll(list);
        notifyDataSetChanged();
    }


    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewEvent;
        private ImageView imageViewEvent;
        private ToggleButton toggleButtonEvent;


        public EventViewHolder(View itemView) {
            super(itemView);
            textViewEvent = itemView.findViewById(R.id.event_item_name);
           imageViewEvent = itemView.findViewById(R.id.event_item_image_view);
            toggleButtonEvent=itemView.findViewById(R.id.event_toggle_button);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.event_list_item,parent,false);
        EventAdapter.EventViewHolder holder = new EventAdapter.EventViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof EventAdapter.EventViewHolder){
            EventAdapter.EventViewHolder myViewHolder= (EventAdapter.EventViewHolder)holder;
            myViewHolder.textViewEvent.setText(listEvent.get(position).getNameEn());
            if ("en".equals(language)) {

                myViewHolder.textViewEvent.setText(listEvent.get(position).getNameEn());

            }else{
                myViewHolder.textViewEvent.setText(listEvent.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
            try {



                resourceId = resources.getIdentifier(listEvent.get(position).getImage(), "drawable",
                        context.getPackageName());


                myViewHolder.imageViewEvent.setImageDrawable(resources.getDrawable(resourceId));
                myViewHolder.toggleButtonEvent.setChecked(listEvent.get(position).isFavourite());
                myViewHolder.toggleButtonEvent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        buttonView.setChecked(isChecked);
                        listEvent.get(position).setFavourite(isChecked);
                        AppController.appDatabase.eventDAO().update(listEvent.get(position));
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }

    public Event getEventItem(int position){
        return listEvent.get(position);
    }


}

