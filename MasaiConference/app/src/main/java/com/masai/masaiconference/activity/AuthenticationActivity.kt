package com.masai.masaiconference.activity


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.masai.masaiconference.R
import com.masai.masaiconference.databinding.ActivityAuthenticationBinding

import com.masai.masaiconference.extension.makeGone
import com.masai.masaiconference.extension.makeVisible


class AuthenticationActivity : AppCompatActivity() {
companion object {
    fun startActivity(context: Context) {
        val intent = Intent(context, AuthenticationActivity::class.java)
        context.startActivity(intent)
    }
}

private lateinit var binding: ActivityAuthenticationBinding
private val rcSignIn = 123

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityAuthenticationBinding.inflate(layoutInflater)
    setContentView(binding.root)

    showSkipSignIn()

    onSignInWithGoogleClick()
    onSignInWithEmailClick()
    onSkipClick()
    if (restorePrefData()) {
        val mainActivity = Intent(applicationContext, MainActivity::class.java)
        startActivity(mainActivity)
        finish()
    }
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    // RC_SIGN_IN is the request code you passed when starting the sign in flow.
    if (requestCode == rcSignIn) {
        val response = IdpResponse.fromResultIntent(data)
        if (resultCode == Activity.RESULT_OK) {
            // Successfully signed in
            //AppPref.isUserAuthenticated = true
            val intent = Intent(this@AuthenticationActivity , MainActivity::class.java)
            startActivity(intent)
            return

        } else {
            // Sign in failed
            if (response == null) {
                // User pressed back button
                Toast.makeText(applicationContext,getString(R.string.authentication_login_canceled),Toast.LENGTH_SHORT).show()
                return
            }
            if (response.error!!.errorCode == ErrorCodes.NO_NETWORK) {
                Toast.makeText(applicationContext,getString(R.string.all_error_internet_connectivity),Toast.LENGTH_SHORT).show()
                return
            }
            if (response.error!!.errorCode == ErrorCodes.UNKNOWN_ERROR) {
                Toast.makeText(applicationContext,getString(R.string.all_error_unknown),Toast.LENGTH_SHORT).show()
                return
            }
        }
    }
}

/**
 * Sets the visibility of the chipSkip based on the mandatory authentication configuration
 */
private fun showSkipSignIn() {
    if (resources.getBoolean(R.bool.enable_mandatory_authentication))
        binding.chipSkip.makeGone() else binding.chipSkip.makeVisible()
}

private fun onSignInWithGoogleClick() {
    binding.btnSignInGoogle.setOnClickListener {
        startSignInFlow(AuthUI.IdpConfig.GoogleBuilder().build())
        savePrefsData()
    }
}

private fun onSignInWithEmailClick() {
    binding.btnSignInEmail.setOnClickListener {
        startSignInFlow(AuthUI.IdpConfig.EmailBuilder().build())
        savePrefsData()
    }
}

private fun onSkipClick() {
    binding.chipSkip.setOnClickListener {
        val intent = Intent(this@AuthenticationActivity , MainActivity::class.java)
        startActivity(intent)
    }
}

private fun startSignInFlow(idpConfig: AuthUI.IdpConfig) {
    startActivityForResult(
        AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(
                listOf(
                    idpConfig
                )
            )
            .setTheme(R.style.AppTheme)
            .setIsSmartLockEnabled(false)
            .build(),
        rcSignIn
    )
}

    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        return pref.getBoolean("isAuthOpnend", false)
    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("isAuthOpnend", true)
        editor.commit()
    }
}
