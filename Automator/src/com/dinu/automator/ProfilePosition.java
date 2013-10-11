package com.dinu.automator;

public class ProfilePosition {
	private int functionality;
	private int index;
	private boolean inRegion;
	
	
	
	public ProfilePosition(int functionality, int index) {
		
		this.functionality = functionality;
		this.index = index;
		this.inRegion=false;
	}
	public int getFunctionality() {
		return functionality;
	}
	public void setFunctionality(int functionality) {
		this.functionality = functionality;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public boolean isInRegion() {
		return inRegion;
	}
	public void setInRegion(boolean inRegion) {
		this.inRegion = inRegion;
	}
	
	// functionality = 1: profiles
	//functionality= 2; sms
	// functionality=3; alarms
	
	

}
