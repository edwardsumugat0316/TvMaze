package com.android.tvmazeapplication.model.episode

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Episode")
data class EpisodeEntity(
        @PrimaryKey val id: Int,
        val image: String,
        val name: String,
        val number: Int,
        val runtime: Int,
        val season: Int,
        val summary: String
)