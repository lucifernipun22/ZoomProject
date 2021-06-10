package com.masai.masaiconference.repo

import com.masai.masaiconference.db.MeetingDao
import com.masai.masaiconference.model.Meeting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val meetingDao: MeetingDao) {

    suspend fun addMeetingToDb(meeting: Meeting) = withContext(Dispatchers.IO) {
        meetingDao.insertMeeting(meeting)
    }

}