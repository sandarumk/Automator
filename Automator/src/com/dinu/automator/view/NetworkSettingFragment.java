package com.dinu.automator.view;

import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NetworkSettingFragment extends Fragment {
	public static NetworkSettingFragment newInstance() {
		NetworkSettingFragment fragment= new NetworkSettingFragment();
        
                return fragment;
    }
	
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.network_settings_fragment, null);
		return view;
		
	};

}


