package com.example.a2003project.activity.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.a2003project.R;
import com.example.a2003project.activity.adapter.BannerAdapter;
import com.example.a2003project.activity.adapter.FiveAdapter;
import com.example.a2003project.activity.adapter.ForeAdapter;
import com.example.a2003project.activity.adapter.SousuoAdapter;
import com.example.a2003project.activity.adapter.ThreeAdapter;
import com.example.a2003project.activity.adapter.TwoColumnAdapter;
import com.example.a2003project.activity.bean.HomeBean;
import com.example.a2003project.activity.constans.HomeConstarts;
import com.example.a2003project.activity.presenter.HomePresenter;
import com.example.mvp.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeConstarts.HomeView {

    private RecyclerView recycler;

    private VirtualLayoutManager virtualLayoutManager;
    private SousuoAdapter sousuoAdapter;
    private ArrayList<HomeBean.DataDTO.BannerDTO> mBanner;
    private BannerAdapter bannerAdapter;
    private TwoColumnAdapter twoColumnAdapter;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> mChanne;
    private ThreeAdapter threeAdapter;
    private ForeAdapter foreAdapter;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> mBrand;
    private FiveAdapter fiveAdapter;


    @Override
    protected int setView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        recycler = view.findViewById(R.id.recycler);
        //banner
        mBanner = new ArrayList<>();
//网格
        mBrand = new ArrayList<>();
        mChanne = new ArrayList<>();
    }


    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        virtualLayoutManager = new VirtualLayoutManager(getContext());
        recycler.setLayoutManager(virtualLayoutManager);

        //搜索
        Sousuo();
        //banner
        getBanner();
        //五个一行
        twoLiner();
        //第三行品牌制造商
        threen();
        //第四行
        mGrild();
        //第五行
        mFive();
    }

    private void mFive() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        fiveAdapter = new FiveAdapter(getActivity(), singleLayoutHelper, mBrand);
    }

    private void mGrild() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(true);
        foreAdapter = new ForeAdapter(gridLayoutHelper, getActivity(), mBrand);
    }

    private void threen() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name="品牌制造商直供";
        threeAdapter = new ThreeAdapter(getActivity(),singleLayoutHelper,mChanne,name);
    }

    private void twoLiner() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setMargin(10, 10, 10, 10);
        twoColumnAdapter = new TwoColumnAdapter(getContext(),columnLayoutHelper,mChanne);
    }

    private void getBanner() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        bannerAdapter = new BannerAdapter(singleLayoutHelper,getContext(),mBanner);
    }

    private void Sousuo() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        sousuoAdapter = new SousuoAdapter(singleLayoutHelper,getContext());
    }


    @Override
    public void onSSon(HomeBean homeBean) {
        if (homeBean != null){
            //banner
            List<HomeBean.DataDTO.BannerDTO> banner = homeBean.getData().getBanner();
            mBanner.addAll(banner);
            bannerAdapter.notifyDataSetChanged();

            List<HomeBean.DataDTO.ChannelDTO> channel = homeBean.getData().getChannel();
            mChanne.addAll(channel);
            twoColumnAdapter.notifyDataSetChanged();

            threeAdapter.notifyDataSetChanged();

            List<HomeBean.DataDTO.BrandListDTO> brandList = homeBean.getData().getBrandList();
            mBrand.addAll(brandList);
            foreAdapter.notifyDataSetChanged();

            fiveAdapter.notifyDataSetChanged();

        }
    }
}