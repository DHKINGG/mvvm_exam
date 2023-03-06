package com.example.data.room


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
//데이터베이스에 접근해서 실질적으로 insert, delete 등을 수행하는 메소드를 포함한다
interface HospitalDao {

    @Query("SELECT * FROM contact")
    fun getAll(): LiveData<List<Contact>>

    //데이터 삽입
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    //데이터 삭제
    @Delete
    fun delete(contact: Contact)
}