package com.android.tvmazeapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
data class Network(
        val country: Country,
        @PrimaryKey val id: Int,
        val name: String?
)