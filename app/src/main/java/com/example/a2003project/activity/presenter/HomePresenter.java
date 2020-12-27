package com.example.a2003project.activity.presenter;

import android.util.Log;

import com.example.a2003project.activity.bean.HomeBean;
import com.example.a2003project.activity.constans.HomeConstarts;
import com.example.a2003project.activity.model.HomeModel;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.baseApi.BaseView;
import com.example.mvp.http.api.NetCallBack;

public class HomePresenter <V extends HomeConstarts.HomeView> extends BasePresenter<V, HomeConstarts.HomeModel>
        implements HomeConstarts.HomePresenter, BaseView {
    @Override
    public void getBanner() {
        model.getBanner(new NetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean banBean) {
                view.onSSon(banBean);
            }

            @Override
            public void onFail(String err) {
                Log.e("banner",err);
            }
        });
    }

    @Override
    public HomeConstarts.HomeModel getModel() {
        return new HomeModel();
    }
}
