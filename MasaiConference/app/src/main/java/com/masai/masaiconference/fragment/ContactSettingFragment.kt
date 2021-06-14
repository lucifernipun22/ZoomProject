package com.masai.masaiconference.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masai.masaiconference.R
import kotlinx.android.synthetic.main.app_bar_meetingsettings.*
import kotlinx.android.synthetic.main.fragment_contact_setting.*


class ContactSettingFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_setting, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ContactSettingFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_SettingTitle.text = "Contacts"
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        BtnBackToSetting.setOnClickListener (this)
        ryl_ContactRequest.setOnClickListener (this)
        ryl_PhoneContact.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
       when(v){
           BtnBackToSetting -> { replaceFragment(SettingsFragment.newInstance()) }
           ryl_ContactRequest -> { replaceFragment(SettingsFragment.newInstance()) }
           ryl_PhoneContact -> { replaceFragment(PhoneContactMatchingFragment.newInstance()) }
       }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransition = requireFragmentManager().beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }
}