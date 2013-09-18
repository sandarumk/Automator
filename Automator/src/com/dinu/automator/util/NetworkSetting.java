package com.dinu.automator.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;

public class NetworkSetting {

	//activate wifi
	public static void OnWifi(Context context) {
		WifiManager wifi;
		wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		wifi.setWifiEnabled(true);
	}

	// deactivate wifi
	public static void offWifi(Context context) {
		WifiManager wifi;
		wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		wifi.setWifiEnabled(false);
	}

	// activate bluetooth
	public static void OnBlueTooth(Context context) {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (bluetoothAdapter.isEnabled()) {
			bluetoothAdapter.disable();
		}

	}

	// deactivate bluetooth
	public static void offBlueTooth() {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (bluetoothAdapter.isEnabled()) {
			bluetoothAdapter.disable();
		}

	}

}
