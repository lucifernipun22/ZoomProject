package com.nhs.masaiconference.module


import com.nhs.masaiconference.viewModel.MainViewModel
import com.nhs.masaiconference.repo.MainRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single { MainRepository(get()) }
    viewModel { MainViewModel(get()) }

}
