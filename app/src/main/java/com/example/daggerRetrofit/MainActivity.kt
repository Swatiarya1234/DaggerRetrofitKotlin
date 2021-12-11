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
import android.util.Log
import com.example.daggerRetrofit.R
import com.example.daggerRetrofit.MyApplication
import com.example.daggerRetrofit.restClass.ApiInterface
import android.widget.Toast
import com.example.daggerRetrofit.restClass.ApiComponent
import com.example.daggerRetrofit.restClass.DaggerApiComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    @JvmField
    @Inject
    var retrofit: Retrofit? = null
    var temp: TextView? = null
    var city: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApplication).netComponent?.inject(this)
        apiApp
    }// else the body is used to print the other values//if the body is null then do nothing

    // Log.d("call",call.request().toString()); to check the query string
    private val apiApp: Unit
        private get() {
            val api = retrofit!!.create(ApiInterface::class.java)
            val call = api.getWeather("London", ApiInterface.Companion.appId)
            // Log.d("call",call.request().toString()); to check the query string
            call!!.enqueue(object : Callback<WeatherPojoClass?> {
                override fun onResponse(
                    call: Call<WeatherPojoClass?>,
                    response: Response<WeatherPojoClass?>
                ) {
                    if (response.body() == null) { //if the body is null then do nothing
                        Log.d("reponse", "response is null")
                    } else { // else the body is used to print the other values
                        Log.d("response", response.body()!!.sys!!.country.toString())
                    }
                }

                override fun onFailure(call: Call<WeatherPojoClass?>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
}