package com.dinu.automator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibraryConstants;

public class AutomaterService extends Service {

	private Map<BatteryLevel, ProfilePosition> batteryLevels; // map of enabled battery
														// levels and profile
														// index
	private Map<Location, ProfilePosition> locations; // value = "1,2" ->
														// profile,index=2

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		batteryLevels = new HashMap<BatteryLevel, ProfilePosition>();
		locations = new HashMap<Location, ProfilePosition>();

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("AutomatorService","service started");
		int result = super.onStartCommand(intent, flags, startId);
		Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
		IntentFilter lftIntentFilter = new IntentFilter(
				LocationLibraryConstants.getLocationChangedPeriodicBroadcastAction());
		registerReceiver(locationBroadcastReceiver, lftIntentFilter);
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(batterylevelReceiver, ifilter);
		DataStore.retrieveData(getApplication());
		List<Profile> profileList = new ArrayList<Profile>();
		profileList = DataStore.getProfileList();
		for (Profile profile : profileList) {
			if (profile.getBatteryLevel().isEnable()) {
				batteryLevels.put(profile.getBatteryLevel(), new ProfilePosition(1, profileList.indexOf(profile)));
			}
			if (profile.getLocations(getApplication()).isEnable()) {
				locations.put(profile.getLocations(getApplication()),
						new ProfilePosition(1, profileList.indexOf(profile)));
			}

		}
		profileList = null;
		List<Alarm> alarmList = new ArrayList<Alarm>();
		alarmList = DataStore.getAlarmList();
		for (Alarm alarm : alarmList) {
			if(alarm.getLocation().isEnable()){
					locations.put(alarm.getLocation(),
						new ProfilePosition(3, alarmList.indexOf(alarm)));
			}

		}
		alarmList = null;
		List<Sms> smsList = new ArrayList<Sms>();
		smsList = DataStore.getsmsList();
		for (Sms sms : smsList) {
			if(sms.getLocation().isEnable()){
					locations.put(sms.getLocation(),
						new ProfilePosition(3, smsList.indexOf(sms)));
			}

		}
		smsList = null;
		Timer timer= new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
			 handleLocations(locationInfo, getApplication());
				
			}
		}, 2*60*1000, 1*60*1000);

		return result;
	}

	private void loadData(Context context) {
		// get the profile list
		// extract the battery levels
		// add them in to the list

	}

	private void loadProfiles() {
		// when a battery level match comes check the status and activates
	}

	private void handleLocations(LocationInfo locationInfo, Context context) {
		if (locations != null) {
			
			for (Location loc : locations.keySet()) {
				if (loc.checkNear(locationInfo, loc.getRadius())) {
					Log.d("AutomatorService","found a location match");
					ProfilePosition pp = locations.get(loc);
					if (!pp.isInRegion()) {
						switch (pp.getFunctionality()) {
						case 1:
							pp.setInRegion(true);
							if(loc.isEntering()){
								Profile profile = DataStore.getProfileList().get(pp.getIndex());
								
								profile.activate(context);
								profile.setActivated(true);
							}
							

							break;
						case 2:

							pp.setInRegion(true);
							if(loc.isEntering()){
							Sms sms = DataStore.getsmsList().get(pp.getIndex());
							sms.sendSMS();
							sms.setSent(true);
							}

							break;
						case 3:
							if(loc.isEntering()){
							Alarm alarm = DataStore.getAlarmList().get(pp.getIndex());
							alarm.activateAlarm(context);
							alarm.setActivated(true);
							}
							pp.setInRegion(true);

							break;
						}
					}
					
				} else {

					ProfilePosition pp = locations.get(loc);
					if (pp.isInRegion()) {
						pp.setInRegion(false);
						if (!loc.isEntering()) {
							switch (pp.getFunctionality()) {
							case 1:
								Profile profile = DataStore.getProfileList().get(pp.getIndex());
								profile.activate(context);
								profile.setActivated(true);

								break;
							case 2:

								Sms sms = DataStore.getsmsList().get(pp.getIndex());
								sms.sendSMS();
								sms.setSent(true);

								break;
							case 3:

								Alarm alarm = DataStore.getAlarmList().get(pp.getIndex());
								alarm.activateAlarm(context);
								alarm.setActivated(true);

								break;

							}
						}

					}
				}
			}

		}

	}

	private BroadcastReceiver locationBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			// extract the location info in the broadcast
			final LocationInfo locationInfo = (LocationInfo) intent
					.getSerializableExtra(LocationLibraryConstants.LOCATION_BROADCAST_EXTRA_LOCATIONINFO);

			Log.d("AutomatorService","location lat=" + locationInfo.lastLat+" long="+locationInfo.lastLong);
			
			handleLocations(locationInfo, context);
		}
	};

	private BroadcastReceiver batterylevelReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
			if (status >= 0) {
				handleBatteryLevel(status, context);
			}
		}

		private void handleBatteryLevel(int status, Context context) {
			for (BatteryLevel blevel : batteryLevels.keySet()) {
				
				if (status >= blevel.getStart() && status <= blevel.getEnd()) {
					ProfilePosition pp = batteryLevels.get(blevel);
					if(!pp.isInRegion()){
						pp.setInRegion(true);
						Profile profile = DataStore.getProfileList().get(pp.getIndex());
						profile.activate(context);
						profile.setActivated(true);
					}
					
				}else{
					ProfilePosition pp = batteryLevels.get(blevel);
					pp.setInRegion(false);
				}
			}

		}
	};
	
	@Override
	public void onDestroy()
	{
		
		Toast.makeText( getApplicationContext(), "Automator Service destroyed", Toast.LENGTH_LONG ).show();
		unregisterReceiver( locationBroadcastReceiver );
		unregisterReceiver(batterylevelReceiver);
		Log.d("AutomatorService","service stopped");
	}

}
