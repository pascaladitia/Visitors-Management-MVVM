package com.pascal.myapplication.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ConfigNetwork {

    fun getVisitors(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://192.168.43.187/visitors/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    fun service(): ApiService = getVisitors().create(ApiService::class.java)
}