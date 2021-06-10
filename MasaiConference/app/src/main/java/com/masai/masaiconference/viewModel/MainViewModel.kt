package com.masai.masaiconference.viewModel

import com.masai.masaiconference.repo.MainRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masai.masaiconference.model.Meeting
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    fun addMeetingToDb(meeting: Meeting) {
        viewModelScope.launch {
            repository.addMeetingToDb(meeting)
        }
    }

}