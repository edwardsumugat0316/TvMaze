package com.android.tvmazeapplication.remote

import com.android.tvmazeapplication.apiRequest.ShowResponse
import com.android.tvmazeapplication.model.ShowEntity

interface RemoteDataSource {
   suspend fun getShows(page: Int): List<ShowResponse>

//    suspend fun getShowInfo(id: Int): ShowStructureItem
}