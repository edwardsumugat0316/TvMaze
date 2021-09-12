package com.android.tvmazeapplication

import androidx.room.TypeConverter
import com.android.tvmazeapplication.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemConverters {
    @TypeConverter
    fun fromString( value: String): List<String>{
        val listType = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(value,listType)
    }
    @TypeConverter
    fun frmList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}