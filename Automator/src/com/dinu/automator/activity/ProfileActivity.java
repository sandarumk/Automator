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
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.Constant;
import com.dinu.automator.Profile;
import com.dinu.automator.R;
import com.dinu.automator.adapter.ProfileListAdapter;

public class ProfileActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);

		getSupportActionBar().show();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		Profile profile1 = new Profile(1, "pro1");
		Profile profile2 = new Profile(2, "pro2");
		Profile profile3 = new Profile(3, "pro3");
		Profile profile4 = new Profile(4, "pro4");

		final List<Profile> profileList = new ArrayList<Profile>();
		profileList.add(profile1);
		profileList.add(profile2);
		profileList.add(profile3);
		profileList.add(profile4);

		ProfileListAdapter adapter1 = new ProfileListAdapter(this, R.layout.profile_list_row,
				R.id.profle_list_row_text, profileList);
		ListView listView = (ListView) findViewById(R.id.listView_profile_list);

		listView.setAdapter(adapter1);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

				// TODO Auto-generated
				Profile profile = profileList.get(position);
				Toast.makeText(getApplicationContext(), "You selected " + profile.getName(), Toast.LENGTH_LONG).show();
				Intent intent = new Intent(ProfileActivity.this, ProfileSettingsActivity.class);
				intent.putExtra(Constant.INTENT_EXTRA_PROFILE_INDEX, position);
				startActivity(intent);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// do your own thing here
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.profile, menu);
	// return true;
	// }

}
