package com.dongmin.certiapp.module

import com.dongmin.certiapp.ui.festival.FestivalViewModel
import com.dongmin.certiapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FestivalViewModel(get()) }
}