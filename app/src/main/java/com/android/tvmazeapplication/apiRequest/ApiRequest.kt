package com.android.tvmazeapplication.apiRequest

import com.android.tvmazeapplication.model.ShowEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {

    @GET("shows")
    suspend fun getShows(@Query("page")page: Int): List<ShowResponse>

//    @GET("shows/:id")
//    suspend fun getShowInfo(@Query("id")id: Int): ShowStructureItem

}