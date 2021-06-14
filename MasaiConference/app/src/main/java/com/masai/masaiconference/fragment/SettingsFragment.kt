package com.masai.masaiconference.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.masai.masaiconference.R
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment(), View.OnClickListener {

    var mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SettingsFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Toast.makeText(context, "${mAuth.currentUser!!.displayName}", Toast.LENGTH_SHORT).show()
        setUserData()
    }

    private fun setUserData() {
        Tv_UserDisplayNameSetting.text = mAuth.currentUser!!.displayName
        var Email = mAuth.currentUser!!.email
        Tv_UserEmailSetting.text = "${Email!!.substring(0..2)}******@gmail.com"
        Iv_UserProfilePicSetting.setOnClickListener(this)
        rl_UserProfileSetting.setOnClickListener(this)
        lyt_MeetingSetting.setOnClickListener(this)
        lyt_ContactSetting.setOnClickListener(this)
        lyt_ChatSetting.setOnClickListener(this)
        lyt_GeneralSetting.setOnClickListener(this)
        lyt_AboutSetting.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            Iv_UserProfilePicSetting -> {
                Toast.makeText(context, "Hello PIc", Toast.LENGTH_SHORT).show()
            }
            lyt_MeetingSetting -> {
                //Toast.makeText(context, "We Are Working On Meeting", Toast.LENGTH_SHORT).show()
                replaceFragment(MeetingSettingFragment.newInstance())
            }
            lyt_ContactSetting -> {
                replaceFragment(ContactSettingFragment.newInstance())
            }
            lyt_ChatSetting -> {
                Toast.makeText(context, "We Are Working On Chat Setting", Toast.LENGTH_SHORT).show()
            }
            lyt_GeneralSetting -> {
                Toast.makeText(context, "We Are Working On General Setting", Toast.LENGTH_SHORT)
                    .show()
            }
            lyt_AboutSetting -> {
                Toast.makeText(context, "We Are Working On About Setting", Toast.LENGTH_SHORT)
                    .show()
            }
            rl_UserProfileSetting->{
                Toast.makeText(context, "We Are User Profile Setting", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                Toast.makeText(context, "Wrong Choice", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = requireFragmentManager().beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}