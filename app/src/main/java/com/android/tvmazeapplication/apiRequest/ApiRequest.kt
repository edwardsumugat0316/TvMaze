package com.android.tvmazeapplication.apiRequest

import com.android.tvmazeapplication.model.ShowStructureItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {

    @GET("shows")

    fun getShows(@Query("page")page: Int): Call<List<ShowStructureItem>>
}