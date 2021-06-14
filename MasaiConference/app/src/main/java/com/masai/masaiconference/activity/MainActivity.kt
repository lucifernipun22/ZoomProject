package com.masai.masaiconference.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.masai.masaiconference.R
import com.masai.masaiconference.fragment.ContactFragment
import com.masai.masaiconference.fragment.MeetandChatFragment
import com.masai.masaiconference.fragment.MeetingFragment
import com.masai.masaiconference.fragment.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var navigationView: BottomNavigationView? = null

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
            when (it.id) {
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

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }

    fun hideBottomNav() {
        bottomNavigation.setVisibility(View.GONE)
    }

    fun showBottomNav() {
        bottomNavigation.setVisibility(View.GONE)
    }
}