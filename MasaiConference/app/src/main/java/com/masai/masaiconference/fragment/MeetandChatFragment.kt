package com.masai.masaiconference.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.infideap.drawerbehavior.AdvanceDrawerLayout
import com.masai.masaiconference.CreatMeetingActivity
import com.masai.masaiconference.R
import com.masai.masaiconference.`interface`.OnRowItemClicked
import com.masai.masaiconference.activity.HistoryActivity
import com.masai.masaiconference.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_meetand_chat.*
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
    }
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


}