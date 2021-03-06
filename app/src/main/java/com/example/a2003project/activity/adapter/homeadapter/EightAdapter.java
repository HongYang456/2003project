package com.example.a2003project.activity.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a2003project.R;
import com.example.a2003project.activity.bean.HomeBean;

import java.util.ArrayList;

public class EightAdapter extends DelegateAdapter.Adapter {
    Context context;
    LayoutHelper layoutHelper;
    ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList;

    public EightAdapter(Context context, LayoutHelper layoutHelper,ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.hotGoodsList = hotGoodsList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popularity, parent, false);
        return new VhEight(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhEight vhEight= (VhEight) holder;
        HomeBean.DataDTO.HotGoodsListDTO goodsListBean = hotGoodsList.get(position);
        vhEight.name.setText(goodsListBean.getName());
        vhEight.jies.setText(goodsListBean.getGoods_brief());
        vhEight.price.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(vhEight.img);
    }

    @Override
    public int getItemCount() {
        if (hotGoodsList.size()>0){
            return hotGoodsList.size();
        }else {
            return 0;
        }
    }
    class VhEight extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView jies;
        TextView price;
        public VhEight(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.popularity_img);
            name=itemView.findViewById(R.id.popularity_name);
            jies=itemView.findViewById(R.id.popularity_jies);
            price=itemView.findViewById(R.id.popularity_price);
        }
    }
}
