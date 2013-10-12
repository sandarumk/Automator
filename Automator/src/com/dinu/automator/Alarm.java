package com.dinu.automator;

import java.io.Serializable;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;




public class Alarm implements Serializable {
	
	
	

	private static final long serialVersionUID = 1L;
	private String name;
	private boolean enabled;
	private String label;
	private Location location;
	private boolean activated;
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Alarm(){
		location=new Location(Constant.INITIAL_LONGITUDE,Constant.INITIAL_LATTITUDE);
		enabled = true;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void activateAlarm(Context context){
		Log.d("alarm service", "notification method");
		
		/*NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
		        .setSmallIcon(R.drawable.ic_stat_alarm)
		        .setContentTitle("Automator Notification"+label)
		        .setContentText("Location "+location.getName()+" Reached");
		NotificationManager mNotificationManager =
			    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		mBuilder.setAutoCancel(true);
		mNotificationManager.notify(0, mBuilder.build());*/
		
		

		// build notification
		// the addAction re-use the same intent to keep the example short
		Notification n  = new Notification.Builder(context)
		        .setContentTitle("Automator Notification"+label)
		        .setContentText("Location "+location.getName()+" Reached")
		        .setSmallIcon(R.drawable.ic_stat_alarm)
		       
		        
		        .setAutoCancel(true)
		        .build();
		    
		  
		NotificationManager notificationManager = 
		  (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		notificationManager.notify(0, n); 
		
		
		//AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
		//ring the alarm
	}

}
