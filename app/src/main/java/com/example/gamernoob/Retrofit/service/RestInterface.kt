package com.example.gamernoob.Retrofit.service

import com.example.gamernoob.model.Usuario
import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST

interface RestInterface{

    @POST("usuario/login")
    fun buscarLogin() : Call<ResponseBody<Usuario>>
}