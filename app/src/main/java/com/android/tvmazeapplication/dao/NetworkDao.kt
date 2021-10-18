package com.android.tvmazeapplication.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.android.tvmazeapplication.model.Network

@Dao
interface NetworkDao {

//    @Query("Select * From Network Where name = :networkName")
//    fun getNetworkName(networkName: String):Network
}