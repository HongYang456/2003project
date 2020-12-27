package com.example.a2003project.activity.model;

import com.example.a2003project.activity.bean.HomeBean;
import com.example.a2003project.activity.constans.HomeConstarts;
import com.example.mvp.base.BaseModel;
import com.example.mvp.http.RetrofitUtlis;
import com.example.mvp.http.api.BaseUrl;
import com.example.mvp.http.api.NetCallBack;

import io.reactivex.disposables.Disposable;

public class HomeModel extends BaseModel implements HomeConstarts.HomeModel {
    @Override
    public void getBanner(NetCallBack<HomeBean> netCallBack) {
        Disposable disposable = RetrofitUtlis.getInstance().get(BaseUrl.BAURL, netCallBack);
        addDisposable(disposable);
    }
}
