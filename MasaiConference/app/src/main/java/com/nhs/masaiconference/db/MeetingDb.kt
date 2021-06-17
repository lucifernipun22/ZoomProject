package com.nhs.masaiconference.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.nhs.masaiconference.model.Meeting

@Database(entities = [Meeting::class], version = 1, exportSchema = false)
abstract class MeetingDb : RoomDatabase() {

    abstract fun meetingDao(): MeetingDao

}