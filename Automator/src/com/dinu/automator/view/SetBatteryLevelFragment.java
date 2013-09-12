package com.dinu.automator.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dinu.automator.BatteryLevel;
import com.dinu.automator.R;

public class SetBatteryLevelFragment extends Fragment{
	private static SetBatteryLevelFragment batry;
	private BatteryLevel battryLevel;
	
public BatteryLevel getBattryLevel() {
		return battryLevel;
	}

	public void setBattryLevel(BatteryLevel battryLevel) {
		this.battryLevel = battryLevel;
	}

public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.battery_level_fragment, null);
		return view;
		
	}

public static SetBatteryLevelFragment getInstance() {
	if (batry==null){
		batry=new SetBatteryLevelFragment();
	}
	return batry;
}

public static SetBatteryLevelFragment getBatry() {
	return batry;
}

public static void setBatry(SetBatteryLevelFragment batry) {
	SetBatteryLevelFragment.batry = batry;
}

public void updateData() {
	// TODO Auto-generated method stub
	
};

}


