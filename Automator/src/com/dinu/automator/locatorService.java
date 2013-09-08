package com.dinu.automator;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibrary;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class locatorService extends IntentService{

	public locatorService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		try{
			LocationLibrary.initialiseLibrary(getBaseContext(), "com.dinu.automator");
		}catch(UnsupportedOperationException ex){
			Log.d("TestApplication", "UnsupportedOperationException thrown - the device doesn't have any location providers");
		}
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public int onStartCommand( Intent intent, int flags, int startId )
	{
		return flags;
	}

	
}
