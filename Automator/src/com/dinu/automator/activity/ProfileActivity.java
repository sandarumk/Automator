package com.dinu.automator.activity;

/*
 * @author Dinu
 * Profile Activity
 */

import java.util.ArrayList;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.Constant;
import com.dinu.automator.DataStore;
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


	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setupList();
	}

	private void setupList() {
		// set up the profile list using an adapter
		final List<Profile> profileList = new ArrayList<Profile>();
		profileList.addAll(DataStore.getProfileList());
		ProfileListAdapter adapter1 = new ProfileListAdapter(this, R.layout.profile_list_row, R.id.profle_list_row_text, profileList);
		ListView listView = (ListView) findViewById(R.id.listView_profile_list);
		listView.setAdapter(adapter1);
		// handle click on profiles
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Intent intent = new Intent(ProfileActivity.this, ProfileSettingsActivity.class);
				intent.putExtra(Constant.INTENT_EXTRA_PROFILE_INDEX, position);
				startActivity(intent);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.profile, menu);
		getSupportActionBar().setTitle(R.string.profile_activity_title);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_new_profile:
			Intent intent = new Intent(ProfileActivity.this, ProfileSettingsActivity.class);
			intent.putExtra(Constant.INTENT_EXTRA_PROFILE_INDEX, -1);
			startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}


}
