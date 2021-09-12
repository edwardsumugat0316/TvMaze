package com.android.tvmazeapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.tvmazeapplication.model.ShowEntity

@Dao
interface ShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: ShowEntity)

    @Query("SELECT * FROM Shows WHERE id = :id")
    fun getShowById(id: Int): ShowEntity
}