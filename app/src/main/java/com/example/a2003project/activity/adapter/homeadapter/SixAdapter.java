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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a2003project.R;
import com.example.a2003project.activity.bean.HomeBean;

import java.util.ArrayList;

public class SixAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LayoutHelper layoutHelper;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newgoods;

    public SixAdapter(Context context, LayoutHelper layoutHelper, ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newgoods) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.newgoods = newgoods;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.products, parent, false);
        return new VhSix(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhSix vhSix= (VhSix) holder;
        HomeBean.DataDTO.NewGoodsListDTO goodsListBean = newgoods.get(position);
        vhSix.name.setText(goodsListBean.getName());
        vhSix.price.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(vhSix.img);
    }

    @Override
    public int getItemCount() {
        if (newgoods.size()>0){
            return newgoods.size();
        }else {
            return 0;
        }
    }
    class VhSix extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name;
        TextView price;
        public VhSix(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.products_img);
            name=itemView.findViewById(R.id.products_name);
            price=itemView.findViewById(R.id.products_price);
        }
    }
}
