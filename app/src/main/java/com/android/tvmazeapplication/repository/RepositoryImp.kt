package com.android.tvmazeapplication.repository

import com.android.tvmazeapplication.database.AppDatabase
import com.android.tvmazeapplication.model.ShowEntity
import com.android.tvmazeapplication.model.episode.EpisodeEntity
import com.android.tvmazeapplication.remote.RemoteDataSource

class RepositoryImp(private val remoteDataSource: RemoteDataSource, private val database: AppDatabase): Repository {

    override suspend fun getShows(page: Int): List<ShowEntity> {
        val showResponses = remoteDataSource.getShows(page)
        val showEntities = mutableListOf<ShowEntity>()
        showResponses.forEach {
            val showEntity = ShowEntity(
                averageRuntime = it.averageRuntime,
                    dvdCountry = it.dvdCountry,
                    genres = it.genres,
                    id = it.id,
            image = it.image.medium,
            language = it.language,
            name = it.name,
            officialSite = it.officialSite,
            premiered = it.premiered,
            rating = it.rating.average,
            runtime = it.runtime,
            status = it.status,
            summary = it.summary,
            type = it.type,
            updated = it.updated,
            url = it.url,
            weight = it.weight)

            showEntities.add(showEntity)
        }
        insertShows(showEntities)
        return showEntities

    }

//    override suspend fun getPageNumber(pageNumber: Int): List<ShowEntity> {
//        val showResponse = remoteDataSource.getPageNumber(pageNumber)
//        val showEntities = mutableListOf<ShowEntity>()
//        showResponse.forEach {
//            val showEntity = ShowEntity(averageRuntime = it.averageRuntime,
//                    dvdCountry = it.dvdCountry,
//                    genres = it.genres,
//                    id = it.id,
//                    image = it.image.original,
//                    language = it.language,
//                    name = it.name,
//                    officialSite = it.officialSite,
//                    premiered = it.premiered,
//                    rating = it.rating.average,
//                    runtime = it.runtime,
//                    status = it.status,
//                    summary = it.summary,
//                    type = it.type,
//                    updated = it.updated,
//                    url = it.url,
//                    weight = it.weight)
//            showEntities.add(showEntity)
//        }
//        insertShows(showEntities)
//        return showEntities
//    }

    override suspend fun getEpisodes(showId: Int?): List<EpisodeEntity> {
        val episodeResponse = remoteDataSource.getEpisodes(showId = showId)
        val episodeEntities = mutableListOf<EpisodeEntity>()
        episodeResponse.forEach {
            val episodeEntity = EpisodeEntity(id = it.id,
            image = it.image.medium,
            name = it.name,
            number = it.number,
            runtime = it.runtime,
            season = it.season,
            summary = it.summary)
            episodeEntities.add(episodeEntity)
        }
        insertEpisode(episodeEntities)
        return episodeEntities
    }

    override fun insertShows(shows: List<ShowEntity>) {
        shows.forEach {
            database.showDao().insertShows(it)
        }
    }

    override fun getShowInfo(id: Int): ShowEntity {
        return database.showDao().getShowById(id)
    }

    override fun insertEpisode(episode: List<EpisodeEntity>) {
        database.episodeDao().insertEpisode(episode)
    }


    override fun saveShowFrmDb(show: ShowEntity) {
        return database.showDao().insertShows(show)
    }

    override fun getShowFrmDb(id: Int): ShowEntity {
        return database.showDao().getShowById(id)
    }

    override fun getEpisodeId(episodeId: Int): EpisodeEntity {
        return database.episodeDao().getEpisodeId(episodeId = episodeId)
    }

    override fun searchTitle(title: String): List<ShowEntity> {
        return database.showDao().searchTitle(title)
    }


    //    override fun getNetworkName(netWorkName: String): Network {
//        return database.networkDao().getNetworkName(netWorkName)
//    }
}