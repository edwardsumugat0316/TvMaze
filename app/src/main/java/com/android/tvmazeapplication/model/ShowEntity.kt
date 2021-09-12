package com.android.tvmazeapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Shows")
data class ShowStructureItem(
        val averageRuntime: Int,
        val dvdCountry: String?,
        val genres: List<String>,
        @PrimaryKey var id: Int,
        val image: Image,
        val language: String,
        val name: String,
        val officialSite: String?,
        val premiered: String,
        val rating: Double,
        val runtime: Int,
        val status: String,
        val summary: String,
        val type: String,
        val updated: Int,
        val url: String,
        val weight: Int
)