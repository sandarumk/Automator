package com.dinu.automator.view;

import com.dinu.automator.Location;
import com.dinu.automator.R;
import com.dinu.automator.activity.LocatorActivity;
import com.dinu.automator.activity.ProfileSettingsActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HeterogeneousExpandableList;
import android.widget.RadioGroup;

public class LocationFragment extends Fragment {
	Button setLocationMap;
	private static LocationFragment locationFragment;
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("DO NOT CRASH", "OK");
	}

	public static LocationFragment getInstance() {
		if (locationFragment == null) {
			locationFragment = new LocationFragment();
		}
		return locationFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.location_fragment, null);
		setLocationMap = (Button) view.findViewById(R.id.button_setLocation_onMap);
		setLocationMap.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Activity activity = getActivity();
				if (activity != null) {
					startActivity(new Intent(activity, LocatorActivity.class));
				}

			}
		});
		/*
		final EditText name= (EditText)view.findViewById(R.id.editText_name);
		name.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				location.setName(name.getText().toString());
				
			}
		});
		
		final EditText longitude= (EditText)view.findViewById(R.id.editText_longitude);
		longitude.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				location.setLangitude(Integer.parseInt(longitude.getText().toString()));
				
			}
		});
		
		final EditText lattitude= (EditText)view.findViewById(R.id.editText_lttitude);
		lattitude.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				location.setLattitude(Integer.parseInt(lattitude.getText().toString()));
				
			}
		});
			
				final EditText radius= (EditText)view.findViewById(R.id.editText_radius);
				longitude.addTextChangedListener(new TextWatcher() {
					
					@Override
					public void onTextChanged(CharSequence s, int start, int before, int count) {
						
						
					}
					
					@Override
					public void beforeTextChanged(CharSequence s, int start, int count, int after) {
						
						
					}
					
					@Override
					public void afterTextChanged(Editable s) {
						location.setRadius(Integer.parseInt(radius.getText().toString()));
						
					}
				});
				
				RadioGroup entering= (RadioGroup) view.findViewById(R.id.radiogroup_entering);
				entering.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if(checkedId==0){
							location.setEntering(true);
						}else{
							location.setEntering(false);
						}
				
					}
				});*/
	
		return view;
	}

	public void updateData() {
		// TODO Auto-generated method stub
		
	}
	
    

}
