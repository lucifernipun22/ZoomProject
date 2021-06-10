package com.masai.masaiconference.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.masai.masaiconference.R
import kotlinx.android.synthetic.main.fragment_contact.*


class ContactFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ContactFragment().apply {
                arguments = Bundle().apply {}
            }
    }



}