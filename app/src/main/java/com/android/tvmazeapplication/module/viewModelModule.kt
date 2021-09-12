package com.android.tvmazeapplication.module

import com.android.tvmazeapplication.MainActivityViewModel
import com.android.tvmazeapplication.showInfo.ShowInfoViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(repository = get()) }
}

val viewModelShowInfoModule = module {
    viewModel { (id: Int) -> ShowInfoViewModel(id, repository = get ()) }
}