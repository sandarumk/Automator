package com.dinu.automator;

import android.app.Application;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibrary;

public class AutomatorApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		LocationLibrary.initialiseLibrary(getBaseContext(), "com.dinu.automator");
		
//		LocationLibrary.
	}
}
