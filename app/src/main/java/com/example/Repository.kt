package com.example

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.data.Contact
import com.example.data.DataBase
import com.example.data.HospitalDao

class Repository(application: Application) {

    private val dataBase = DataBase.getInstance(application)!!
    private val hospitalDao: HospitalDao = dataBase.hospitalDao()

    fun getAll(): LiveData<List<Contact>> {
        return hospitalDao.getAll()
    }

    fun insert(contact: Contact) {
        try {
            val thread = Thread(Runnable {
                hospitalDao.insert(contact)
            })
            thread.start()
        } catch (_: Exception) {
        }
    }

    fun delete(contact: Contact) {
        try {
            val thread = Thread(Runnable {
                hospitalDao.delete(contact)
            })
            thread.start()
        } catch (_: Exception) {
        }
    }
    //

    //1.remote 객체 만들어여하고
    //2.db값이 비어있지않으면 그냥 return 떄리고
    // 비어있을시에는 remote값을 db에 저장하고 그 값을 가져온다.
    // repository 패턴 검색해보셈(room , db , retrofit 예제 등등 나올거)
    //ui - > repositryimpl
    // ui -> repository(구현체)
}