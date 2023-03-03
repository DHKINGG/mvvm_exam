package com.example.data.room


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
//데이터베이스에 접근해서 실질적으로 insert, delete 등을 수행하는 메소드를 포함한다
interface HospitalDao {
    @Query("SELECT * FROM contact")
    fun getAll(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}