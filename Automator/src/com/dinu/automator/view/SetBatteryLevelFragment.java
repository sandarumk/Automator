package com.dinu.automator.view;

import com.dinu.automator.BatteryLevel;
import com.dinu.automator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SetBatteryLevelFragment extends Fragment{
	private static SetBatteryLevelFragment batry;
	public static SetBatteryLevelFragment newInstance() {
		SetBatteryLevelFragment fragment= new SetBatteryLevelFragment();
        
                return fragment;
    }
	
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.battery_level_fragment, null);
		return view;
		
	}

public static SetBatteryLevelFragment getInstance() {
	if (batry==null){
		batry=new SetBatteryLevelFragment();
	}
	// TODO Auto-generated method stub
	return batry;
}

public void updateData() {
	// TODO Auto-generated method stub
	
};

}


