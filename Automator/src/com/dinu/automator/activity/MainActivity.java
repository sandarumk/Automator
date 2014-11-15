package com.dinu.automator.activity;

/*
 * @author Dinu
 * Main Activity to choose the expected functionality
 */

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.AutomaterService;
import com.dinu.automator.AutomatorApplication;
import com.dinu.automator.DataStore;
import com.dinu.automator.R;
import com.dinu.automator.util.ViewUtils;

public class MainActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DataStore.retrieveData(this);

		// handle profile
		View profileView = findViewById(R.id.main_menu_profile_text);

		// handle click on the profile text view
		profileView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// go to profile list
				startActivity(new Intent(MainActivity.this, ProfileActivity.class));
			}
		});

		// handle alarm
		View alarmView = findViewById(R.id.main_menu_alarm_text);

		// handle click on the alarm text view
		alarmView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// go to alarm list
				startActivity(new Intent(MainActivity.this, AlarmActivity.class));
			}
		});

		// handle sms
		View smsView = findViewById(R.id.main_menu_sms_text);

		// handle click on the sms text view
		smsView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// go to sms list
				startActivity(new Intent(MainActivity.this, SmsActivity.class));
			}
		});

	}

	@Override
	public void onBackPressed() {

		super.onBackPressed();

		Intent intent = new Intent(this, AutomaterService.class);
		stopService(intent);
		startService(intent);
	}
}
