package com.dinu.automator.view;

import com.dinu.automator.R;
import com.dinu.automator.activity.LocatorActivity;
import com.dinu.automator.activity.ProfileSettingsActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HeterogeneousExpandableList;

public class LocationFragment extends Fragment {
	Button setLocationMap;
	private static LocationFragment locationFragment;

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("DO NOT CRASH", "OK");
	}

	public static LocationFragment getInstance() {
		if (locationFragment == null) {
			locationFragment = new LocationFragment();
		}
		return locationFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.location_fragment, null);
		setLocationMap = (Button) view.findViewById(R.id.button_setLocation_onMap);
		setLocationMap.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Activity activity = getActivity();
				if (activity != null) {
					startActivity(new Intent(activity, LocatorActivity.class));
				}

			}
		});

		// getActivity().getIntent().getIntExtra(name, defaultValue);
		// view.findViewById(id);

		return view;
	}

	public void updateData() {
		// TODO Auto-generated method stub
		
	}

}
