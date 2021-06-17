package com.nhs.masaiconference.scheduler.controllers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.nhs.masaiconference.R;
import com.nhs.masaiconference.scheduler.models.alarm;
import com.nhs.masaiconference.scheduler.views.AlarmActivity;


public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (MeetingController.getInstance().getContext() == null) { //If app was closed
            MeetingController.getInstance().setContext(context);
            MeetingController.getInstance().loadMeetingsSynchronous();
        }

        alarm alarm = MeetingController.getInstance().meetings.get(intent.getLongExtra("meeting_id", -1));

        if (alarm != null) {
            Intent resultIntent = new Intent(context, AlarmActivity.class);
            resultIntent.putExtra("meeting_id", alarm.id);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(AlarmActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

            int minutesAway = intent.getIntExtra("minutes_away", 15);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Meeting in " + (minutesAway == 60 ? "1 hour" : minutesAway + " minutes"))
                    .setContentText(alarm.title)
                    .setContentIntent(resultPendingIntent)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setCategory(Notification.CATEGORY_REMINDER)
                    .setWhen(alarm.startDateTime.toDate().getTime());

            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(((int) alarm.id), mBuilder.build());
        }
    }
}
