package com.android.tvmazeapplication.repository

import com.android.tvmazeapplication.model.ShowEntity

interface Repository {

   suspend fun getShows(page: Int): List<ShowEntity>

    fun getShowInfo(id: Int): ShowEntity

    fun insertShows(shows: List<ShowEntity>)

    fun saveShowFrmDb(show: ShowEntity)

    fun getShowFrmDb(id: Int): ShowEntity



}