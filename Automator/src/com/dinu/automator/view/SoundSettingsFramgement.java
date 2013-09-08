package com.dinu.automator.view;

import com.dinu.automator.R;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SoundSettingsFramgement extends Fragment {
	
	private static SoundSettingsFramgement soundSettings;

	public static SoundSettingsFramgement getInstance() {
		if (soundSettings == null) {
			soundSettings = new SoundSettingsFramgement();
		}
		return soundSettings;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.sound_setting_fragment, null);
		return view;

	};

}
