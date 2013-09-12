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

			TextView sleep = (TextView) view.findViewById(R.id.textView_sleep_time);
			//sleep.getText().toString()
			display.setSleep(15);

		}

	}

	@Override
	public void onDialogClick(DialogFragment dialog, int which) {
		// TODO Auto-generated method stub
		
	};

}
