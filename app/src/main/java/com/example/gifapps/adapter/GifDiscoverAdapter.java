package com.example.gifapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gifapps.R;
import com.example.gifapps.model.gif.GifDiscoverResultsItem;

import java.util.ArrayList;

public class GifDiscoverAdapter extends RecyclerView.Adapter<GifDiscoverAdapter.ViewHolder> {

    private ArrayList<GifDiscoverResultsItem> gifDiscoverItems = new ArrayList<>();
    private Context context;

    public GifDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<GifDiscoverResultsItem> items){
        gifDiscoverItems.clear();
        gifDiscoverItems.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GifDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GifDiscoverAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(gifDiscoverItems.get(position)
                .getMedia().get(0).getGif().getUrl())
                .into(holder.ivThumb);

    }

    @Override
    public int getItemCount() {
        return gifDiscoverItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
        }
    }
}
