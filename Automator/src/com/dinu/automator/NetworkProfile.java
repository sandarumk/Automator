package com.dinu.automator;

import java.io.Serializable;

public class NetworkProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean wifi;
	private boolean bluetooth;

	public NetworkProfile(boolean wifi, boolean bluetooth) {

		this.wifi = wifi;
		this.bluetooth = bluetooth;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}

	public void activate() {

	}
}
