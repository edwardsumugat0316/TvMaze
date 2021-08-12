package com.android.tvmazeapplication.remote

import com.android.tvmazeapplication.model.ShowStructureItem
import retrofit2.Call

interface RemoteDataSource {
    fun getShows(page: Int): Call<List<ShowStructureItem>>
}