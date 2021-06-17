package com.nhs.masaiconference.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.nhs.masaiconference.Chatting.activity.LoginActivity
import com.nhs.masaiconference.Chatting.activity.SettingActivity
import com.nhs.masaiconference.R
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.txt_welcome
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.include_sign_in.*


class SettingsFragment : Fragment() {

    private val getUserDatabaseReference: DatabaseReference? = null
    var mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
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
        intiView(view)
        intiView2(view)


    }



    private fun intiView(view: View) {
        view.cardView_profile.setOnClickListener {
            val intent = Intent(activity, SettingActivity::class.java)
            startActivity(intent)

        }
        var Email = mAuth.currentUser!!.email


        view.txt_register.text = "${Email!!.substring(0..2)}******@gmail.com"




    }
    private fun intiView2(view: View){
        btn_update.setOnClickListener {
            logOutUser()
            mAuth.signOut()
        }
        /*var Name = mAuth.currentUser!!.displayName
        view.txt_welcome.text = "${Name!!}"*/
        var Name = mAuth.currentUser!!.displayName
        txt_welcome.text = Name
    }



    open fun logOutUser() {
        val loginIntent = Intent(activity, LoginActivity::class.java)
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(loginIntent)


    }


}