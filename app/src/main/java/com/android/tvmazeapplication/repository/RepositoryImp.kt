package com.android.tvmazeapplication.repository

import com.android.tvmazeapplication.database.AppDatabase
import com.android.tvmazeapplication.model.ShowStructureItem
import com.android.tvmazeapplication.remote.RemoteDataSource
import retrofit2.Call

class RepositoryImp(private val remoteDataSource: RemoteDataSource, private val database: AppDatabase): Repository {
    override fun getShows(page: Int): Call<List<ShowStructureItem>> {
        return remoteDataSource.getShows(page)
    }

    override fun insertShows(shows: List<ShowStructureItem>) {
        shows.forEach {
            database.showDao().insertShows(it)
        }
    }
}