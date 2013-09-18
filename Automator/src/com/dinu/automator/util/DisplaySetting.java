package com.dinu.automator.util;

import android.content.Context;

public class DisplaySetting {

	// set brightness
	public static void setBrightness(Context context, int brigtness) {
		android.provider.Settings.System.putInt(context.getContentResolver(),
				android.provider.Settings.System.SCREEN_BRIGHTNESS, brigtness);

	}

	// set sleep
	public static void setSleep(Context context, int sleep) {
		android.provider.Settings.System.putInt(context.getContentResolver(),
				android.provider.Settings.System.SCREEN_OFF_TIMEOUT, sleep);

	}

	// set auto-rotation on
	public static void activateAotorotation(Context context) {
		android.provider.Settings.System.putInt(context.getContentResolver(),
				android.provider.Settings.System.ACCELEROMETER_ROTATION, 1);

	}

	//set auto-rotation off
	public static void deactivateAutoRotation(Context context) {
		android.provider.Settings.System.putInt(context.getContentResolver(),
				android.provider.Settings.System.ACCELEROMETER_ROTATION, 0);

	}

}
