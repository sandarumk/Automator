package com.dinu.automator;


import java.util.Iterator;
import java.util.List;





public class Profile {
	int id;
	String name;
	SoundProfile sounds;
	DisplaySettings display;
	NetworkSettings network;
	Location[] locations;
	BatteryLevel batteryLevel;
	boolean enable;
	
	public Profile(int i, String stringName) {
		id=i;
		name=stringName;
		// TODO Auto-generated constructor stub
	}
	
	public Profile(){
		
	}

	public void activate(){
		sounds.activate();
		display.activate();
		network.activate();
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
		return sounds;
	}

	public void setSounds(SoundProfile sounds) {
		this.sounds = sounds;
	}

	public DisplaySettings getDisplay() {
		return display;
	}

	public void setDisplay(DisplaySettings display) {
		this.display = display;
	}

	public NetworkSettings getNetwork() {
		return network;
	}

	public void setNetwork(NetworkSettings network) {
		this.network = network;
	}

	public Location[] getLocations() {
		return locations;
	}

	public void setLocations(Location[] locations) {
		this.locations = locations;
	}

	public BatteryLevel getBatteryLevel() {
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
