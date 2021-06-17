package com.nhs.masaiconference.module


import android.app.Application
import androidx.room.Room
import com.nhs.masaiconference.db.MeetingDb
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    single { provideRoomDatabase(androidApplication()) }
    single { provideMeetingDao(get()) }
}

private fun provideRoomDatabase(androidApplication: Application) =
    Room.databaseBuilder(androidApplication, MeetingDb::class.java, "meetly-db").build()

private fun provideMeetingDao(meetlyDB: MeetingDb) =
    meetlyDB.meetingDao()