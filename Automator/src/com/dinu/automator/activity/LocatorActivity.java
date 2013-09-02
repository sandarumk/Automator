package com.dinu.automator.activity;

import com.dinu.automator.R;
import com.dinu.automator.R.layout;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;


public class LocatorActivity extends Activity {
	
	Location location;
	int radius;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locator);
		
	}

	
}
