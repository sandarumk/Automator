package com.dinu.automator.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.dinu.automator.R;
import com.dinu.automator.R.layout;
import com.dinu.automator.R.menu;

public class AlarmActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}

}
