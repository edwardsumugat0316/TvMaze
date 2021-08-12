package com.android.tvmazeapplication.module

import com.android.tvmazeapplication.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(repository = get()) }
}