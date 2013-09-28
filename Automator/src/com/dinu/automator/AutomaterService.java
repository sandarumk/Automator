package com.dinu.automator;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibraryConstants;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class AutomaterService extends Service{
	

	private Map<BatteryLevel, Integer> batteryLevels;  // map of enabled battery levels and profile index
	private Map<Location, ProfilePosition> locations; // value = "1,2" -> profile,index=2

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		batteryLevels = new HashMap<BatteryLevel, Integer>();
		locations= new HashMap<Location, ProfilePosition>();
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
	    IntentFilter lftIntentFilter = new IntentFilter( LocationLibraryConstants.getLocationChangedPeriodicBroadcastAction() );
		registerReceiver( locationBroadcastReceiver, lftIntentFilter );
		IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryStatus = getApplication().registerReceiver(null, ifilter);
		DataStore.retrieveData(getApplication());
		List<Profile> profileList=new ArrayList<Profile>();
		profileList=DataStore.getProfileList();
		for(Profile profile:profileList){
			if(profile.getBatteryLevel().isEnable()){
				batteryLevels.put(profile.getBatteryLevel(), profileList.indexOf(profile));
			}
			if(profile.getLocations(getApplication()).isEnable()){
				locations.put(profile.getLocations(getApplication()), new ProfilePosition(1, profileList.indexOf(profile)));
			}
			
		}
		// remove the lists
		
		
		
	    
	    
	    return super.onStartCommand(intent,flags,startId);
	}
	
	private void loadData(Context context){
		// get the profile list 
		//extract the battery levels
		//add them in to the list
		
	}
	
	private void loadProfiles(){
		// when a battery level match comes check the status and activates
	}
	
	private void handleBatteryLevel(){
		// get the global battery level
		// iterate it through the list of battery levels 
		// if it is between a range
		// activate the given profile
		// if its not deactivates the profile
	}
	
	private void handleLocations(LocationInfo locationInfo){
		if(locations!=null){
			// take every location if entering check whether it is in then activate and remove it from the list
		
		}
		
	}
	
	private BroadcastReceiver locationBroadcastReceiver = new BroadcastReceiver()
	{
		@Override
		public void onReceive( Context context, Intent intent )
		{
			// extract the location info in the broadcast
			final LocationInfo locationInfo = ( LocationInfo ) intent.getSerializableExtra( LocationLibraryConstants.LOCATION_BROADCAST_EXTRA_LOCATIONINFO );

			handleLocations( locationInfo );
		}
	};

}
