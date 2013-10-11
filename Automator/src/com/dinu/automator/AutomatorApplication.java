package com.dinu.automator;

import android.app.Application;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibrary;

public class AutomatorApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		LocationLibrary.showDebugOutput(true);
		LocationLibrary.initialiseLibrary(getBaseContext(), 60*1000, 2 * 60 * 1000,"com.dinu.automator");
		
//		LocationLibrary.
	}
}
