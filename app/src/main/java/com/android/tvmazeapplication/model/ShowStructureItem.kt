package com.android.tvmazeapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Shows")
data class ShowStructureItem(
    val _links: Links,
    val averageRuntime: Int,
    val dvdCountry: String?,
    val externals: Externals,
    val genres: List<String>,
   @PrimaryKey val id: Int,
    val image: Image,
    val language: String,
    val name: String,
    val network: Network?,
    val officialSite: String?,
    val premiered: String,
    val rating: Rating,
    val runtime: Int,
    val schedule: Schedule,
    val status: String,
    val summary: String,
    val type: String,
    val updated: Int,
    val url: String,
//    val webChannel: WebChannel,
    val weight: Int
)