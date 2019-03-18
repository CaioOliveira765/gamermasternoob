package com.example.gamernoob.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer{
    fun init(){
        Retrofit.Builder()
            .baseUrl("https://api.letsbuildthatapp.com/youtube/home_feed")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}