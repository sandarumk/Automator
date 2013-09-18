package com.dinu.automator;

import java.io.Serializable;

public class SoundProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ringVolume;
	private boolean silentMode;
	private boolean vibration;

	
	public SoundProfile(int ring_volume, boolean silent_mode, boolean vibration) {
		this.ringVolume = ring_volume;
		this.silentMode = silent_mode;
		this.vibration = vibration;
		}

	public void activate() {

	}

	public int getRingVolume() {
		return ringVolume;
	}

	public void setRingVolume(int ringVolume) {
		this.ringVolume = ringVolume;
	}

	public boolean isSilentMode() {
		return silentMode;
	}

	public void setSilentMode(boolean silentMode) {
		this.silentMode = silentMode;
	}

	public boolean isVibration() {
		return vibration;
	}

	public void setVibration(boolean vibration) {
		this.vibration = vibration;
	}
}
