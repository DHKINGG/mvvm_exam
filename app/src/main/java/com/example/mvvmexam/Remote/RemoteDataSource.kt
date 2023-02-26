package com.example.Api

import com.example.config.ApplicationClass
import com.example.model.HospitalModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteDataSource {
    fun getHome2(apiKey: String, startIndex: String, endIndex: String): Call<HospitalModel>


}