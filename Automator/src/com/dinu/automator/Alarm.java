package com.dinu.automator;

import java.io.Serializable;

public class Alarm implements Serializable {
	
	
	

	private static final long serialVersionUID = 1L;
	private String name;
	private boolean enabled;
	private String label;
	private Location location;
	
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

}
