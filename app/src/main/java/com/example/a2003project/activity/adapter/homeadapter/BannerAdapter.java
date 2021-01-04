package com.example.a2003project.activity.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a2003project.R;
import com.example.a2003project.activity.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.ArrayList;

public class BannerAdapter extends DelegateAdapter.Adapter {

    private LayoutHelper layoutHelper;
    private Context context;
    private ArrayList<HomeBean.DataDTO.BannerDTO> mBanner;

    public BannerAdapter(LayoutHelper layoutHelper, Context context, ArrayList<HomeBean.DataDTO.BannerDTO> mBanner) {
        this.layoutHelper = layoutHelper;
        this.context = context;
        this.mBanner = mBanner;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        vh.banner.setAdapter(new BannerImageAdapter<HomeBean.DataDTO.BannerDTO>(mBanner) {
            @Override
            public void onBindView(BannerImageHolder holder, HomeBean.DataDTO.BannerDTO data, int position, int size) {
                Glide.with(context).load(data.getImage_url()).into(holder.imageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mBanner.size()>0){
            return 1;
        }else {
            return 0;
        }
    }

    class VH extends RecyclerView.ViewHolder {

        private final Banner banner;

        public VH(View view) {
            super(view);
            banner = view.findViewById(R.id.two_ban);
        }
    }
}
