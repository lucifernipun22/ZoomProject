package com.nhs.masaiconference.viewModel

import com.nhs.masaiconference.repo.MainRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhs.masaiconference.model.Meeting
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    fun addMeetingToDb(meeting: Meeting) {
        viewModelScope.launch {
            repository.addMeetingToDb(meeting)
        }
    }

}