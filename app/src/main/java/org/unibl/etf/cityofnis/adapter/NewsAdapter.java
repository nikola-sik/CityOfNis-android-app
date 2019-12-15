package org.unibl.etf.cityofnis.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.unibl.etf.cityofnis.R;
import org.unibl.etf.cityofnis.dto.News;
import org.unibl.etf.cityofnis.util.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> newsList = new ArrayList<>();
    private Context context;
    private ItemClickListener itemClickListener;
    private View.OnClickListener onClickListener;


    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }


    public Context getContext() {
        return context;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView newsTitle;
        public TextView newsShortDescription;
        public ImageView newsImage;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            newsTitle = v.findViewById(R.id.news_item_title);
            newsShortDescription=v.findViewById(R.id.news_item_short_description);
            newsImage = (ImageView) v.findViewById(R.id.news_item_image_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.onClick(v, getAdapterPosition());
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ViewHolder) {
            ViewHolder myViewHolder = (ViewHolder) viewHolder;
            myViewHolder.newsTitle.setText(newsList.get(position).getTitle());
            myViewHolder.newsShortDescription.setText(newsList.get(position).getShortDescription());
            if("none".equals(newsList.get(position).getImageUrl()))
                myViewHolder.newsImage.setImageResource(R.drawable.news);
            else
            Glide.with(context).load(newsList.get(position).getImageUrl()).into(myViewHolder.newsImage);
        }

    }

    @Override
    public int getItemCount() {
        if( newsList == null)  return 0;
        else
        return newsList.size();

    }

    public News getNews(int pos) {
        return newsList.get(pos);
    }

    public void setFilter(List<News> list){
        newsList=new ArrayList<>();
        newsList.addAll(list);
        notifyDataSetChanged();
    }
}
