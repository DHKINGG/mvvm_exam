package com.example.view

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.data.room.Contact
import com.example.Repository
import com.example.api.ApiInterface
import com.example.config.ApplicationClass
import com.example.model.HospitalModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    private val contacts = repository.getAll()
    private var _homeData: MutableLiveData<HospitalModel> = MutableLiveData()
    val homeData: LiveData<HospitalModel> = _homeData


    fun getAll(): LiveData<List<Contact>> {
        return this.contacts
    }
    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }



    fun getHome() {
        val api = ApiInterface.create()
        api.getHomeBookApi(ApplicationClass.apiKey, "1", "8").enqueue(object :
            Callback<HospitalModel> {
            override fun onResponse(call: Call<HospitalModel>, response: Response<HospitalModel>) {
                Log.d("HomeFragmentViewModel", "getHome()")
                _homeData.value = response.body()
            }

            override fun onFailure(call: Call<HospitalModel>, t: Throwable) {
                Log.d("HomeFragmentViewModel", t.message.toString())
            }
        })
    }




    class Factory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HospitalViewModel(application) as T
        }
    }
}