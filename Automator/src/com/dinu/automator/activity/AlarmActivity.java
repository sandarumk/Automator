package com.dinu.automator.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.Alarm;
import com.dinu.automator.Constant;
import com.dinu.automator.DataStore;
import com.dinu.automator.Profile;
import com.dinu.automator.R;
import com.dinu.automator.R.layout;
import com.dinu.automator.R.menu;
import com.dinu.automator.adapter.AlarmListAdapter;
import com.dinu.automator.adapter.ProfileListAdapter;
import com.dinu.automator.util.ViewUtils;

public class AlarmActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		getSupportActionBar().show();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		ViewUtils.setActionBarColor(this);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setupList();
	}
	
	private void setupList() {
		// set up the sms list using an adapter
		final List<Alarm> alarmList = new ArrayList<Alarm>();
		alarmList.addAll(DataStore.getAlarmList());
		
		AlarmListAdapter adapter1 = new AlarmListAdapter(this, R.layout.alarm_list_row, R.id.alarm_list_row_text, alarmList);
		ListView listView = (ListView) findViewById(R.id.listView_alarm_list);
		listView.setAdapter(adapter1);
		// handle click on alarms
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Intent intent = new Intent(AlarmActivity.this, AlarmSettingsActivity.class);
				intent.putExtra(Constant.INTENT_EXTRA_ALARM_INDEX, position);
				startActivity(intent);
			}

		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.alarm, menu);
		getSupportActionBar().setTitle(R.string.alarm_activity_title);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_new_alarm:
			Intent intent = new Intent(AlarmActivity.this, AlarmSettingsActivity.class);
			intent.putExtra(Constant.INTENT_EXTRA_ALARM_INDEX, -1);
			startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
