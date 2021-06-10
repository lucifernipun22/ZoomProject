package com.masai.masaiconference.module


import com.masai.masaiconference.repo.MeetingHistoryRepository
import com.masai.masaiconference.viewModel.MeetingHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val meetingHistoryModule = module {

    single { MeetingHistoryRepository(get()) }
    viewModel { MeetingHistoryViewModel(get()) }

}
