package com.dinu.automator;


import android.content.Context;
import android.media.AudioManager;


public class SoundProfile {
	private int ring_volume;
	private boolean silent_mode;
	private boolean vibration;
	private boolean notification_vibration;
	private AudioManager audioM;
	
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
	public void setRingingVolume(int volume){
		//audioM=(AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
		audioM.setStreamVolume(AudioManager.STREAM_RING, volume, 1);
	}
	
	public void setSilentMode(boolean silent){
		if (silent ==true){
			silent_mode=true;
			audioM.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			
		}else{
			silent_mode=false;
			audioM.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		}
	}
	
	public void setVibrationMode(boolean vibrationOn){
		if (vibrationOn ==true){
			vibration=true;
			audioM.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		}else{
			vibration=false;
			//audioM.setRingerMode(AudioManager.r);
			// code for turning off vibration
		}
	}
	
	public void setNotification(boolean nvibration){
		if (nvibration ==true){
			notification_vibration=true;
		}else
			notification_vibration=false;
		}
	}
	
	
	
	

