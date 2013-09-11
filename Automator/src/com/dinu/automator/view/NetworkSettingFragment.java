package com.dinu.automator.view;

import com.dinu.automator.NetworkSettings;
import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NetworkSettingFragment extends Fragment {
	
	private NetworkSettings network;
	private static NetworkSettingFragment networkFragment;
	
	public NetworkSettings getNetwork() {
		return network;
	}

	public void setNetwork(NetworkSettings network) {
		this.network = network;
	}
	
	public static NetworkSettingFragment getInstance() {
		if (networkFragment == null) {
			networkFragment=new NetworkSettingFragment();
		}
		return networkFragment;
	}


	
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.network_settings_fragment, null);
		return view;
		
	}

public void updateData() {
	// TODO Auto-generated method stub
	
};

}


