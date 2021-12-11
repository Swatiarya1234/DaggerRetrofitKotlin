package com.example.daggerRetrofit.restClass;

import com.example.daggerRetrofit.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,ApiModule.class})

public interface ApiComponent {
    void inject(MainActivity activity);
}
