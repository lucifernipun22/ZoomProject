package com.nhs.masaiconference.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nhs.masaiconference.Chatting.activity.ChattingActivity
//import com.nhs.masaiconference.Chatting.activity.ChattingActivity
import com.nhs.masaiconference.CreatMeetingActivity

import com.nhs.masaiconference.R

import com.nhs.masaiconference.activity.HistoryActivity
import com.nhs.masaiconference.activity.JoinActivity

import com.nhs.masaiconference.scheduler.views.AlarmActivity
import kotlinx.android.synthetic.main.fragment_meetand_chat.view.*


class MeetandChatFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_meetand_chat, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MeetandChatFragment().apply {
                arguments = Bundle().apply {}
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        secondInit(view)
       ThirdInit(view)
        FourthInit(view)
        FifthInit(view)
        //sixthInitView(view);
    }

   /* private fun sixthInitView(view: View) {

        view.appCompatButton4.setOnClickListener {
            val intent = Intent(activity, Workout::class.java)
            startActivity(intent)
        }
    }*/

    private fun initViews(view: View) {
        view.appCompatButtonHistory.setOnClickListener {
            val intent = Intent(activity, HistoryActivity::class.java)
            startActivity(intent)

        }
    }


    private fun secondInit(view: View){
        view.appCompatButton_create.setOnClickListener {
            val intent = Intent(activity, CreatMeetingActivity::class.java)


            startActivity(intent)
        }
    }
    private fun ThirdInit(view: View) {
        view.cardView.setOnClickListener {
            val intent = Intent(activity, ChattingActivity::class.java)
            startActivity(intent)

        }
    }
    private fun FourthInit(view: View) {

        view.joinMeeting.setOnClickListener {
            val intent = Intent(activity, JoinActivity::class.java)
            startActivity(intent)

        }
    }
    private fun FifthInit(view: View) {
        view.appCompatButton3.setOnClickListener {
            val intent = Intent(activity, AlarmActivity::class.java)
            startActivity(intent)

        }
    }

}