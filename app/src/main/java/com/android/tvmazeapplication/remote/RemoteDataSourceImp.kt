package com.android.tvmazeapplication.remote

import com.android.tvmazeapplication.apiRequest.ApiRequest
import com.android.tvmazeapplication.model.ShowStructureItem
import retrofit2.Call

class RemoteDataSourceImp(private val service: ApiRequest): RemoteDataSource{
    override fun getShows(page: Int): Call<List<ShowStructureItem>> {
        return service.getShows(page)
    }
}