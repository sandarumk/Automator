package com.dinu.automator;


public class SoundProfile {
	private int ring_volume;
	private boolean silent_mode;
	private boolean vibration;
	private boolean notification_vibration;
	
	public SoundProfile(int ring_volume, boolean silent_mode, boolean vibration,boolean notification_vibration){
		this.ring_volume=ring_volume;
		this.silent_mode=silent_mode;
		this.vibration=vibration;
		this.notification_vibration=notification_vibration;
	}
	
	public void activate(){
	//	AudioManager am= (AudioManager)
		
		if (ring_volume>0){
			
		}
	}
	
	
	
	

}
