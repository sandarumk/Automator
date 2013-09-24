package com.dinu.automator;

import java.io.Serializable;

import com.dinu.automator.util.DisplaySetting;

public class DisplayProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	private IntSetting brightness;
	private BooleanSetting autoRotation;
	private IntSetting sleep;
	private BooleanSetting pulseNotificationLight;

	public DisplayProfile(int brightness,boolean brightnessEnable, boolean autoRotation, boolean autorotationEnable, int sleep,boolean sleepEnable, boolean pulseNotificationLight, boolean pulseEnable) {
		
		this.brightness=new IntSetting(brightness, brightnessEnable);
		this.autoRotation=new BooleanSetting(autoRotation, autorotationEnable);
		this.sleep=new IntSetting(sleep, sleepEnable);
		this.pulseNotificationLight=new BooleanSetting(pulseNotificationLight, pulseEnable);
		
		

		
	}

	public IntSetting getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness, boolean enable) {
		this.brightness.setSetting(brightness);
		this.brightness.setEnable(enable);
	}

	public BooleanSetting isAutoRotation() {
		return autoRotation;
	}

	public void setAutoRotation(boolean autoRotation, boolean enable) {
		this.autoRotation.setBooleanSetting(autoRotation);
		this.autoRotation.setEnable(enable);
	}

	public IntSetting getSleep() {
		return sleep;
	}

	public void setSleep(int sleep, boolean enable) {
		this.sleep.setSetting(sleep); 
		this.sleep.setEnable(enable);
	}

	public BooleanSetting isPulseNotificationLight() {
		return pulseNotificationLight;
	}

	public void setPulse_notification_light(boolean pulseNotification, boolean enable) {
		this.pulseNotificationLight.setBooleanSetting(pulseNotification); 
		this.pulseNotificationLight.setEnable(enable);
	}

	public void activate() {

	}

}
