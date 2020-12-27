package com.example.a2003project.activity.constans;

import com.example.a2003project.activity.bean.HomeBean;
import com.example.mvp.baseApi.BaseView;
import com.example.mvp.baseApi.IBaseModel;
import com.example.mvp.http.api.NetCallBack;

public interface HomeConstarts {

    interface HomeView extends BaseView {
        void onSSon(HomeBean homeBean);
    }

    interface HomePresenter {
        void getBanner();
    }

    interface HomeModel extends IBaseModel {
        void getBanner(NetCallBack<HomeBean> netCallBack);
    }

}
