package com.nhs.masaiconference


import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.nhs.masaiconference.module.appModule
import com.nhs.masaiconference.module.mainModule
import com.nhs.masaiconference.module.meetingHistoryModule
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MasaiConference : Application() {




    override fun onCreate() {
        super.onCreate()

        var userDatabaseReference: DatabaseReference? = null
        var mAuth: FirebaseAuth? = null
        var currentOnlineUser: FirebaseUser? = null
        initializeKotPref()

        initializeKoin()
        //initializing our Parse application with our application id, client key and server url
        JodaTimeAndroid.init(this)


        //  all strings >> load offline
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

        //  all images >> load offline

        //  all images >> load offline

        //  all images >> load offline
        val builder = Picasso.Builder(this)
        //builder.downloader(OkHttp3Downloader(this, Int.MAX_VALUE))
        builder.downloader(OkHttp3Downloader(this))
        val builtPicasso: Picasso = builder.build()
        builtPicasso.setIndicatorsEnabled(true)
        builtPicasso.setLoggingEnabled(true)

        Picasso.setSingletonInstance(builtPicasso)


        // ONLINE STATUS


        // ONLINE STATUS
        mAuth = FirebaseAuth.getInstance()
        currentOnlineUser = mAuth.getCurrentUser()

        if (currentOnlineUser != null) {
            val user_u_id = mAuth.getCurrentUser()!!.uid
            userDatabaseReference =
                FirebaseDatabase.getInstance().reference.child("users").child(user_u_id)
            userDatabaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    userDatabaseReference.child("active_now").onDisconnect()
                        .setValue(ServerValue.TIMESTAMP)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }


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