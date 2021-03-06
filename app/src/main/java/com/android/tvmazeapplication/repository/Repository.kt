package com.android.tvmazeapplication.repository
import com.android.tvmazeapplication.model.ShowEntity
import com.android.tvmazeapplication.model.episode.EpisodeEntity

interface Repository {

   suspend fun getShows(page: Int): List<ShowEntity>

   suspend fun getEpisodes(showId: Int?): List<EpisodeEntity>

    fun getShowInfo(id: Int): ShowEntity

    fun insertShows(shows: List<ShowEntity>)

    fun saveShowFrmDb(show: ShowEntity)

    fun getShowFrmDb(id: Int): ShowEntity

    fun insertEpisode(episode: List<EpisodeEntity>)

    fun getEpisodeId(episodeId: Int): EpisodeEntity

    fun searchTitle(title: String): List<ShowEntity>

}