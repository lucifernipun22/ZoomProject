package com.masai.masaiconference


import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.masai.masaiconference.module.appModule
import com.masai.masaiconference.module.mainModule
import com.masai.masaiconference.module.meetingHistoryModule
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MasaiConference : Application() {



    override fun onCreate() {
        super.onCreate()


        initializeKotPref()

        initializeKoin()
        //initializing our Parse application with our application id, client key and server url
        JodaTimeAndroid.init(this)

    }

    private fun initializeKotPref() {
        Kotpref.init(this)
    }



    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MasaiConference)
            modules(
                listOf(
                    appModule,
                    mainModule,
                    meetingHistoryModule
                )
            )
        }
    }


}