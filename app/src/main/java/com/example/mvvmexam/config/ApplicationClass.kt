package com.example.config

import android.app.Application
import android.content.SharedPreferences
import com.example.utill.XAccessTokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {


    val baseUrl = "http://openapi.seoul.go.kr:8088/"

    companion object {

        lateinit var sSharedPreferences: SharedPreferences

        // JWT Token Header 키 값
        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"

        // userIndex 키 값
        val USER_IDX = "USER_IDX"

        // Retrofit 인스턴스, 앱 실행시 한번만 생성하여 사용합니다.
        lateinit var sRetrofit: Retrofit


        const val baseUrl = "http://openapi.seoul.go.kr:8088/"
        const val apiKey = "776b5459726877693536666d475149"

    }


    override fun onCreate() {
        super.onCreate()
        sSharedPreferences = applicationContext.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        // 레트로핏 인스턴스 생성
        initRetrofitInstance()
    }


    private fun initRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        sRetrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}