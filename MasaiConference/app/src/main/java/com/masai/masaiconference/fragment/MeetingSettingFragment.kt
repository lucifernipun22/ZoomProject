package com.masai.masaiconference.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.masai.masaiconference.R
import kotlinx.android.synthetic.main.app_bar_meetingsettings.*
import kotlinx.android.synthetic.main.fragment_meeting_setting.*


class MeetingSettingFragment : Fragment(), View.OnClickListener {

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
        return inflater.inflate(R.layout.fragment_meeting_setting, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MeetingSettingFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // bottomNavigation!!.visibility = View.GONE
        // bottomNavigation.rootView.findViewById<View>(R.id.bottomNavigation).visibility = View.GON
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        BtnBackToSetting.setOnClickListener (this)
        ryl_MyMicrophone.setOnClickListener(this)
        ryl_AutoConnectAudio.setOnClickListener(this)
        ryl_MyVideo.setOnClickListener(this)
        ryl_AutoCopyInvite.setOnClickListener(this)
        ryl_MirrorVideo.setOnClickListener(this)
        ryl_ShowNameParticipantsJoin.setOnClickListener(this)
        ryl_ShowNonVideoParticipants.setOnClickListener(this)
        ryl_ShowVideoPreview.setOnClickListener(this)
        ryl_ClosedCaptioning.setOnClickListener(this)
        ryl_OriginalSound.setOnClickListener(this)
        ryl_ConnectedTime.setOnClickListener(this)
        ryl_SafeDriveMode.setOnClickListener(this)
        ryl_AspectRatio.setOnClickListener(this)
        ryl_ReactionTone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            BtnBackToSetting -> { replaceFragment(SettingsFragment.newInstance()) }
            ryl_AutoConnectAudio -> {Toast.makeText(context,"We Are Working On It",Toast.LENGTH_SHORT).show()}
            ryl_MyMicrophone -> { toggleSwitch(SwitchMuteMicrophone) }
            ryl_MyVideo -> { toggleSwitch(swtTurnOffVideo) }
            ryl_AutoCopyInvite -> { toggleSwitch(swtAutoCopyInvite) }
            ryl_MirrorVideo -> { toggleSwitch(swtMirrorMyVideo) }
            ryl_ShowNameParticipantsJoin -> { toggleSwitch(swtShowNameParticipantsJoin) }
            ryl_ShowNonVideoParticipants -> { toggleSwitch(swtShowNonVideoParticipants) }
            ryl_ShowVideoPreview -> { toggleSwitch(swtShowVideoPreview) }
            ryl_ClosedCaptioning -> { toggleSwitch(swtClosedCaptioning) }
            ryl_OriginalSound -> { toggleSwitch(swtOriginalSound) }
            ryl_ConnectedTime -> { toggleSwitch(swtConnectedTime) }
            ryl_SafeDriveMode -> { toggleSwitch(swtSafeDriveMode) }
            ryl_AspectRatio -> {Toast.makeText(context,"We Are Working On It",Toast.LENGTH_SHORT).show()}
            ryl_ReactionTone -> {Toast.makeText(context,"We Are Working On It",Toast.LENGTH_SHORT).show()}
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransition = requireFragmentManager().beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun toggleSwitch(switchButton: Switch?) {
        if (switchButton!!.isChecked) {
            switchButton!!.isChecked = false
        } else {
            switchButton!!.isChecked = true
        }
    }

    /*fun View.showOrGone(show: Boolean) {
        visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }*/
}