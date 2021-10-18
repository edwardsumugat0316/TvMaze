package com.android.tvmazeapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.tvmazeapplication.model.ShowEntity
import com.android.tvmazeapplication.model.episode.EpisodeEntity

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisode(episode:List<EpisodeEntity>)

    @Query("SELECT * FROM Episode WHERE id = :episodeId")
    fun getEpisodeId(episodeId: Int): EpisodeEntity

}