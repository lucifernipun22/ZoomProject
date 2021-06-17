package com.nhs.masaiconference.module


import com.nhs.masaiconference.repo.MeetingHistoryRepository
import com.nhs.masaiconference.viewModel.MeetingHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val meetingHistoryModule = module {

    single { MeetingHistoryRepository(get()) }
    viewModel { MeetingHistoryViewModel(get()) }

}
