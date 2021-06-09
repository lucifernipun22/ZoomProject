package com.masai.masaiconference.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.masai.masaiconference.R
import com.masai.masaiconference.fragment.ContactFragment
import com.masai.masaiconference.fragment.MeetandChatFragment
import com.masai.masaiconference.fragment.MeetingFragment
import com.masai.masaiconference.fragment.SettingsFragment


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

        navigationView = findViewById(R.id.navigation);
        //navigationView.setOnNavigationItemSelectedListener(selectedListener);
        navigationView?.setOnNavigationItemSelectedListener(selectedListener)

        actionBar?.setTitle("Meet & Chat");
        val fragment = MeetandChatFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, fragment, "")
        fragmentTransaction.commit()
    }
    private val selectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_chat -> {
                    actionBar!!.title = "Meet & Chat"
                    val listFragment = MeetandChatFragment()
                    val fragmentTransaction3 = supportFragmentManager.beginTransaction()
                    fragmentTransaction3.replace(R.id.content, listFragment, "")
                    fragmentTransaction3.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_home -> {
                    actionBar!!.title = "Meetings"
                    val fragment = MeetingFragment()
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.content, fragment, "")
                    fragmentTransaction.commit()
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_users -> {
                    actionBar!!.title = "Contacts"
                    val fragment2 = ContactFragment()
                    val fragmentTransaction2 = supportFragmentManager.beginTransaction()
                    fragmentTransaction2.replace(R.id.content, fragment2, "")
                    fragmentTransaction2.commit()
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_addblogs -> {
                    actionBar!!.title = "Settings"
                    val fragment4 = SettingsFragment()
                    val fragmentTransaction4 = supportFragmentManager.beginTransaction()
                    fragmentTransaction4.replace(R.id.content, fragment4, "")
                    fragmentTransaction4.commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

}