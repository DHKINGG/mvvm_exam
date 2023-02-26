package com.example.view

import android.app.Application
import androidx.lifecycle.*
import com.example.data.Contact
import com.example.Repository
import com.example.mvvmexam.Remote.RemoteDataSourceImpl

class HospitalViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    private val contacts = repository.getAll()


    fun getAll(): LiveData<List<Contact>> {
        return this.contacts
    }
    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }
    

    class Factory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HospitalViewModel(application) as T
        }
    }
}