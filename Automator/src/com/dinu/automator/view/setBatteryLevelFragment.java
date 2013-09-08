package com.dinu.automator.view;

import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class setBatteryLevelFragment extends Fragment{
	public static setBatteryLevelFragment newInstance() {
		setBatteryLevelFragment fragment= new setBatteryLevelFragment();
        
                return fragment;
    }
	
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.battery_level_fragment, null);
		return view;
		
	};

}


