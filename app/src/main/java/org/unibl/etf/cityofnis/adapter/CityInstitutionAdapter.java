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

import org.unibl.etf.cityofnis.dto.CityInstitution;
import org.unibl.etf.cityofnis.util.AppController;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class CityInstitutionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<CityInstitution> listCityInstitution = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private String language;


    public CityInstitutionAdapter(Context context, List<CityInstitution> list) {
        this.context = context;
        this.listCityInstitution = list;
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
        listCityInstitution.clear();
        notifyDataSetChanged();
    }

    public void setFilter(List<CityInstitution> list){
        this.listCityInstitution=new ArrayList<>();
        this.listCityInstitution.addAll(list);
        notifyDataSetChanged();
    }


    public class CityInstitutionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewCityInstitution;
        private ImageView imageViewCityInstitution;
        private ToggleButton toggleButtonCityInstitution;


        public CityInstitutionViewHolder(View itemView) {
            super(itemView);
            textViewCityInstitution = itemView.findViewById(R.id.city_institution_item_name);
            imageViewCityInstitution = itemView.findViewById(R.id.city_institution_item_image_view);
            toggleButtonCityInstitution=itemView.findViewById(R.id.city_institution_toggle_button);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public CityInstitutionAdapter.CityInstitutionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.city_institution_list_item,parent,false);
        CityInstitutionAdapter.CityInstitutionViewHolder holder = new CityInstitutionAdapter.CityInstitutionViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof CityInstitutionAdapter.CityInstitutionViewHolder){
            CityInstitutionAdapter.CityInstitutionViewHolder myViewHolder= (CityInstitutionAdapter.CityInstitutionViewHolder)holder;
            myViewHolder.textViewCityInstitution.setText(listCityInstitution.get(position).getNameEn());
            if ("en".equals(language)) {

                myViewHolder.textViewCityInstitution.setText(listCityInstitution.get(position).getNameEn());

            }else{
                myViewHolder.textViewCityInstitution.setText(listCityInstitution.get(position).getNameSr());

            }

            Resources resources = context.getResources();
            final int resourceId;
            try {



                resourceId = resources.getIdentifier(listCityInstitution.get(position).getImage(), "drawable",
                        context.getPackageName());


                myViewHolder.imageViewCityInstitution.setImageDrawable(resources.getDrawable(resourceId));
                myViewHolder.toggleButtonCityInstitution.setChecked(listCityInstitution.get(position).isFavourite());
                myViewHolder.toggleButtonCityInstitution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        buttonView.setChecked(isChecked);
                        listCityInstitution.get(position).setFavourite(isChecked);
                        AppController.appDatabase.cityInstitutionDAO().update(listCityInstitution.get(position));
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return listCityInstitution.size();
    }

    public CityInstitution getCityInstitutionItem(int position){
        return listCityInstitution.get(position);
    }


}
