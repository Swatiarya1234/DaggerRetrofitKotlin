package com.example.daggerRetrofit;
import android.app.Application;

import com.example.daggerRetrofit.restClass.ApiComponent;
import com.example.daggerRetrofit.restClass.ApiModule;
import com.example.daggerRetrofit.restClass.AppModule;
import com.example.daggerRetrofit.restClass.DaggerApiComponent;

public class MyApplication extends Application {
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("http://api.openweathermap.org/data/2.5/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}
