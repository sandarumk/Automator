package com.dinu.automator.adapter;

import java.util.List;

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

public class SmsListAdapter extends ArrayAdapter<Sms>{

	private List<Sms> sms;
	private Context context;
	private int resource;
	private int textViewResourceId;

	public SmsListAdapter(Context context, int resource, int textViewResourceId, List<Sms> objects) {

		super(context, resource, textViewResourceId, objects);
		this.sms = objects;
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

		if (sms.size() > position) {
			final Sms smsInstance = sms.get(position);

			if (smsInstance != null && smsInstance.getName() != null) {
				text.setText(smsInstance.getName());
				final ToggleButton switchButton = (ToggleButton) view.findViewById(R.id.sms_list_row_button);

				switchButton.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// enable or disable profile
						if (switchButton.isChecked() == true) {
							Toast.makeText(context, "enabled profile " + smsInstance.getName(), Toast.LENGTH_LONG).show();
							smsInstance.setEnabled(true);
						} else if (switchButton.isChecked() == false) {
							Toast.makeText(context, "disabled profile " + smsInstance.getName(), Toast.LENGTH_LONG).show();
							smsInstance.setEnabled(false);
						}

					}
				});
			}
		}

		return view;

	}

}
