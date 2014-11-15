package com.dinu.automator.view;

import com.dinu.automator.NetworkProfile;
import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
		ToggleButton switchWifi = (ToggleButton) view.findViewById(R.id.toggle_button_wifi);
		switchWifi.setChecked(false);
		CheckBox chkwifi = (CheckBox) view.findViewById(R.id.checkBox_wifi_enable);
		chkwifi.setChecked(false);
		ToggleButton switchBluetooth = (ToggleButton) view.findViewById(R.id.toggle_button_bluetooth);
		switchBluetooth.setChecked(false);
		CheckBox chkbluetooth = (CheckBox) view.findViewById(R.id.checkBox_bluetooth_enable);
		chkbluetooth.setChecked(false);

		if (network != null) {

			switchWifi.setChecked(network.getWifi().getBooleanSetting());
			chkwifi.setChecked(network.getWifi().isEnable());

			switchBluetooth.setChecked(network.getBluetooth().getBooleanSetting());

			chkbluetooth.setChecked(network.getBluetooth().isEnable());

		}
		return view;

	}

	public void updateData() {
		if (view != null && network != null) {
			ToggleButton switchWifi = (ToggleButton) view.findViewById(R.id.toggle_button_wifi);
			CheckBox chkwifi = (CheckBox) view.findViewById(R.id.checkBox_wifi_enable);

			network.setWifi(switchWifi.isChecked(), chkwifi.isChecked());

			ToggleButton switchBluetooth = (ToggleButton) view.findViewById(R.id.toggle_button_bluetooth);
			CheckBox chkbluetooth = (CheckBox) view.findViewById(R.id.checkBox_bluetooth_enable);
			network.setBluetooth(switchBluetooth.isChecked(), chkbluetooth.isChecked());

		}

	};

}
