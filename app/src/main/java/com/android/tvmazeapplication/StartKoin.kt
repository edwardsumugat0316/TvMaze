package com.android.tvmazeapplication

import android.app.Application
import com.android.tvmazeapplication.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StartKoin: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StartKoin)
            modules(databaseModule)
            modules(networkModule)
            modules(repositoryModule)
            modules(remoteDataSourceModule)
            modules(viewModelModule)

        }
    }
}