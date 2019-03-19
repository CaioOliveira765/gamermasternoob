package com.example.gamernoob.Retrofit

import com.example.gamernoob.Retrofit.service.RestInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    class RetrofitConfig{

            private val retrofit = Retrofit.Builder()
            .baseUrl("http://10.2.70.212:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun loginService(): RestInterface {
        return retrofit.create(RestInterface :: class.java)
    }
}