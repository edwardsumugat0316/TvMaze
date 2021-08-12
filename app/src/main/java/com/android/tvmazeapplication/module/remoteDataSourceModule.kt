package com.android.tvmazeapplication.module

import com.android.tvmazeapplication.remote.RemoteDataSource
import com.android.tvmazeapplication.remote.RemoteDataSourceImp
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single <RemoteDataSource> {RemoteDataSourceImp(service = get()) }
}