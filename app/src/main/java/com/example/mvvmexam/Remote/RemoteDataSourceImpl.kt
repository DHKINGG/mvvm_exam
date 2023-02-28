package com.example.mvvmexam.Remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.Api.RemoteDataSource
import com.example.config.ApplicationClass
import com.example.api.ApiInterface
import com.example.model.HospitalModel
import com.example.model.LocalDataModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSourceImpl constructor(private val apiInterface: ApiInterface):
    RemoteDataSource{

//    private var _homeData: MutableLiveData<HospitalModel> = MutableLiveData()
//    val homeData: LiveData<HospitalModel> = _homeData
//
//    fun getHome(){
//        val api = ApiInterface.create()
//        api.getHomeBookApi(ApplicationClass.apiKey, "1", "8").enqueue(object :
//            Callback<HospitalModel> {
//            override fun onResponse(call: Call<HospitalModel>, response: Response<HospitalModel>) {
//                Log.d("HomeFragmentViewModel", "getHome()")
//                _homeData.value = response.body()
//            }
//
//            override fun onFailure(call: Call<HospitalModel>, t: Throwable) {
//                Log.d("HomeFragmentViewModel", t.message.toString())
//            }
//        })
//    }
    override fun getHome2(apiKey: String, startIndex: String, endIndex: String,
    ): Call<HospitalModel> {
       return apiInterface.getHomeBookApi(ApplicationClass.apiKey,"1", "1")
    }

}