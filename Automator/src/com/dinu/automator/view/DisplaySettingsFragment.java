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
import android.widget.ToggleButton;

import com.dinu.automator.DisplayProfile;
import com.dinu.automator.R;
import com.dinu.automator.view.SleepDialogFragment.SleepDialogListener;

public class DisplaySettingsFragment extends Fragment implements SleepDialogListener {
	private DisplayProfile display;
	private int sleepTime;
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
		SeekBar seek = (SeekBar) view.findViewById(R.id.seekBar_brightness);
		seek.setProgress(0);
		CheckBox chkBrightness=(CheckBox)view.findViewById(R.id.checkBox_brightness_enable);
		chkBrightness.setChecked(false);
		ToggleButton autorotation=(ToggleButton)view.findViewById(R.id.switch_autorotation );
		autorotation.setChecked(false);
		CheckBox chkautorotation=(CheckBox)view.findViewById(R.id.checkBox_autorotation_enable);
		chkautorotation.setChecked(false);
		ToggleButton pulse=(ToggleButton)view.findViewById(R.id.switch_pulse_notification );
		pulse.setChecked(false);
		CheckBox chkPulse=(CheckBox)view.findViewById(R.id.checkBox_pulse_notification_enable);
		chkPulse.setChecked(false);
		
		
		if (display != null) {
			
			seek.setProgress(display.getBrightness().getSetting());
			
			chkBrightness.setChecked(display.getBrightness().isEnable());
			
			
			autorotation.setChecked(display.isAutoRotation().getBooleanSetting());
			
			chkautorotation.setChecked(display.isAutoRotation().isEnable());
			
			
			pulse.setChecked(display.isPulseNotificationLight().getBooleanSetting());
			
			chkPulse.setChecked(display.isAutoRotation().isEnable());
			
			CheckBox sleep=(CheckBox)view.findViewById(R.id.checkBox_sleep_enable);
			sleepTime = display.getSleep().getSetting();
			TextView textvwTime = (TextView) view.findViewById(R.id.textView_sleep_time);
			int arrayPosition = 0;
			if (sleepTime == 15) {
				arrayPosition = 0;
			} else if (sleepTime == 30) {
				arrayPosition = 1;
			} else if (sleepTime == 60) {
				arrayPosition = 2;
			} else if (sleepTime == 120) {
				arrayPosition = 3;
			} else if (sleepTime == 300) {
				arrayPosition = 4;
			} else if (sleepTime == 600) {
				arrayPosition = 5;
			}
			if (arrayPosition < 6 && arrayPosition > 0) {
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
				if (which == 0) {
					sleepTime = 15;
				} else if (which == 1) {
					sleepTime = 30;
				} else if (which == 2) {
					sleepTime = 60;
				} else if (which == 3) {
					sleepTime = 120;
				} else if (which == 4) {
					sleepTime = 300;
				} else if (which == 5) {
					sleepTime = 600;
				} else {
					sleepTime = 0;
				}

			}
		});

		builder.create().show();
	}

	public void updateData() {

		if (view != null && display != null) {
			SeekBar seek = (SeekBar) view.findViewById(R.id.seekBar_brightness);
			CheckBox chkBrightness= (CheckBox)view.findViewById(R.id.checkBox_brightness_enable);
			display.setBrightness(seek.getProgress(), chkBrightness.isChecked());
			
			ToggleButton switchAutoRotation= (ToggleButton)view.findViewById(R.id.switch_autorotation);
			CheckBox chkAutorotation= (CheckBox)view.findViewById(R.id.checkBox_autorotation_enable);
			display.setAutoRotation(switchAutoRotation.isChecked(), chkAutorotation.isChecked());
			
			ToggleButton switchPulse= (ToggleButton)view.findViewById(R.id.switch_pulse_notification);
			CheckBox chksetPulse= (CheckBox)view.findViewById(R.id.checkBox_pulse_notification_enable);
			display.setAutoRotation(switchPulse.isChecked(), chksetPulse.isChecked());
			
			
			CheckBox chksleep= (CheckBox)view.findViewById(R.id.checkBox_sleep_enable);
			display.setSleep(sleepTime, chksleep.isChecked());

		}

	}
	public DisplayProfile getDisplay() {
		return display;
	}

	public void setDisplay(DisplayProfile display) {
		this.display = display;
	}

	

	@Override
	public void onDialogClick(DialogFragment dialog, int which) {
	

	};

}
