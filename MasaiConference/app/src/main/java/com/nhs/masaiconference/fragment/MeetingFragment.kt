package com.nhs.masaiconference.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.nhs.masaiconference.R
import com.nhs.masaiconference.slider.SlidePagerAdapter
import com.nhs.masaiconference.slider.slide

import kotlinx.android.synthetic.main.fragment_meeting.*
import kotlin.concurrent.fixedRateTimer


/*class MeetingFragment : Fragment() {

    var lstslides:MutableList<slide> =ArrayList()
    var sliderPage: ViewPager?=null
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {








        return inflater.inflate(R.layout.fragment_meeting, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            MeetingFragment().apply {
                arguments = Bundle().apply {}
            }
    }


}*/
import android.content.Intent

import android.widget.Toast
import com.nhs.masaiconference.CreatMeetingActivity
import com.nhs.masaiconference.model.Meeting
import com.nhs.masaiconference.util.MeetingUtils
import com.nhs.masaiconference.viewModel.MainViewModel

import kotlinx.android.synthetic.main.fragment_meeting.*
import org.koin.androidx.viewmodel.ext.android.viewModel
class MeetingFragment : Fragment(), View.OnClickListener {

    val meetingActivity = CreatMeetingActivity
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_meeting, container, false)
    }
    companion object {
        @JvmStatic
        fun newInstance() =
                MeetingFragment().apply {
                    arguments = Bundle().apply {}
                }

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }
    private fun setOnClickListeners() {
        Btn_MeetingStart.setOnClickListener(this)
        Btn_SendInvitation.setOnClickListener(this)
        Btn_MeetingEdit.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when (view) {
            Btn_MeetingStart -> {
                joinMeeting(meetingActivity.MEETING_CODE)
            }
            Btn_SendInvitation -> {
                shareMeetingInvitationCode(meetingActivity.MEETING_CODE)
            }
            Btn_MeetingEdit -> {
                Toast.makeText(context, "Meeting Edited", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun joinMeeting(meetingCode: String) {
        // Start Meeting
        MeetingUtils.startMeeting(requireContext(), meetingCode, R.string.all_joining_meeting)
        // Add meeting to db
        viewModel.addMeetingToDb(Meeting(meetingCode, System.currentTimeMillis()))
    }
    private fun shareMeetingInvitationCode(meetingCode: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, meetingCode)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "Share Meeting Invitation")
        startActivity(shareIntent)
    }
}
