package com.android.tvmazeapplication.database

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.tvmazeapplication.ItemConverters
import com.android.tvmazeapplication.dao.ShowDao
import com.android.tvmazeapplication.model.ShowStructureItem
import retrofit2.Converter

@Database(entities = [ShowStructureItem::class], version = 1, exportSchema = false)

@TypeConverters(ItemConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun showDao():ShowDao


    companion object{
        @Volatile
        var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "AppDatabase"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}