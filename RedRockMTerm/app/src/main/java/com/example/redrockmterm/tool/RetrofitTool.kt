package com.example.redrockmterm.tool

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitTool {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://redrock.udday.cn:8888")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> getService(clazz:Class<T>):T = retrofit.create(clazz)
}