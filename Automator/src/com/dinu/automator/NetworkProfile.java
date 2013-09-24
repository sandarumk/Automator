package com.dinu.automator;

import java.io.Serializable;

public class NetworkProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	private BooleanSetting wifi;
	private BooleanSetting bluetooth;

	public NetworkProfile(boolean wifi, boolean wifiEnable,boolean bluetooth, boolean bluetoothEnable) {

		this.wifi = new BooleanSetting(wifi, wifiEnable);
		this.bluetooth = new BooleanSetting(bluetooth, bluetoothEnable);
	}

	public BooleanSetting getWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi,boolean enabled) {
		this.wifi.setBooleanSetting(wifi);
		this.wifi.setEnable(enabled);
	}

	public BooleanSetting getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth, boolean enable) {
		this.bluetooth.setBooleanSetting(bluetooth);
		this.bluetooth.setEnable(enable);
	}

	public void activate() {

	}
}
