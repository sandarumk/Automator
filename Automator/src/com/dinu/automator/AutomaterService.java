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

	private static final String TAG = "AutomatorService";
	private Map<BatteryLevel, ProfilePosition> batteryLevels; // map of enabled
																// battery
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
		Log.d(TAG, "service started");
		int result = super.onStartCommand(intent, flags, startId);
		Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
		IntentFilter lftIntentFilter = new IntentFilter(
				LocationLibraryConstants.getLocationChangedPeriodicBroadcastAction());
		registerReceiver(locationBroadcastReceiver, lftIntentFilter);
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(batterylevelReceiver, ifilter);
		DataStore.retrieveData(getApplicationContext());
		List<Profile> profileList = new ArrayList<Profile>();
		profileList = DataStore.getProfileList();
		for (Profile profile : profileList) {
			if (profile.getBatteryLevel().isEnable() && profile.isEnable()) {
				batteryLevels.put(profile.getBatteryLevel(), new ProfilePosition(1, profileList.indexOf(profile)));
			}
			if (profile.getLocations(getApplicationContext()).isEnable() && profile.isEnable()) {
				locations.put(profile.getLocations(getApplicationContext()),
						new ProfilePosition(1, profileList.indexOf(profile)));
			}

		}
		profileList = null;
		List<Alarm> alarmList = new ArrayList<Alarm>();
		alarmList = DataStore.getAlarmList();
		for (Alarm alarm : alarmList) {
			if (alarm.isEnabled()) {
				locations.put(alarm.getLocation(), new ProfilePosition(3, alarmList.indexOf(alarm)));
			}

		}
		alarmList = null;
		List<Sms> smsList = new ArrayList<Sms>();
		smsList = DataStore.getsmsList();
		for (Sms sms : smsList) {
			if (sms.isEnabled()) {
				locations.put(sms.getLocation(), new ProfilePosition(3, smsList.indexOf(sms)));
			}

		}
		smsList = null;
		final ArrayList<LocationInfo> checklist = new ArrayList<LocationInfo>();
		LocationInfo gampaha = new LocationInfo(getApplicationContext());
		gampaha.lastLat = 7.09f;
		gampaha.lastLong = 79.99f;
		checklist.add(gampaha);
		LocationInfo ganemulla = new LocationInfo(getApplicationContext());
		ganemulla.lastLat = 7.06f;
		ganemulla.lastLong = 79.96f;
		checklist.add(ganemulla);
		LocationInfo ragama = new LocationInfo(getApplicationContext());
		ragama.lastLat = 7.02f;
		ragama.lastLong = 79.93f;
		checklist.add(ragama);
		LocationInfo kelaniya = new LocationInfo(getApplicationContext());
		kelaniya.lastLat = 6.95f;
		kelaniya.lastLong = 79.92f;
		checklist.add(kelaniya);
		LocationInfo dematagoda = new LocationInfo(getApplicationContext());
		dematagoda.lastLat = 6.92f;
		dematagoda.lastLong = 79.88f;
		checklist.add(dematagoda);
		LocationInfo maradana = new LocationInfo(getApplicationContext());
		maradana.lastLat = 6.92f;
		maradana.lastLong = 79.86f;
		checklist.add(maradana);
		LocationInfo colombo = new LocationInfo(getApplicationContext());
		colombo.lastLat = 6.93f;
		colombo.lastLong = 79.84f;
		checklist.add(colombo);
		LocationInfo slaveIsland = new LocationInfo(getApplicationContext());
		slaveIsland.lastLat = 6.92f;
		slaveIsland.lastLong = 79.85f;
		checklist.add(slaveIsland);
		LocationInfo kollupitiya = new LocationInfo(getApplicationContext());
		kollupitiya.lastLat = 6.91f;
		kollupitiya.lastLong = 79.85f;
		checklist.add(kollupitiya);
		LocationInfo bambalapitiya = new LocationInfo(getApplicationContext());
		bambalapitiya.lastLat = 6.90f;
		bambalapitiya.lastLong = 79.85f;
		checklist.add(bambalapitiya);
		LocationInfo dehiwala = new LocationInfo(getApplicationContext());
		dehiwala.lastLat = 6.84f;
		dehiwala.lastLong = 79.87f;
		checklist.add(dehiwala);
		LocationInfo ratmalana = new LocationInfo(getApplicationContext());
		ratmalana.lastLat = 6.82f;
		ratmalana.lastLong = 79.88f;
		checklist.add(ratmalana);
		LocationInfo moratuwa = new LocationInfo(getApplicationContext());
		moratuwa.lastLat = 6.79f;
		moratuwa.lastLong = 79.87f;
		checklist.add(moratuwa);
		final MutableInteger index = new MutableInteger(0);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// LocationInfo loc = checklist.get(index.getValue());
				// Log.d("Automator Service", "location reached  lat=" +
				// loc.lastLat + " long=" + loc.lastLong);
				// ''handleLocations(loc, getApplication());
				// if (index.getValue() == checklist.size() - 1) {
				// index.setValue(0);
				// } else {
				// index.setValue(index.getValue() + 1);
				// }
			}

		}, 20 * 1000, 20 * 1000);

		return result;
	}

	private void handleLocations(LocationInfo locationInfo, Context context) {
		// Log.d("Automator service", "handle location called");
		if (locations != null) {
			// Log.d("Automator service", "location not null");
			for (Location loc : locations.keySet()) {
				// Log.d("Automator service", "in for loop");
				if (loc.checkNear(locationInfo, loc.getRadius())) {
					Log.d(TAG, "found a location match");
					ProfilePosition pp = locations.get(loc);
					if (!pp.isInRegion()) {
						switch (pp.getFunctionality()) {
						case 1:
							pp.setInRegion(true);
							if (loc.isEntering()) {
								Profile profile = DataStore.getProfileList().get(pp.getIndex());

								profile.activate(context);
								profile.setActivated(true);
							}

							break;
						case 2:

							pp.setInRegion(true);
							if (loc.isEntering()) {
								Log.d("sms service", "send sms");
								Sms sms = DataStore.getsmsList().get(pp.getIndex());
								sms.sendSMS();
								sms.setSent(true);
							}

							break;
						case 3:
							if (loc.isEntering()) {
								Log.d("alarm service", "activate alarm");
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

			Log.d(TAG, "location lat=" + locationInfo.lastLat + " long=" + locationInfo.lastLong);

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
					if (!pp.isInRegion()) {
						pp.setInRegion(true);
						Profile profile = DataStore.getProfileList().get(pp.getIndex());
						profile.activate(context);
						profile.setActivated(true);
					}

				} else {
					ProfilePosition pp = batteryLevels.get(blevel);
					pp.setInRegion(false);
				}
			}

		}
	};

	@Override
	public void onDestroy() {

		Toast.makeText(getApplicationContext(), "Automator Service destroyed", Toast.LENGTH_LONG).show();
		unregisterReceiver(locationBroadcastReceiver);
		unregisterReceiver(batterylevelReceiver);
		Log.d(TAG, "service stopped");
	}

}

class MutableInteger {
	private int value;

	public MutableInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
