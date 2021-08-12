package com.android.tvmazeapplication.repository

import com.android.tvmazeapplication.model.ShowStructureItem
import retrofit2.Call

interface Repository {

    fun getShows(page: Int): Call<List<ShowStructureItem>>

    fun insertShows(shows: List<ShowStructureItem>)
}