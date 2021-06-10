package com.masai.masaiconference

import android.content.Intent
import com.masai.masaiconference.viewModel.MainViewModel
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.dynamiclinks.ktx.navigationInfoParameters
import com.google.firebase.dynamiclinks.ktx.shortLinkAsync
import com.google.firebase.ktx.Firebase
import com.masai.masaiconference.activity.HistoryActivity
import com.masai.masaiconference.databinding.ActivityCreatMeetingBinding
import com.masai.masaiconference.extension.*
import com.masai.masaiconference.model.Meeting
import com.masai.masaiconference.util.MeetingUtils
import kotlinx.android.synthetic.main.activity_creat_meeting.*
import kotlinx.android.synthetic.main.activity_creat_meeting.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreatMeetingActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>() // Lazy inject ViewModel
    private lateinit var binding: ActivityCreatMeetingBinding

    private val minMeetingCodeLength = 10
    private var currentUser: FirebaseUser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatMeetingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentUser = FirebaseAuth.getInstance().currentUser
        binding.groupJoinMeeting.makeGone()
        binding.groupCreateMeeting.makeVisible()
        val meetingCode = generateMeetingCode()
        binding.etCodeCreateMeeting.setText(meetingCode)

        onCreateMeetingCodeChange()
        onShareMeetingCodeClick()
        onCreateMeetingClick()
        ivMeetingHistory.setOnClickListener {
            onHistory()
        }



    }

    private fun onHistory() {
        val intent = Intent(this@CreatMeetingActivity, HistoryActivity::class.java)
        startActivity(intent)
    }

    private fun createMeeting(meetingCode: String) {
        MeetingUtils.startMeeting(
            this,
            meetingCode,
            R.string.all_creating_meeting
        ) // Start Meeting

        viewModel.addMeetingToDb(
            Meeting(
                meetingCode,
                System.currentTimeMillis()
            )
        ) // Add meeting to db
    }


    private fun onCreateMeetingCodeChange() {
        binding.tilCodeCreateMeeting.etCodeCreateMeeting.doOnTextChanged { text, _, _, _ ->
            if (text.toString().trim()
                    .replace(" ", "").length >= minMeetingCodeLength
            ) binding.tilCodeCreateMeeting.error = null
        }
    }

    private fun generateMeetingCode(): String {
        val allowedChars = ('a'..'z') + ('0'..'9')
        return (1..10)
            .map { allowedChars.random() }
            .joinToString("")
    }





    private fun onShareMeetingCodeClick() {
        binding.tilCodeCreateMeeting.setEndIconOnClickListener {
            if (isMeetingCodeValid(getCreateMeetingCode())) {
                tilCodeCreateMeeting.error = null
                toast(getString(R.string.main_creating_dynamic_link))

                Firebase.dynamicLinks.shortLinkAsync {
                    link = Uri.parse(getString(R.string.app_deep_link_url, getCreateMeetingCode()))
                    domainUriPrefix = getString(R.string.app_dynamic_link_url_prefix)
                    androidParameters {}
                    navigationInfoParameters {
                        forcedRedirectEnabled = true // Directly open the link in the app
                    }
                }.addOnSuccessListener { result ->
                    val shortDynamicLink = result.shortLink.toString()
                    startShareTextIntent(
                        getString(R.string.main_share_meeting_code_title),
                        getString(R.string.main_share_meeting_code_desc, shortDynamicLink)
                    )
                }.addOnFailureListener {
                    toast(getString(R.string.main_error_create_dynamic_link))
                }
            } else {
                binding.tilCodeCreateMeeting.error =
                    getString(R.string.main_error_meeting_code_length, minMeetingCodeLength)
            }
        }
    }

    private fun getCreateMeetingCode() =
        binding.etCodeCreateMeeting.text.toString().trim().replace(" ", "")

    private fun isMeetingCodeValid(meetingCode: String): Boolean {
        return if (meetingCode.length >= minMeetingCodeLength) {
            true
        } else {
            Snackbar.make(
               constrainLayout,
                getString(R.string.main_error_meeting_code_length, minMeetingCodeLength),
                Snackbar.LENGTH_SHORT
            ).show()
            false
        }
    }
    private fun onCreateMeetingClick() {
        binding.btnCreateMeeting.setOnClickListener {
            if (isMeetingCodeValid(getCreateMeetingCode())) {
                  createMeeting(getCreateMeetingCode())
                } else {
                    createMeeting(getCreateMeetingCode())
                }
            }
        }
    }
