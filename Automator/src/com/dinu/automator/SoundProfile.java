package com.dinu.automator;

import java.io.Serializable;

import android.content.Context;

import com.dinu.automator.util.SoundSetting;

public class SoundProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	private IntSetting ringVolume;
	private BooleanSetting silentMode;
	private BooleanSetting vibration;

	
	public SoundProfile(int ringVolume, boolean volumeEnable, boolean silentMode,boolean silentEnable, boolean vibration,boolean vibrationEnable ) {
		this.ringVolume=new IntSetting(ringVolume, volumeEnable);
		this.silentMode=new BooleanSetting(silentMode, silentEnable);
		this.vibration=new BooleanSetting(vibration, vibrationEnable);

				}

	public void activate(Context context) {
		if(ringVolume.isEnable()){
			SoundSetting.setVolume(context, ringVolume.getSetting());
		}
		if(silentMode.isEnable()){
			if(silentMode.getBooleanSetting()){
			SoundSetting.activateSilentmode(context);
			}else{
				SoundSetting.setNormal(context);
			}
		}
		if(vibration.isEnable()){
			if(vibration.getBooleanSetting()){
				SoundSetting.activateVibrationMode(context);
			}else{
				SoundSetting.deactivateVibrate(context);
			}
		}

	}

	public IntSetting getRingVolume() {
		return ringVolume;
	}

	public void setRingVolume(int ringVolume,boolean enable) {
		this.ringVolume.setSetting(ringVolume);
		this.ringVolume.setEnable(enable);
	}

	public BooleanSetting getSilentMode() {
		return silentMode;
	}

	public void setSilentMode(boolean silentMode, boolean enable) {
		this.silentMode.setBooleanSetting(silentMode);
		this.silentMode.setEnable(enable);
	}

	public BooleanSetting getVibration() {
		return vibration;
	}

	public void setVibration(boolean vibration, boolean enable) {
		this.vibration.setBooleanSetting(vibration);
		this.vibration.setEnable(enable);
	}
}
