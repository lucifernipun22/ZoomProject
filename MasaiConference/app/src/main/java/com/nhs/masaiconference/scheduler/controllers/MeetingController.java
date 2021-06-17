package com.nhs.masaiconference.scheduler.controllers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;


import com.nhs.masaiconference.scheduler.models.alarm;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.MutableDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class MeetingController {
    private static MeetingController ourInstance = new MeetingController();
    public HashMap<Long, alarm> meetings;
    private Context context;

    private MeetingController() {
        meetings = new HashMap<>();
    }

    public static MeetingController getInstance() {
        return ourInstance;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    //Loads meetings from the database on a new thread (Will make app load times slow if on UI thread)
    //Also, meetings are only loaded from the db once, when the app is opened, because db calls are slow
    public void loadMeetings() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                meetings.putAll(DatabaseHelper.getInstance(context).loadMeetings());
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("meeting_created"));
            }
        }).start();
    }

    //Used solely for notifications
    public void loadMeetingsSynchronous() {
        meetings.putAll(DatabaseHelper.getInstance(context).loadMeetings());
    }

    public List<alarm> getMeetingsToday() {
        List<alarm> meetingsToday = new ArrayList<>();

        for (alarm alarm : meetings.values()) {
            if (DateTimeComparator.getDateOnlyInstance().compare(alarm.startDateTime, new DateTime()) == 0)
                meetingsToday.add(alarm);
        }

        return meetingsToday;
    }

    public List<alarm> getMeetingsTomorrow() {
        List<alarm> meetingsToday = new ArrayList<>();

        for (alarm alarm : meetings.values()) {
            MutableDateTime tomorrow = new MutableDateTime();
            tomorrow.addDays(1);
            if (DateTimeComparator.getDateOnlyInstance().compare(alarm.startDateTime, tomorrow) == 0)
                meetingsToday.add(alarm);
        }

        return meetingsToday;
    }

    public void createMeeting(alarm alarm) {
        if (alarm.id != -1) {
            DatabaseHelper.getInstance(context).updateMeeting(alarm);
            meetings.put(alarm.id, alarm);
        } else {
            alarm.id = DatabaseHelper.getInstance(context).createMeeting(alarm);
            meetings.put(alarm.id, alarm);
        }
        //Broadcasting event on meeting created, updates listViews
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("meeting_created"));

        if (alarm.notification > 0)
            createNotification(alarm);
    }

    public void deleteMeeting(alarm alarm) {
        DatabaseHelper.getInstance(context).deleteMeeting(alarm);

        meetings.remove(alarm.id);

        //Cancel notification
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        alarmIntent.putExtra("meeting_id", alarm.id);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, (int) alarm.id, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("meeting_created"));
    }

    //sets up the alarm for the notification
    private void createNotification(alarm alarm) {
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        alarmIntent.putExtra("meeting_id", alarm.id);
        alarmIntent.putExtra("minutes_away", alarm.notification);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, (int) alarm.id, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, alarm.startDateTime.toDate().getTime() - alarm.notification * 60000, pendingIntent);
    }
}
