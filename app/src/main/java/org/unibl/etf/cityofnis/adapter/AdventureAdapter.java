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

import org.unibl.etf.cityofnis.dto.Adventure;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class AdventureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private Context context;
private List<Adventure> listAdventure = new ArrayList<>();
private ItemClickListener itemClickListener;
private String language;


public AdventureAdapter(Context context, List<Adventure> list) {
        this.context = context;
        this.listAdventure = list;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_key), Context.MODE_PRIVATE);
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
        listAdventure.clear();
        notifyDataSetChanged();
        }

public void setFilter(List<Adventure> list){
        this.listAdventure=new ArrayList<>();
        this.listAdventure.addAll(list);
        notifyDataSetChanged();
        }


public class AdventureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView textViewAdventure;
    private ImageView imageViewAdventure;
    private ToggleButton toggleButtonAdventure;


    public AdventureViewHolder(View itemView) {
        super(itemView);
        textViewAdventure = itemView.findViewById(R.id.adventure_item_name);
        imageViewAdventure = itemView.findViewById(R.id.adventure_item_image_view);
        toggleButtonAdventure=itemView.findViewById(R.id.adventure_toggle_button);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }
}

    @Override
    public AdventureAdapter.AdventureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adventure_list_item,parent,false);
        AdventureAdapter.AdventureViewHolder holder = new AdventureAdapter.AdventureViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof AdventureAdapter.AdventureViewHolder){
            AdventureAdapter.AdventureViewHolder myViewHolder= (AdventureAdapter.AdventureViewHolder)holder;
            myViewHolder.textViewAdventure.setText(listAdventure.get(position).getNameEn());
            if ("en".equals(language)) {

                myViewHolder.textViewAdventure.setText(listAdventure.get(position).getNameEn());

            }else{
                myViewHolder.textViewAdventure.setText(listAdventure.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
            try {



                resourceId = resources.getIdentifier(listAdventure.get(position).getImage(), "drawable",
                        context.getPackageName());
                //  resources.getDrawable(resourceId);

                myViewHolder.imageViewAdventure.setImageDrawable(resources.getDrawable(resourceId));
                myViewHolder.toggleButtonAdventure.setChecked(listAdventure.get(position).isFavourite());
                myViewHolder.toggleButtonAdventure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        buttonView.setChecked(isChecked);
                        listAdventure.get(position).setFavourite(isChecked);
                        AppController.appDatabase.adventureDAO().update(listAdventure.get(position));
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return listAdventure.size();
    }

    public Adventure getAdventureItem(int position){
        return listAdventure.get(position);
    }


}

