package com.dinu.automator.adapter;

import java.util.List;

import com.dinu.automator.Alarm;
import com.dinu.automator.R;
import com.dinu.automator.Sms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AlarmListAdapter extends ArrayAdapter<Alarm> {

	private List<Alarm> alarms;
	private Context context;
	private int resource;
	private int textViewResourceId;
	
	public AlarmListAdapter(Context context, int resource, int textViewResourceId, List<Alarm> objects) {

		super(context, resource, textViewResourceId, objects);
		this.alarms = objects;
		this.context = context;
		this.resource = resource;
		this.textViewResourceId = textViewResourceId;

	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = convertView;

		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(resource, null);
		}

		TextView text = (TextView) view.findViewById(textViewResourceId);

		if (alarms.size() > position) {
			final Alarm alarmInstance = alarms.get(position);

			if (alarmInstance != null && alarmInstance.getName() != null) {
				text.setText(alarmInstance.getName());
				final ToggleButton switchButton = (ToggleButton) view.findViewById(R.id.alarm_list_row_button);
				switchButton.setChecked(alarmInstance.isEnabled());
				switchButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// enable or disable alarm
						if (switchButton.isChecked() == true) {
							Toast.makeText(context, "enabled alarm " + alarmInstance.getName(), Toast.LENGTH_LONG).show();
							alarmInstance.setEnabled(true);
						} else if (switchButton.isChecked() == false) {
							Toast.makeText(context, "disabled alarm " + alarmInstance.getName(), Toast.LENGTH_LONG).show();
							alarmInstance.setEnabled(false);
						}

					}
				});
			}
		}

		return view;

	}
	
	
}
