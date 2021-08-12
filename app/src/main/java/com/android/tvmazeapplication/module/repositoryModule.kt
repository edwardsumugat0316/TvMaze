package com.android.tvmazeapplication.module

import com.android.tvmazeapplication.repository.Repository
import com.android.tvmazeapplication.repository.RepositoryImp
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> {RepositoryImp(remoteDataSource = get(), database = get()) }
}
