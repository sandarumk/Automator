package com.dinu.automator;


import java.io.Serializable;

import android.content.Context;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;

public class Profile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private SoundProfile sounds;
	private DisplayProfile display;
	private NetworkProfile network;
	private Location location;
	private BatteryLevel batteryLevel;
	boolean enable;
	private boolean activated;
	

	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Profile(Context context){
		sounds=new SoundProfile(0,false,false,false,false,false);
		display= new DisplayProfile(0, false,false, false,30, false,false,false);
		location=new Location(Constant.INITIAL_LONGITUDE,Constant.INITIAL_LATTITUDE);
		network= new NetworkProfile(false, false,false, false);
		batteryLevel=new BatteryLevel(0,100);
		
//		LocationInfo latestInfo = new LocationInfo(context);
//		latestInfo.refresh(context);
//		Double lattitude = (double)latestInfo.lastLat;
//		Double longitude = (double) latestInfo.lastLong;
//		location= new Location(longitude, lattitude);
		
		enable=true;
	}

	public void activate(Context context){
		sounds.activate(context);
		display.activate(context);
		network.activate(context);
	}
	
	public void enable(){
		this.enable=true;
	}
	
	public void disable() {
		this.enable=false;
	}

	
	
	
	public void delete(){
		DataStore.deleteProfile(this);
		
	}
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SoundProfile getSounds() {
		if(sounds==null){
			sounds=new SoundProfile(0,false,false,false, false, false);
		}
		return sounds;
	}

	public void setSounds(SoundProfile sounds) {
		this.sounds = sounds;
	}

	public DisplayProfile getDisplay() {
		if(display==null){
			display=new DisplayProfile(0,false,false,false, 30,false,false, false);
		}
		return display;
	}

	public void setDisplay(DisplayProfile display) {
		this.display = display;
	}

	public NetworkProfile getNetwork() {
		if(network==null){
			network=new NetworkProfile(false, false,false,false);
		}
		return network;
	}

	public void setNetwork(NetworkProfile network) {
		this.network = network;
	}

	public Location getLocations(Context context) {
		if (location==null){
			location=new Location(Constant.INITIAL_LONGITUDE,Constant.INITIAL_LATTITUDE);
//			LocationInfo latestInfo = new LocationInfo(context);
//			Double lattitude = (double)latestInfo.lastLat;
//			Double longitude = (double) latestInfo.lastLong;
//			location= new Location(longitude, lattitude);
		}
		return location;
	}

	public void setLocations(Location locations) {
		this.location = locations;
	}

	public BatteryLevel getBatteryLevel() {
		if(batteryLevel==null){
			batteryLevel=new BatteryLevel(0, 100);
		}
		return batteryLevel;
	}

	public void setBatteryLevel(BatteryLevel batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
