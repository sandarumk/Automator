package com.dinu.automator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.Constant;
import com.dinu.automator.R;
import com.dinu.automator.view.ConfirmDeleteDialogFragment;
import com.dinu.automator.view.DisplaySettingsFragment;
import com.dinu.automator.view.LocationFragment;
import com.dinu.automator.view.NetworkSettingFragment;
import com.dinu.automator.view.SoundSettingsFramgement;
import com.dinu.automator.view.TestFragment;
import com.dinu.automator.view.setBatteryLevelFragment;
import com.viewpagerindicator.TabPageIndicator;

public class ProfileSettingsActivity extends SherlockFragmentActivity {

	private static final String[] CONTENT = new String[] { "Location", "Battery Level", "Sound", "Display", "Network" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_settings);
		
		
		int index = getIntent().getIntExtra(Constant.INTENT_EXTRA_PROFILE_INDEX, 0);

		FragmentPagerAdapter adapter = new TabbedPaneAdapter(getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		
		//if (getSupportActionBar()!=null){
			getSupportActionBar().show();
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	//	}
		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.profile_settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_save:
			//save the current set profile
			return true;
		case R.id.action_delete:
			DialogFragment fragment= new ConfirmDeleteDialogFragment();
			fragment.show(getSupportFragmentManager(), "Delete");
			//delete the current selected profile
			
		
			
		
		default:
			return super.onOptionsItemSelected(item);
		}
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.profile_settings, menu);
//		return true;
//	}

	class TabbedPaneAdapter extends FragmentPagerAdapter {
		public TabbedPaneAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
		if (position% CONTENT.length==0){
				return LocationFragment.getInstance();
			}else if(position % CONTENT.length==1){
				return setBatteryLevelFragment.newInstance();
			}else if(position % CONTENT.length==2){
				return SoundSettingsFramgement.getInstance();
			}else if(position % CONTENT.length==3){
				return DisplaySettingsFragment.getInstance();
			}else if(position % CONTENT.length==4){
				return NetworkSettingFragment.newInstance();
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
