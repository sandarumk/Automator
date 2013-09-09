package com.dinu.automator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dinu.automator.DataStore;
import com.dinu.automator.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DataStore.retrieveData(this);

		ListView mainMenu = (ListView) findViewById(R.id.listView_main);
		String[] mainMenuItems = { getResources().getString(R.string.list_row_profile),
				getResources().getString(R.string.list_row_alarm), getResources().getString(R.string.list_row_sms) };// ,getResources().getString(R.string.list_row_settings)};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.profile_list_row,
				R.id.profle_list_row_text, mainMenuItems);
		mainMenu.setAdapter(adapter);

		mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {

				if (position == 0) {
					startActivity(new Intent(MainActivity.this, ProfileActivity.class));
				} else if (position == 1) {
					startActivity(new Intent(MainActivity.this, AlarmActivity.class));
				} else if (position == 2) {
					startActivity(new Intent(MainActivity.this, SmsActivity.class));
				} else if (position == 3) {
					startActivity(new Intent(MainActivity.this, Settings.class));
					// startActivity(new
					// Intent(MainActivity.this,LocatorActivity.class));
				}
				// TODO Auto-generated method stub

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
