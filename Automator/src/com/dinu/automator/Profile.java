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
}
