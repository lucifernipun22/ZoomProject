package com.nhs.masaiconference.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nhs.masaiconference.Chatting.activity.ChattingActivity
import com.nhs.masaiconference.R
import com.nhs.masaiconference.fragment.ContactFragment
import com.nhs.masaiconference.fragment.MeetandChatFragment
import com.nhs.masaiconference.fragment.MeetingFragment
import com.nhs.masaiconference.fragment.SettingsFragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var navigationView: BottomNavigationView? = null
     var TIME_LIMIT = 1500
     var backPressed: Long = 0
    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, AuthenticationActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        addFragment(MeetandChatFragment.newInstance())
        bottomNavigation.show(0)
        bottomNavigation.add(
            MeowBottomNavigation.Model(
                0,
                R.drawable.ic_baseline_chat_bubble_outline_24
            )
        )
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_access_time_24))
        bottomNavigation.add(
            MeowBottomNavigation.Model(
                2,
                R.drawable.ic_baseline_perm_contact_calendar_24
            )
        )
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_baseline_settings_24))


        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(MeetandChatFragment.newInstance())

                }
                1 -> {
                    replaceFragment(MeetingFragment.newInstance())

                }
                2 -> {
                    replaceFragment(ContactFragment.newInstance())
                }
                3 -> {
                    replaceFragment(SettingsFragment.newInstance())
                }

                else -> {
                    replaceFragment(MeetandChatFragment.newInstance())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    // This method is used to detect back button


}