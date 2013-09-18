package com.dinu.automator;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibrary;

public class locatorService extends IntentService {

	public locatorService(String name) {
		super(name);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		try {
			LocationLibrary.initialiseLibrary(getBaseContext(), "com.dinu.automator");
		} catch (UnsupportedOperationException ex) {
			Log.d("TestApplication",
					"UnsupportedOperationException thrown - the device doesn't have any location providers");
		}
	}

	@Override
	protected void onHandleIntent(Intent intent) {

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return flags;
	}

}
