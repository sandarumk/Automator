package com.dinu.automator.util;

import android.content.Context;
import android.media.AudioManager;

public class SoundSetting {
	
	// activate silent mode
	public static void activateSilentmode(Context context) {
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}

	// activate vibrate mode
	public static void activateVibrationMode(Context context) {
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
	}
	
	// set volume
	public static void setVolume(Context context,int volume){
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		am.setStreamVolume(AudioManager.STREAM_RING, volume, 1);
	}
	
	// set the ringer mode to normal
	public static void setNormal(Context context){
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		
	}
	
	public static void deactivateVibrate(Context context){
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		int volumen= am.getStreamVolume(AudioManager.STREAM_RING);
		am.setStreamVolume(AudioManager.STREAM_RING, volumen, AudioManager.FLAG_ALLOW_RINGER_MODES|AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_VIBRATE);
	}

}
