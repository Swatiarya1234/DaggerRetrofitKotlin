package com.example.daggerRetrofit.restClass;


import com.example.daggerRetrofit.pojoClasses.WeatherPojoClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    static final String  appId ="9ddde7bb16caabbd0f16d18d619f1bee";
    @GET("weather")
    Call<WeatherPojoClass> getWeather(@Query("q") String city, @Query("appid") String appid);
}

