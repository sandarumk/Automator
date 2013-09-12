package com.dinu.automator.view;

import com.dinu.automator.NetworkProfile;
import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NetworkSettingFragment extends Fragment {
	
	private NetworkProfile network;
	private static NetworkSettingFragment networkFragment;
	
	public NetworkProfile getNetwork() {
		return network;
	}

	public void setNetwork(NetworkProfile network) {
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


