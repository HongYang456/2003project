package com.example.a2003project.activity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.a2003project.R;
import com.example.a2003project.activity.utils.BannerLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TextView tv_sousuo;
    private RecyclerView recycler;
    private Banner banner;
    private String BannerUrl1 = "http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg";
    private String BannerUrl2 = "http://yanxuan.nosdn.127.net/bff2e49136fcef1fd829f5036e07f116.jpg";
    private String BannerUrl3 = "http://yanxuan.nosdn.127.net/8e50c65fda145e6dd1bf4fb7ee0fcecc.jpg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        BannerData();
        return inflate;
    }

    private void initView(View inflate) {
        tv_sousuo = inflate.findViewById(R.id.tv_sousuo);
        banner = inflate.findViewById(R.id.banner);
        recycler = inflate.findViewById(R.id.recycler);

        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        // 将VirtualLayoutManager绑定到recyclerView
        recycler.setLayoutManager(virtualLayoutManager);
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
    }

    private void BannerData() {
        List list = new ArrayList<>();
        list.add(BannerUrl1);
        list.add(BannerUrl2);
        list.add(BannerUrl3);
        List titles =new ArrayList<>();
        titles.add("合作 谁是你的菜");
        titles.add("活动 美食节");
        titles.add("活动 母亲节");

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new BannerLoader());
        banner.setImages(list);
        banner.setBannerAnimation(Transformer.Default);
        banner.setBannerTitles(titles);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER)
                .start();
    }
}