package com.example.a2003project.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a2003project.R;
import com.example.a2003project.activity.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataDTO.BannerDTO> mBannerList;
    private LayoutInflater mInflater;
    public BannerAdapter(Context context, ArrayList<HomeBean.DataDTO.BannerDTO> mBannerList) {
        this.context = context;
        this.mBannerList = mBannerList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerVH(mInflater.inflate(R.layout.item_banner,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BannerVH bannerVH = (BannerVH) holder;
        bannerVH.mBanner.setImages(mBannerList)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        //path类型是由setImages(mBannerList),mBannerList的泛型,也就是BannerBean.DataBean
                        HomeBean.DataDTO.BannerDTO bean = (HomeBean.DataDTO.BannerDTO) path;
                        Glide.with(context).load(bean.getImage_url()).into(imageView);
                    }
                })
                .start();
    }

    @Override
    public int getItemCount() {
        return mBannerList.size();
    }
    public void addBanner(ArrayList<HomeBean.DataDTO.BannerDTO> data) {
        mBannerList.addAll(data);
        notifyDataSetChanged();
    }

    class BannerVH extends RecyclerView.ViewHolder{

        private final Banner mBanner;

        public BannerVH(@NonNull View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.banner);
        }
    }
}
