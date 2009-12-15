package com.googlecode.chartdroid.calendar;

import java.text.DateFormat;
import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.googlecode.chartdroid.R;

public class EventListAdapter extends ResourceCursorAdapter {

	static final String TAG = "Chartdroid"; 
	
    public EventListAdapter(Context context, int layout, Cursor cursor) {
    	super(context, layout, cursor);
    }


	public void bindView(View view, Context context, Cursor cursor) {

		TextView category_name = (TextView) view.findViewById(R.id.category_name);
		TextView assignment_timestamp = (TextView) view.findViewById(R.id.assignment_timestamp);
		
		int timestamp_column = cursor.getColumnIndex(EventListActivity.KEY_TIMESTAMP);
		int name_column = cursor.getColumnIndex(EventListActivity.KEY_EVENT_TITLE);
		
		category_name.setText(cursor.getString(name_column));

	    long timestamp = cursor.getLong(timestamp_column);
	    Date earliest = new Date(timestamp * 1000);
	    String formatted_date = DateFormat.getDateTimeInstance().format(earliest);
		assignment_timestamp.setText(formatted_date);
	}
}