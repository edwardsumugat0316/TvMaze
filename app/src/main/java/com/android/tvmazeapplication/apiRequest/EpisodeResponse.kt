package com.android.tvmazeapplication.apiRequest

import androidx.room.PrimaryKey
import com.android.tvmazeapplication.model.Image

data class EpisodeResponse(
        @PrimaryKey val id: Int,
        val image: Image,
        val name: String,
        val number: Int,
        val runtime: Int,
        val season: Int,
        val summary: String
)