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
import android.widget.TextView;
import android.widget.ToggleButton;

import com.dinu.automator.BatteryLevel;
import com.dinu.automator.R;
import com.dinu.automator.RangeSeekBar;
import com.dinu.automator.RangeSeekBar.OnRangeSeekBarChangeListener;
import com.dinu.automator.activity.ProfileSettingsActivity;

public class SetBatteryLevelFragment extends Fragment{
	private static SetBatteryLevelFragment batry;
	private BatteryLevel battryLevel;
	private View view;
	private int start;
	private int end;
	


public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		view = inflater.inflate(R.layout.battery_level_fragment, null);
		final TextView txtStart=(TextView)view.findViewById(R.id.textView_battery_range_start);
		txtStart.setText(null);
		final TextView txtEnd=(TextView)view.findViewById(R.id.textView_battery_range_end);
		txtEnd.setText(null);
		ToggleButton enableBattery=(ToggleButton)view.findViewById(R.id.toggle_button_enable_battery);
		enableBattery.setChecked(false);
		RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(0, 100, getActivity());
		seekBar.setSelectedMaxValue(100);
		seekBar.setSelectedMinValue(0);
		
		if(battryLevel!=null){
			enableBattery.setChecked(battryLevel.isEnable());
			txtStart.setText(battryLevel.getStart()+"%");
			start=battryLevel.getStart();
			txtEnd.setText(battryLevel.getEnd()+"%");
			end=battryLevel.getEnd();
			seekBar.setSelectedMinValue(battryLevel.getStart());
			seekBar.setSelectedMaxValue(battryLevel.getEnd());
		}
		
		seekBar.setOnRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener<Integer>() {
		        @Override
		        public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
		                txtStart.setText(minValue+"%");
		                start=minValue;
		                txtEnd.setText(maxValue+"%");
		                end=maxValue;
		                
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
	if(view!=null && battryLevel!=null){
	ToggleButton enableBattery=(ToggleButton)view.findViewById(R.id.toggle_button_enable_battery);
	battryLevel.setEnable(enableBattery.isChecked());
	battryLevel.setStart(start);
	battryLevel.setEnd(end);
	
	
	
	}
	
}
public BatteryLevel getBattryLevel() {
	return battryLevel;
}

public void setBattryLevel(BatteryLevel battryLevel) {
	this.battryLevel = battryLevel;
}


}


