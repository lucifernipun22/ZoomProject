package com.nhs.masaiconference.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType
import com.nhs.masaiconference.R


class IntroductionActivity : AppIntro2() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, IntroductionActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addIntroFragments()
        setTransformer(AppIntroPageTransformerType.Flow)


        // when this activity is about to be launch we need to check if its opened before or not
        if (restorePrefData()) {
            val mainActivity = Intent(applicationContext, AuthenticationActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)

        //AppPref.isAppIntroShown = true
        AuthenticationActivity.startActivity(this)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)

       // AppPref.isAppIntroShown = true
        AuthenticationActivity.startActivity(this)
        savePrefsData()
        finish()
    }

    private fun addIntroFragments() {
        addSlide(
            AppIntroFragment.newInstance(
                getString(R.string.app_intro_meeting_title),
                getString(R.string.app_intro_meeting_desc),
                imageDrawable = R.drawable.img1,
                backgroundDrawable = R.drawable.bg_app_intro
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                getString(R.string.app_intro_chat_title),
                getString(R.string.app_intro_chat_desc),
                imageDrawable = R.drawable.img2,
                backgroundDrawable = R.drawable.bg_app_intro
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                getString(R.string.app_intro_meeting_history_title),
                getString(R.string.app_intro_meeting_history_desc),
                imageDrawable = R.drawable.ic_meeting_history,
                backgroundDrawable = R.drawable.bg_app_intro
            )
        )
    }
    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        return pref.getBoolean("isIntroOpnend", false)
    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("isIntroOpnend", true)
        editor.commit()
    }
}