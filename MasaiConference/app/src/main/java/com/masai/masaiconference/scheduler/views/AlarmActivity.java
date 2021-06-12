package com.masai.masaiconference.scheduler.views;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.masai.masaiconference.R;
import com.masai.masaiconference.scheduler.controllers.MeetingController;
import com.masai.masaiconference.scheduler.fragments.MeetingFragment;
import com.masai.masaiconference.scheduler.fragments.MeetingListFragment;
import com.masai.masaiconference.scheduler.models.alarm;


public class AlarmActivity extends AppCompatActivity implements MeetingFragment.Delegate, ViewPager.OnPageChangeListener {

    ViewPager mViewPager;
    SectionsPagerAdapter mSectionsPagerAdapter;
    private FloatingActionButton floatingActionButton;
    private MeetingFragment meetingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        if (getSupportActionBar() != null)
            getSupportActionBar().setElevation(0);

        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancelAll();

        if (savedInstanceState == null) { //keep the same fragment when rotated
            meetingFragment = new MeetingFragment();
            meetingFragment.delegate = this;
        }

        MeetingController.getInstance().setContext(getApplicationContext());
        MeetingController.getInstance().loadMeetings();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMeetingFragment(null);
            }
        });
    }


    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        if (fragment instanceof MeetingFragment) {
            this.meetingFragment = (MeetingFragment) fragment;
            this.meetingFragment.delegate = this;
        }
    }

    public void showMeetingFragment(alarm alarm) {
        MeetingListFragment meetingListFragment = (MeetingListFragment) mSectionsPagerAdapter.getItem(mViewPager.getCurrentItem());

        if (meetingListFragment != null && meetingListFragment.mode != null)
            meetingListFragment.mode.finish();

        if (alarm != null) {
            meetingFragment = MeetingFragment.newInstance(alarm.id);
        } else {
            meetingFragment = new MeetingFragment();
        }

        meetingFragment.delegate = this;

        meetingFragment.show(getFragmentManager(), "dialog");

        floatingActionButton.hide();
    }

    public void hideMeetingFragment() {
        floatingActionButton.show();

        meetingFragment.dismiss();
    }

    @Override
    public void closeFragment() {
        hideMeetingFragment();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        //hides the actionmode if it is shown
        for (int i = 0; i < 3; i++) {
            MeetingListFragment listFragment = (MeetingListFragment) mSectionsPagerAdapter.getItem(i);

            if (listFragment != null && listFragment.mode != null)
                listFragment.mode.finish();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        MeetingListFragment today = MeetingListFragment.newInstance(MeetingListFragment.MeetingListType.MEETING_LIST_TYPE_TODAY);
        MeetingListFragment tomorrow = MeetingListFragment.newInstance(MeetingListFragment.MeetingListType.MEETING_LIST_TYPE_TOMORROW);
        MeetingListFragment all = MeetingListFragment.newInstance(MeetingListFragment.MeetingListType.MEETING_LIST_TYPE_ALL);

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return today;
                case 1:
                    return tomorrow;
                case 2:
                    return all;
                default:
                    return all;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Today";
                case 1:
                    return "Tomorrow";
                case 2:
                    return "All";
            }
            return null;
        }
    }


}
