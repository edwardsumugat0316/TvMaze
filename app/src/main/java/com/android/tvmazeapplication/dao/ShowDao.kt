package com.android.tvmazeapplication.dao

import androidx.room.*
import com.android.tvmazeapplication.model.ShowEntity

@Dao
interface ShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: ShowEntity)

    @Query("SELECT * FROM Shows WHERE id = :id")
    fun getShowById(id: Int): ShowEntity

    @Query("SELECT * FROM Shows WHERE name LIKE '%'||:title || '%' ")
    fun searchTitle(title: String): List<ShowEntity>

}