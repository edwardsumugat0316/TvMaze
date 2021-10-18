package com.android.tvmazeapplication.apiRequest


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequest {

    @GET("shows")
    suspend fun getShows(@Query("page")page: Int): List<ShowResponse>

    @GET("shows/{id}/episodes")
    suspend fun getEpisodes(@Path("id")showId: Int?): List<EpisodeResponse>

//    @GET("shows?page={pageNumber}")
//    suspend fun getPageNumber(@Query("pageNumber")pageNumber: Int): List<ShowResponse>

}