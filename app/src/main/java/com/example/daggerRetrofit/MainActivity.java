package com.example.daggerRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggerRetrofit.PojoClasses.WeatherPojoClass;
import com.example.daggerRetrofit.restClass.ApiInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    TextView temp , city;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getNetComponent().inject(this);
        getApiApp();
    }

    private void getApiApp() {
        ApiInterface api = retrofit.create(ApiInterface.class);
        Call<WeatherPojoClass>call = api.getWeather("London",ApiInterface.appId);
       // Log.d("call",call.request().toString()); to check the query string
        call.enqueue(new Callback<WeatherPojoClass>() {
            @Override
            public void onResponse(Call<WeatherPojoClass> call, Response<WeatherPojoClass> response) {
                if(response.body() == null){//if the body is null then do nothing

                    Log.d("reponse","response is null");
                }
                else {// else the body is used to print the other values
                    Log.d("response",response.body().getSys().getCountry().toString());
                }
            }

            @Override
            public void onFailure(Call<WeatherPojoClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}