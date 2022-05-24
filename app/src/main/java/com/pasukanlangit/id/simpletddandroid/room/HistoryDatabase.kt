package com.pasukanlangit.id.simpletddandroid.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [History::class], version = 1, exportSchema = true)
abstract class HistoryDatabase: RoomDatabase(){
    abstract fun historyDao(): HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        operator fun invoke(context: Context): HistoryDatabase{
            return INSTANCE ?: synchronized(this){
                val instance  = Room.databaseBuilder(context, HistoryDatabase::class.java, "historydb")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}