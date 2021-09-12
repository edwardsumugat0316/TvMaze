package com.android.tvmazeapplication.remote

import com.android.tvmazeapplication.apiRequest.ApiRequest
import com.android.tvmazeapplication.apiRequest.ShowResponse
import com.android.tvmazeapplication.model.ShowEntity

class RemoteDataSourceImp(private val service: ApiRequest): RemoteDataSource{
    override suspend fun getShows(page: Int): List<ShowResponse> {
        return service.getShows(page)
    }
    //    override fun getShows(page: Int): List<ShowStructureItem>{
//        return service.getShows(page)
//    }
//
//    override suspend fun getShowInfo(id: Int): ShowStructureItem {
//        return service.getShowInfo(id)
//    }
}