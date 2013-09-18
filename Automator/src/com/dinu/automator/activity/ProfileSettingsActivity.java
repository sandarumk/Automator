package com.dinu.automator.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.Constant;
import com.dinu.automator.DataStore;
import com.dinu.automator.Profile;
import com.dinu.automator.R;
import com.dinu.automator.view.ConfirmDeleteDialogFragment;
import com.dinu.automator.view.DisplaySettingsFragment;
import com.dinu.automator.view.LocationFragment;
import com.dinu.automator.view.NetworkSettingFragment;
import com.dinu.automator.view.SetBatteryLevelFragment;
import com.dinu.automator.view.SoundSettingsFramgement;
import com.dinu.automator.view.TestFragment;
import com.viewpagerindicator.TabPageIndicator;

public class ProfileSettingsActivity extends SherlockFragmentActivity {

	private Profile profile;
	private int index;

	private static final String[] CONTENT = new String[] { "Location", "Battery Level", "Sound", "Display", "Network" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_settings);

		index = getIntent().getIntExtra(Constant.INTENT_EXTRA_PROFILE_INDEX, 0);

		if (index < 0) {
			profile = new Profile(this);
		} else {
			profile = DataStore.getProfileList().get(index);
		}

		SoundSettingsFramgement.getInstance().setSound(profile.getSounds());
		DisplaySettingsFragment.getInstance().setDisplay(profile.getDisplay());
		NetworkSettingFragment.getInstance().setNetwork(profile.getNetwork());
		SetBatteryLevelFragment.getInstance().setBattryLevel(profile.getBatteryLevel());
		LocationFragment.getInstance().setLocation(profile.getLocations(this));

		FragmentPagerAdapter adapter = new TabbedPaneAdapter(getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);

		if (getSupportActionBar() != null) {
			getSupportActionBar().show();
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.profile_settings, menu);
		getSupportActionBar().setTitle(profile.getName());
		return true;
	}

	@Override
	public void onBackPressed() {

		super.onBackPressed();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_save:
			// save the current selected profile
			SoundSettingsFramgement.getInstance().updateData();
			DisplaySettingsFragment.getInstance().updateData();
			LocationFragment.getInstance().updateData();
			NetworkSettingFragment.getInstance().updateData();

			if (index < 0) {
				DataStore.addProfile(profile);
				index = DataStore.getProfileList().size() - 1;
				showSaveDialog(this);

			} else {
				DataStore.saveProfiles(this);

				finish();
			}

			return true;

		case R.id.action_delete:
			// delete the current selected profile
			showDeleteDialog(this);
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showSaveDialog(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflator = this.getLayoutInflater();
		View view = inflator.inflate(R.layout.save_dialog_fragment, null);

		final EditText text = (EditText) view.findViewById(R.id.save_dialog_save);
		text.setHint("Profile Name");
		builder.setView(view);
		builder.setPositiveButton(R.string.dialog_button_save, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// save the profile
				profile.setName(text.getText().toString());
				DataStore.saveProfiles(context);
				finish();

			}
		});

		builder.create().show();

	}

	private void showDeleteDialog(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.dialog_message_confirm_delete)
				.setPositiveButton(R.string.dialog_button_delete, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int id) {
						if (index >= 0) {
							DataStore.deleteProfile(profile);
							DataStore.saveProfiles(context);
						}
						finish();

					}
				}).setNegativeButton(R.string.dialog_button_cancel, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int id) {

					}
				});
		builder.create().show();
	}

	class TabbedPaneAdapter extends FragmentPagerAdapter {
		public TabbedPaneAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			if (position % CONTENT.length == 0) {
				return LocationFragment.getInstance();
			} else if (position % CONTENT.length == 1) {
				return SetBatteryLevelFragment.getInstance();
			} else if (position % CONTENT.length == 2) {
				return SoundSettingsFramgement.getInstance();
			} else if (position % CONTENT.length == 3) {
				return DisplaySettingsFragment.getInstance();
			} else if (position % CONTENT.length == 4) {
				return NetworkSettingFragment.getInstance();
			}

			return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length].toUpperCase();
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}
	}

}
