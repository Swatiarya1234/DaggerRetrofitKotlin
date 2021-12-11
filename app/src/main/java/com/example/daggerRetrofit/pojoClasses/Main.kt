package com.example.daggerRetrofit.pojoClasses

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

class Main {
    @SerializedName("feels_like")
    var feelsLike: Double? = null

    @SerializedName("humidity")
    var humidity: Long? = null

    @SerializedName("pressure")
    var pressure: Long? = null

    @SerializedName("temp")
    var temp: Double? = null

    @SerializedName("temp_max")
    var tempMax: Double? = null

    @SerializedName("temp_min")
    var tempMin: Double? = null
}