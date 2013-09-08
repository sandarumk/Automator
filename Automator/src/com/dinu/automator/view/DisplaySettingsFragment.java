package com.dinu.automator.view;

import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DisplaySettingsFragment extends Fragment{

	private static DisplaySettingsFragment displaySettings;

	public static DisplaySettingsFragment getInstance() {
		if (displaySettings == null) {
			displaySettings = new DisplaySettingsFragment();
		}
		return displaySettings;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.display_settings_fragment, null);
		return view;

	};

}


