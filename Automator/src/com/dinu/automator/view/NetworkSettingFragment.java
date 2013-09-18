package com.dinu.automator.view;

import com.dinu.automator.NetworkProfile;
import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

public class NetworkSettingFragment extends Fragment {

	private NetworkProfile network;
	private static NetworkSettingFragment networkFragment;
	private View view;

	public NetworkProfile getNetwork() {
		return network;
	}

	public void setNetwork(NetworkProfile network) {
		this.network = network;
	}

	public static NetworkSettingFragment getInstance() {
		if (networkFragment == null) {
			networkFragment = new NetworkSettingFragment();
		}
		return networkFragment;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.network_settings_fragment, null);
		if(network!=null){
			ToggleButton switchWifi= (ToggleButton) view.findViewById(R.id.toggle_button_wifi);
			switchWifi.setChecked(network.isWifi());
			ToggleButton switchBluetooth= (ToggleButton) view.findViewById(R.id.toggle_button_bluetooth);
			switchBluetooth.setChecked(network.isBluetooth());
			
		}
		return view;

	}

	public void updateData() {
		if(view!=null && network!=null ){
			ToggleButton switchWifi= (ToggleButton) view.findViewById(R.id.toggle_button_wifi);
			boolean wifi=switchWifi.isChecked();
			network.setWifi(wifi);
			
			ToggleButton switchBluetooth= (ToggleButton) view.findViewById(R.id.toggle_button_bluetooth);
			boolean bluetooth= switchBluetooth.isChecked();
			network.setBluetooth(bluetooth);
			
		}

	};

}
