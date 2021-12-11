package com.example.daggerRetrofit

import javax.inject.Singleton
import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.FieldNamingPolicy
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.daggerRetrofit.restClass.AppModule
import com.example.daggerRetrofit.restClass.ApiModule
import com.example.daggerRetrofit.MainActivity
import retrofit2.http.GET
import com.example.daggerRetrofit.pojoClasses.WeatherPojoClass
import com.google.gson.annotations.SerializedName
import com.example.daggerRetrofit.pojoClasses.Clouds
import com.example.daggerRetrofit.pojoClasses.Coord
import com.example.daggerRetrofit.pojoClasses.Sys
import com.example.daggerRetrofit.pojoClasses.Weather
import com.example.daggerRetrofit.pojoClasses.Wind
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject
import android.widget.TextView
import android.os.Bundle
import com.example.daggerRetrofit.R
import com.example.daggerRetrofit.MyApplication
import com.example.daggerRetrofit.restClass.ApiInterface
import android.widget.Toast
import com.example.daggerRetrofit.restClass.ApiComponent
import com.example.daggerRetrofit.restClass.DaggerApiComponent

class MyApplication : Application() {
    var netComponent: ApiComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        netComponent = DaggerApiComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule("http://api.openweathermap.org/data/2.5/"))
            .build()
    }
}