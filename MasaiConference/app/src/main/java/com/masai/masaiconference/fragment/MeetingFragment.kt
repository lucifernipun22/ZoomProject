package com.masai.masaiconference.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masai.masaiconference.R


class MeetingFragment : Fragment() {


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
}