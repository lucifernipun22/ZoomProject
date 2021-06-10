package com.masai.masaiconference.repo

import androidx.lifecycle.LiveData
import com.masai.masaiconference.db.MeetingDao
import com.masai.masaiconference.model.Meeting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MeetingHistoryRepository(private val meetingDao: MeetingDao) {

    fun getMeetingHistory(): LiveData<List<Meeting>> =
        meetingDao.getAllMeetings()

    suspend fun addMeetingToDb(meeting: Meeting) = withContext(Dispatchers.IO) {
        meetingDao.insertMeeting(meeting)
    }
}