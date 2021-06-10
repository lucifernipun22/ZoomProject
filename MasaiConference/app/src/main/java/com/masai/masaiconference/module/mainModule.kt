package com.masai.masaiconference.module


import com.masai.masaiconference.viewModel.MainViewModel
import com.masai.masaiconference.repo.MainRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single { MainRepository(get()) }
    viewModel { MainViewModel(get()) }

}
