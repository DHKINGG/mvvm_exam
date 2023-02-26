package com.example.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

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