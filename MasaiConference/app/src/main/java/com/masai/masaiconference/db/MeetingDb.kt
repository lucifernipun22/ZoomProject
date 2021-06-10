package com.masai.masaiconference.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.masai.masaiconference.model.Meeting

@Database(entities = [Meeting::class], version = 1, exportSchema = false)
abstract class MeetingDb : RoomDatabase() {

    abstract fun meetingDao(): MeetingDao

}