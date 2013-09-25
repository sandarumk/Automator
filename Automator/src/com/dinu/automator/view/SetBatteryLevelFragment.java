package com.dinu.automator.view;

import android.app.Activity;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dinu.automator.BatteryLevel;
import com.dinu.automator.R;
import com.dinu.automator.RangeSeekBar;
import com.dinu.automator.RangeSeekBar.OnRangeSeekBarChangeListener;
import com.dinu.automator.activity.ProfileSettingsActivity;

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
	
		RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(20, 75, getActivity());
		seekBar.setOnRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener<Integer>() {
		        @Override
		        public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
		                // handle changed range values
		                
		        }
		});
		ViewGroup layout = (ViewGroup)view.findViewById(R.id.linearlayout_battery_level_fragment);
		layout.addView(seekBar);
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


