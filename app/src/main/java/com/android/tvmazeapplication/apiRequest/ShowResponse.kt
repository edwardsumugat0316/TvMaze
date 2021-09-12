package com.android.tvmazeapplication.apiRequest

import androidx.room.PrimaryKey
import com.android.tvmazeapplication.model.Image
import com.android.tvmazeapplication.model.Rating

data class ShowResponse(
        val averageRuntime: Int,
        val dvdCountry: String?,
        val genres: List<String>,
        @PrimaryKey var id: Int,
        val image: Image,
        val language: String,
        val name: String,
        val officialSite: String?,
        val premiered: String,
        val rating: Rating,
        val runtime: Int,
        val status: String,
        val summary: String,
        val type: String,
        val updated: Int,
        val url: String,
        val weight: Int
)
