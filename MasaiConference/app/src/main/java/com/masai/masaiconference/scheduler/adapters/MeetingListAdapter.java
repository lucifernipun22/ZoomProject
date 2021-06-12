package com.masai.masaiconference.scheduler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;


import com.masai.masaiconference.R;
import com.masai.masaiconference.scheduler.fragments.MeetingListFragment;
import com.masai.masaiconference.scheduler.models.alarm;

import java.util.List;



public class MeetingListAdapter extends ArrayAdapter<alarm> {

    CardView cardView;
    TextView textViewTitle, textViewLocation, textViewStartTime, textViewTimeHour, textViewTimeHalf;
    MeetingListFragment.MeetingListType listType;

    public MeetingListAdapter(Context context, int resource, List<alarm> objects, MeetingListFragment.MeetingListType listType) {
        super(context, resource, objects);
        this.listType = listType;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        alarm alarm = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_meeting, parent, false);
        }

        cardView = (CardView) convertView.findViewById(R.id.cardViewMeeting);
        textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
        textViewLocation = (TextView) convertView.findViewById(R.id.textViewLocation);
        textViewStartTime = (TextView) convertView.findViewById(R.id.textViewStartTime);
        textViewTimeHour = (TextView) convertView.findViewById(R.id.textViewTimeHour);
        textViewTimeHalf = (TextView) convertView.findViewById(R.id.textViewTimeHalf);

        textViewTitle.setText(alarm.title);

        if (alarm.location.length() > 0) {
            textViewLocation.setText(alarm.location);
            textViewLocation.setVisibility(View.VISIBLE);
        } else
            textViewLocation.setVisibility(View.GONE);

        String timeString = alarm.startDateTime.toString("h:mm a") + " - " + alarm.endDateTime.toString("h:mm a");
        textViewStartTime.setText(timeString);

        if (listType != MeetingListFragment.MeetingListType.MEETING_LIST_TYPE_ALL) {
            textViewTimeHour.setText(alarm.startDateTime.toString("h"));
            textViewTimeHalf.setText(alarm.startDateTime.toString("a"));
        } else {
            textViewTimeHour.setText(alarm.startDateTime.toString("d"));
            textViewTimeHalf.setText(alarm.startDateTime.toString("MMM"));
        }


        return convertView;
    }
}
