package com.masai.masaiconference.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.masai.masaiconference.R
import com.masai.masaiconference.databinding.ActivityCreatMeetingBinding
import com.masai.masaiconference.databinding.ActivityJoinBinding
import com.masai.masaiconference.extension.*
import com.masai.masaiconference.historyItem.MeetingHistoryItem
import com.masai.masaiconference.model.Meeting
import com.masai.masaiconference.util.MeetingUtils
import com.masai.masaiconference.viewModel.MainViewModel
import com.mikepenz.fastadapter.FastAdapter
import kotlinx.android.synthetic.main.activity_creat_meeting.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class JoinActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>() // Lazy inject ViewModel
    private lateinit var binding: ActivityJoinBinding

    private val minMeetingCodeLength = 10
    private var currentUser: FirebaseUser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentUser = FirebaseAuth.getInstance().currentUser
        handleDynamicLink()
        onJoinMeetingClick()

        ivMeetingHistory.setOnClickListener {
            onHistory()
        }
        binding.groupCreateMeeting.makeGone()
        binding.groupJoinMeeting.makeVisible()

    }
    private fun onHistory() {
        val intent = Intent(this@JoinActivity, HistoryActivity::class.java)
        startActivity(intent)
    }


    private fun isMeetingCodeValid(meetingCode: String): Boolean {
        return if (meetingCode.length >= minMeetingCodeLength) {
            true
        } else {
            Snackbar.make(
                binding.constrainLayout,
                getString(R.string.main_error_meeting_code_length, minMeetingCodeLength),
                Snackbar.LENGTH_SHORT
            ).show()
            false
        }
    }


    private fun handleDynamicLink() {
        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener { pendingDynamicLinkData ->
                val deepLink: Uri?
                if (pendingDynamicLinkData != null) {
                    deepLink = pendingDynamicLinkData.link
                    deepLink?.getQueryParameter("meetingCode")?.let { joinMeeting(it) }
                }
            }
            .addOnFailureListener { _ ->
                toast(getString(R.string.main_error_fetch_dynamic_link))
            }
    }
    /**
     * Called when the JOIN button is clicked of the JOIN MEETING toggle
     */
    private fun onJoinMeetingClick() {

        binding.btnJoin.setOnClickListener {
            if (isMeetingCodeValid(getJoinMeetingCode())) {
                 joinMeeting(
                        getJoinMeetingCode())
                } else {
                    joinMeeting(getJoinMeetingCode())
                }
            }

        }
    private fun joinMeeting(meetingCode: String) {
        MeetingUtils.startMeeting(
            this,
            meetingCode,
            R.string.all_joining_meeting
        ) // Start Meeting

        viewModel.addMeetingToDb(
            Meeting(
                meetingCode,
                System.currentTimeMillis()
            )
        ) // Add meeting to db
    }

    /**
     * Returns the meeting code for joining the meeting
     */
    private fun getJoinMeetingCode() =
        binding.etCodeJoinMeeting.text.toString().trim().replace(" ", "")


}

