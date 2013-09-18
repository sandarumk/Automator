package com.dinu.automator;

import java.io.Serializable;

import com.dinu.automator.util.DisplaySetting;

public class DisplayProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	private int brightness;
	private boolean autoRotation;
	private int sleep;
	private boolean pulse_notification_light;

	public DisplayProfile(int brightness, boolean autoRotation, int sleep, boolean pulse_notification_light) {
		this.brightness = brightness;
		this.autoRotation = autoRotation;
		this.sleep = sleep;
		this.pulse_notification_light = pulse_notification_light;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public boolean isAutoRotation() {
		return autoRotation;
	}

	public void setAutoRotation(boolean autoRotation) {
		this.autoRotation = autoRotation;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	public boolean isPulse_notification_light() {
		return pulse_notification_light;
	}

	public void setPulse_notification_light(boolean pulse_notification_light) {
		this.pulse_notification_light = pulse_notification_light;
	}

	public void activate() {

	}

}
