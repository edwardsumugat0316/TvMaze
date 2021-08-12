package com.android.tvmazeapplication.module

import com.android.tvmazeapplication.database.AppDatabase
import com.android.tvmazeapplication.remote.RemoteDataSource
import com.android.tvmazeapplication.remote.RemoteDataSourceImp
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> { AppDatabase.getDatabase(get()) }
}