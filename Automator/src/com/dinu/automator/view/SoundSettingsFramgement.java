package com.dinu.automator.view;

import com.dinu.automator.R;

import com.dinu.automator.SoundProfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class SoundSettingsFramgement extends Fragment {
	SoundProfile sound;

	private static SoundSettingsFramgement soundSettings;

	public static SoundSettingsFramgement getInstance() {
		if (soundSettings == null) {
			soundSettings = new SoundSettingsFramgement();
		}
		return soundSettings;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.sound_setting_fragment, null);

		/*
		 * saving in sound object SeekBar seek=(SeekBar)
		 * view.findViewById(R.id.seekBar_volume); int
		 * volume=seek.getProgress(); sound.setRingingVolume(volume);
		 * 
		 * CheckBox chkSilent= (CheckBox)view.findViewById(R.id.check_silent);
		 * boolean silent = chkSilent.isChecked(); sound.setSilentMode(silent);
		 * 
		 * 
		 * CheckBox chkVibration=
		 * (CheckBox)view.findViewById(R.id.checkBox_vibration); boolean
		 * vibration = chkVibration.isChecked();
		 * sound.setVibrationMode(vibration);
		 */

		return view;

	}

	private SoundSettingsFramgement() {
		super();

	};

}
