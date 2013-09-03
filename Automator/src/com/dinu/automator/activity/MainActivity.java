package com.dinu.automator.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.dinu.automator.DataStore;
import com.dinu.automator.Profile;
import com.dinu.automator.R;
import com.dinu.automator.R.id;
import com.dinu.automator.R.layout;
import com.dinu.automator.R.menu;

public class MainActivity extends Activity {
	
	private DataStore dataStore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//dataStore.retrieveData();
		
		ListView mainMenu= (ListView) findViewById(R.id.listView_main);
		String[] mainMenuItems = {getResources().getString(R.string.list_row_profile),getResources().getString(R.string.list_row_alarm),getResources().getString(R.string.list_row_sms),getResources().getString(R.string.list_row_settings)};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.profile_list_row,R.id.profle_list_row_text,mainMenuItems);
		mainMenu.setAdapter(adapter);
		
		mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
					long id) {
		
				if(position == 0){
					startActivity(new Intent(MainActivity.this,ProfileActivity.class));
				}else if(position == 1){
					startActivity(new Intent(MainActivity.this,AlarmActivity.class));
				}else if(position == 2){
					startActivity(new Intent(MainActivity.this,SmsActivity.class));
				}else if(position == 3){
					//startActivity(new Intent(MainActivity.this,Settings.class));
					startActivity(new Intent(MainActivity.this,LocatorActivity.class));
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
