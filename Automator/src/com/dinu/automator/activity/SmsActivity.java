package com.dinu.automator.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.Constant;
import com.dinu.automator.DataStore;
import com.dinu.automator.Profile;
import com.dinu.automator.R;
import com.dinu.automator.Sms;
import com.dinu.automator.adapter.ProfileListAdapter;
import com.dinu.automator.adapter.SmsListAdapter;

public class SmsActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
		
		getSupportActionBar().show();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setupList();
	}

	private void setupList() {
		// set up the sms list using an adapter
		final List<Sms> smsList = new ArrayList<Sms>();
		smsList.addAll(DataStore.getsmsList());
		SmsListAdapter adapter1 = new SmsListAdapter(this, R.layout.sms_list_row, R.id.sms_list_row_text, smsList);
		ListView listView = (ListView) findViewById(R.id.listView_sms_list);
		listView.setAdapter(adapter1);
		// handle click on profiles
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Intent intent = new Intent(SmsActivity.this, SmsSettingsActivity.class);
				intent.putExtra(Constant.INTENT_EXTRA_SMS_INDEX, position);
				startActivity(intent);
			}

		});
	}
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.sms, menu);
		getSupportActionBar().setTitle(R.string.sms_activity_title);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_new_sms:
			Intent intent = new Intent(SmsActivity.this, SmsSettingsActivity.class);
			intent.putExtra(Constant.INTENT_EXTRA_SMS_INDEX, -1);
			startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	

}
