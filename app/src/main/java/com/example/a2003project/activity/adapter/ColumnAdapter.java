package com.example.a2003project.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a2003project.R;

public class ColumnAdapter extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;
    private Context context;

    public ColumnAdapter(GridLayoutHelper gridLayoutHelper, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_coulumn, parent, false);
        return new ColumnAdapter.GridViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ColumnAdapter.GridViewHolder viewHolder = (ColumnAdapter.GridViewHolder) holder;
        if (position == 0) {
            Glide.with(context).load("http://cdwan.cn/www/static/channel/ic_jujia.png").into(((GridViewHolder) holder).textView);
        } else if (position == 1) {
            Glide.with(context).load("http://cdwan.cn/www/static/channel/ic_canchu.png").into(((GridViewHolder) holder).textView);
        } else if (position == 2) {
            Glide.with(context).load("http://cdwan.cn/www/static/channel/ic_peijian.png").into(((GridViewHolder) holder).textView);
        } else if (position == 3) {
            Glide.with(context).load("http://cdwan.cn/www/static/channel/ic_dress.png").into(((GridViewHolder) holder).textView);
        } else if (position == 4) {
            Glide.with(context).load("http://cdwan.cn/www/static/channel/ic_game.png").into(((GridViewHolder) holder).textView);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView textView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.grid_my_image);
        }
    }

}
