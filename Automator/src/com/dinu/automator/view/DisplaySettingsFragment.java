package com.dinu.automator.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dinu.automator.DisplayProfile;
import com.dinu.automator.R;
import com.dinu.automator.view.SleepDialogFragment.SleepDialogListener;

public class DisplaySettingsFragment extends Fragment implements SleepDialogListener {
	private DisplayProfile display;
	private int sleepTime;

	public DisplayProfile getDisplay() {
		return display;
	}

	public void setDisplay(DisplayProfile display) {
		this.display = display;
	}

	private static DisplaySettingsFragment displaySettings;
	private View view;

	public static DisplaySettingsFragment getInstance() {
		if (displaySettings == null) {
			displaySettings = new DisplaySettingsFragment();
		}
		return displaySettings;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.display_settings_fragment, null);
		if (display != null) {
			SeekBar seek = (SeekBar) view.findViewById(R.id.seekBar_brightness);
			seek.setProgress(display.getBrightness());

			CheckBox chkAutoRotation = (CheckBox) view.findViewById(R.id.checkBox_autorotation);
			chkAutoRotation.setChecked(display.isAutoRotation());
		

			CheckBox chkpulseNot = (CheckBox) view.findViewById(R.id.check_pulse_notification);
			chkpulseNot.setChecked(display.isPulse_notification_light());

			sleepTime=display.getSleep();
			TextView textvwTime = (TextView) view.findViewById(R.id.textView_sleep_time);
			int arrayPosition=0;
			if(sleepTime==15){
				arrayPosition=0;
			}else if(sleepTime==30){
				arrayPosition=1;
			}else if (sleepTime==60) {
				arrayPosition=2;
			}else if (sleepTime==120) {
				arrayPosition=3;
			}else if (sleepTime==300) {
				arrayPosition=4;
			}else if (sleepTime==600) {
				arrayPosition=5;
			}
			if(arrayPosition<6 && arrayPosition>0){
				textvwTime.setText(getResources().getStringArray(R.array.sleep)[arrayPosition]);
			}
			
			

		}

		TextView txtvw = (TextView) view.findViewById(R.id.textView_sleep);
		// set hint to already selected value in the profile or current value
		// from the phone settings
		txtvw.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				showSleepDialog(view);

			}
		});
		
		return view;

	}

	private void showSleepDialog(final View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setItems(R.array.sleep, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				String[] items = getResources().getStringArray(R.array.sleep);
				TextView textvwTime = (TextView) view.findViewById(R.id.textView_sleep_time);
				textvwTime.setText(items[which]);
				if(which==0){
					sleepTime=15;
				}else if(which==1){
					sleepTime=30;
				}else if(which==2){
					sleepTime=60;
				}else if(which==3){
					sleepTime=120;
				}else if(which==4){
					sleepTime=300;
				}else if(which==5){
					sleepTime=600;
				}else{
					sleepTime=0;
				}

			}
		});

		builder.create().show();
	}

	

	public void updateData() {

		if (view != null && display != null) {
			SeekBar seek = (SeekBar) view.findViewById(R.id.seekBar_brightness);
			display.setBrightness(seek.getProgress());

			CheckBox chkAutoRotation = (CheckBox) view.findViewById(R.id.checkBox_autorotation);
			display.setAutoRotation(chkAutoRotation.isChecked());

			CheckBox chkpulseNot = (CheckBox) view.findViewById(R.id.check_pulse_notification);
			display.setPulse_notification_light(chkpulseNot.isChecked());
			
			display.setSleep(sleepTime);

		}

	}
	public void sleepTimeChecker(){
		
	}

	@Override
	public void onDialogClick(DialogFragment dialog, int which) {
		// TODO Auto-generated method stub
		
	};

}
