package com.dinu.automator.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.dinu.automator.R;
import com.dinu.automator.R.layout;
import com.dinu.automator.R.menu;

public class SmsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sms, menu);
		return true;
	}

}