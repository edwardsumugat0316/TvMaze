package com.android.tvmazeapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.android.tvmazeapplication.model.ShowStructureItem

@Dao
interface ShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: ShowStructureItem)
}