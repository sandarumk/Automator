package com.dinu.automator.util;

import android.content.Context;
import android.media.AudioManager;

public class SoundSetting {
	
	public static void activateSilentmode(Context context) {
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}

	public static void activateVibrationMode(Context context) {
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}

}
