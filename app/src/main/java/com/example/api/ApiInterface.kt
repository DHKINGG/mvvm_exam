package com.example.api


import com.example.config.ApplicationClass
import com.example.model.HospitalModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/{apiKey}/json/LOCALDATA_010101_GN/{startIndex}/{endIndex}")
    fun getHomeBookApi(
        @Path("apiKey") apiKey: String,
        @Path("startIndex") startIndex: String,
        @Path("endIndex") endIndex: String,
    ): Call<HospitalModel>

    companion object {
        fun create(): ApiInterface {
            return Retrofit.Builder()
                .baseUrl(ApplicationClass.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }
}