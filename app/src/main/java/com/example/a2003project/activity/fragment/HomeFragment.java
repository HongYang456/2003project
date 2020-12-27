package com.example.a2003project.activity.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.a2003project.R;
import com.example.a2003project.activity.adapter.BannerAdapter;
import com.example.a2003project.activity.adapter.EightAdapter;
import com.example.a2003project.activity.adapter.EventAdapter;
import com.example.a2003project.activity.adapter.FiveAdapter;
import com.example.a2003project.activity.adapter.ForeAdapter;
import com.example.a2003project.activity.adapter.SixAdapter;
import com.example.a2003project.activity.adapter.SousuoAdapter;
import com.example.a2003project.activity.adapter.TenAdapter;
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
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> mGoods;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> mHot;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> mTopic;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> mCateg;
    private EventAdapter eventAdapter;
    private ThreeAdapter evenAdapter;
    private TenAdapter tenAdapter;
    private EightAdapter eightAdapter;
    private ThreeAdapter nineAdapter;
    private ThreeAdapter servenAdapter;
    private SixAdapter sixAdapter;
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
        //新品首发
        mGoods = new ArrayList<>();
        //人气推荐
        mHot = new ArrayList<>();
        //专题精选
        mTopic = new ArrayList<>();
        //家具复用
        mCateg = new ArrayList<>();
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
        //第六个
        mSix();
        //第七个复用
        mServen();
        //第八个
        mEight();
        //第九个
        mNine();
        //第十个，滑动
        mTen();
        //第十一个，居家标题
        //        mEven();
        //第十二个，居家要复用，要嵌套，外加标题
        mEvenJu();
        addAdapter();
        presenter.getBanner();
    }
    private void mEvenJu() {        //用线性helper
        LinearLayoutHelper layoutHer = new LinearLayoutHelper();

        eventAdapter = new EventAdapter(getActivity(), layoutHer, mCateg);
    }

    private void mEven() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name="居家";
        evenAdapter = new ThreeAdapter(getActivity(), singleLayoutHelper, mChanne, name);
    }

    private void mTen() {   //里面需一个组件rec,然后横向滑动，互相不影响
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        tenAdapter = new TenAdapter(getActivity(), singleLayoutHelper, mTopic);
    }

    private void mNine() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name="专题精选";
        nineAdapter = new ThreeAdapter(getActivity(), singleLayoutHelper, mChanne, name);
    }

    private void mEight() {
        LinearLayoutHelper layoutHelper = new LinearLayoutHelper();
        layoutHelper.setItemCount(3);
        eightAdapter = new EightAdapter(getActivity(), layoutHelper, mHot);
    }

    private void mServen() {        //人气推荐
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(4);
        //修改，复用单一适配器
        String name="人气推荐";
        servenAdapter = new ThreeAdapter(getActivity(), singleLayoutHelper, mChanne, name);
    }

    private void mSix() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(true);
        gridLayoutHelper.setVGap(10);
        gridLayoutHelper.setHGap(10);
        gridLayoutHelper.setAspectRatio(2);
        sixAdapter = new SixAdapter(getActivity(), gridLayoutHelper, mGoods);
    }
    private void addAdapter() {
        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(sousuoAdapter);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(twoColumnAdapter);
        adapter.addAdapter(threeAdapter);
        adapter.addAdapter(foreAdapter);
        adapter.addAdapter(fiveAdapter);
        adapter.addAdapter(sixAdapter);
        adapter.addAdapter(servenAdapter);
        adapter.addAdapter(eightAdapter);
        adapter.addAdapter(nineAdapter);
        adapter.addAdapter(tenAdapter);
        adapter.addAdapter(eventAdapter);
        recycler.setLayoutManager(virtualLayoutManager);
        recycler.setAdapter(adapter);
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
            List<HomeBean.DataDTO.NewGoodsListDTO> newGoodsList = homeBean.getData().getNewGoodsList();
            mGoods.addAll(newGoodsList);
            sixAdapter.notifyDataSetChanged();

            servenAdapter.notifyDataSetChanged();

            if (mGoods.size()>0){
                List<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList = homeBean.getData().getHotGoodsList();
                mHot.addAll(hotGoodsList);
                eightAdapter.notifyDataSetChanged();
            }
            nineAdapter.notifyDataSetChanged();

            List<HomeBean.DataDTO.TopicListDTO> topicList = homeBean.getData().getTopicList();
            mTopic.addAll(topicList);
            tenAdapter.notifyDataSetChanged();

//            evenAdapter.notifyDataSetChanged();
            List<HomeBean.DataDTO.CategoryListDTO> categoryList = homeBean.getData().getCategoryList();
            mCateg.addAll(categoryList);
            eventAdapter.notifyDataSetChanged();
        }
    }
}