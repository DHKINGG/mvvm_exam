package com.example.data.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//Database - database holder를 포함하며, 앱에 영구 저장되는 데이터와 기본 연결을 위한 주 액세스 지점이다.

@Database(entities = [Contact::class], version = 1)
abstract class DataBase: RoomDatabase() {

    abstract fun hospitalDao(): HospitalDao

    companion object {
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase? {
            if (INSTANCE == null) {
                synchronized(DataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DataBase::class.java, "contact")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}