package com.android.tvmazeapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Country(
        @PrimaryKey val code: String,
        val name: String,
        val timezone: String
)