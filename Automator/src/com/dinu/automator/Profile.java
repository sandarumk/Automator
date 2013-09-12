package com.dinu.automator;


import java.io.Serializable;





public class Profile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private SoundProfile sounds;
	private DisplayProfile display;
	private NetworkProfile network;
	private Location locations;
	private BatteryLevel batteryLevel;
	boolean enable;
	

	
	public Profile(){
		sounds=new SoundProfile(0,false,false);
		//display= new DisplayProfile(0, autoRotation, sleep, pulse_notification_light)
		enable=true;
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
		if(sounds==null){
			sounds=new SoundProfile(0,false,false);
		}
		return sounds;
	}

	public void setSounds(SoundProfile sounds) {
		this.sounds = sounds;
	}

	public DisplayProfile getDisplay() {
		return display;
	}

	public void setDisplay(DisplayProfile display) {
		this.display = display;
	}

	public NetworkProfile getNetwork() {
		return network;
	}

	public void setNetwork(NetworkProfile network) {
		this.network = network;
	}

	public Location getLocations() {
		return locations;
	}

	public void setLocations(Location locations) {
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
