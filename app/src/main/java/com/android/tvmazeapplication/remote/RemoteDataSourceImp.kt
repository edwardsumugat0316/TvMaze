package com.android.tvmazeapplication.remote

import com.android.tvmazeapplication.apiRequest.ApiRequest
import com.android.tvmazeapplication.apiRequest.EpisodeResponse
import com.android.tvmazeapplication.apiRequest.ShowResponse

class RemoteDataSourceImp(private val service: ApiRequest): RemoteDataSource{
    override suspend fun getShows(page: Int): List<ShowResponse> {
        return service.getShows(page)
    }

    override suspend fun getEpisodes(showId: Int?): List<EpisodeResponse> {
        return service.getEpisodes(showId = showId)
    }

//    override fun getSearchResult(query: String) =
//        Pager(
//        config = PagingConfig(
//            pageSize = 20,
//            maxSize = 100,
//            enablePlaceholders = false
//        ),
//        pagingSourceFactory = { Paging(service, query) }
//    ).liveData

//    override suspend fun getPageNumber(pageNumber: Int): List<ShowResponse> {
////        return service.getPageNumber(pageNumber)
//    }
}