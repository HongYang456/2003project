package com.example.a2003project.activity.api;

import com.example.a2003project.activity.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServices {
    String BASEURL = "https://cdwan.cn/";

    @GET("api/index")
    Observable<HomeBean.DataDTO.BannerDTO> bannerGet();
}
