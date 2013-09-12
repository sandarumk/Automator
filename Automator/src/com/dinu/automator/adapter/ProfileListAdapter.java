package com.dinu.automator.adapter;

import java.util.List;

import com.dinu.automator.Profile;
import com.dinu.automator.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;



public class ProfileListAdapter extends ArrayAdapter<Profile> {

	private List<Profile> profiles;
	private Context context;
	private int resource;
	private int textViewResourceId;

	public ProfileListAdapter(Context context, int resource,
			int textViewResourceId, List<Profile> objects) {

		super(context, resource, textViewResourceId, objects);
		this.profiles = objects;
		this.context = context;
		this.resource = resource;
		this.textViewResourceId=textViewResourceId;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;
		
		if(view == null){
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view =inflater.inflate(resource, null); 
		}
		
		TextView text= (TextView) view.findViewById(textViewResourceId);
		
		if(profiles.size() > position){
		final Profile profile = profiles.get(position); 

		if(profile != null && profile.getName() != null){
			text.setText(profile.getName());
			final ToggleButton switchButton = (ToggleButton)view.findViewById(R.id.profile_list_row_button);
		
			switchButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// enable or disable profile
					if (switchButton.isChecked()==true){
						Toast.makeText(context, "enabled profile " + profile.getName(), Toast.LENGTH_LONG).show();
						profile.setEnable(true);
					}else if (switchButton.isChecked()== false){
						Toast.makeText(context, "disabled profile " + profile.getName(), Toast.LENGTH_LONG).show();
						profile.setEnable(false);
					}
				
				}
			});
			}
		}
		
	
		return view;

	}

}
