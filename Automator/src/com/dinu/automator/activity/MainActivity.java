package com.dinu.automator.activity;

/*
 * @author Dinu
 * Main Activity to choose the expected functionality
 */

import android.content.Intent;
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

public class MainActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DataStore.retrieveData(this);

		// handle profile
		TextView profileView = (TextView) findViewById(R.id.main_menu_profile_text);
		
		// handle click on the profile text view
		profileView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// go to profile list
				startActivity(new Intent(MainActivity.this, ProfileActivity.class));
			}
		});

		
		

		// handle alarm
		TextView alarmView = (TextView) findViewById(R.id.main_menu_alarm_text);
		

		// handle click on the alarm text view
		alarmView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// go to alarm list
				startActivity(new Intent(MainActivity.this, AlarmActivity.class));
			}
		});

		

		// handle sms
		TextView smsView = (TextView) findViewById(R.id.main_menu_sms_text);
		
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

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		getSupportActionBar().setTitle(R.string.app_name);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_settings:
			startActivity(new Intent(MainActivity.this, Settings.class));
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
