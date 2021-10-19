package com.android.tvmazeapplication.remote
import com.android.tvmazeapplication.apiRequest.EpisodeResponse
import com.android.tvmazeapplication.apiRequest.ShowResponse


interface RemoteDataSource {
   suspend fun getShows(page: Int): List<ShowResponse>

   suspend fun getEpisodes(showId: Int?): List<EpisodeResponse>
}