package com.dinu.automator.view;

import com.dinu.automator.Constant;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HeterogeneousExpandableList;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class LocationFragment extends Fragment {
	Button setLocationMap;
	private static LocationFragment locationFragment;
	private Location location;
	private View view;
	double lat;
	double lon;
	boolean ent;
	int rad;
	String nam;
	

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

		view = inflater.inflate(R.layout.location_fragment, null);
		EditText name= (EditText)view.findViewById(R.id.editText_name);
		EditText longitude= (EditText)view.findViewById(R.id.editText_longitude);
		EditText lattitude= (EditText)view.findViewById(R.id.editText_lttitude);
		EditText radius=(EditText)view.findViewById(R.id.editText_radius);
		RadioButton entering=(RadioButton)view.findViewById(R.id.radiobutton_entering);
		RadioButton leaving=(RadioButton)view.findViewById(R.id.radiobutton_leaving);
		
		
		
		if (location !=null) {
			
			String defaultName="";
			if(location.getName()!=null){
				defaultName=location.getName();
				}
			
			nam=getActivity().getIntent().getStringExtra(Constant.INTENT_EXTRA_LOCATION_NAME);
			if(name==null){
				nam=defaultName;
			}
			name.setText(nam);
			
			
			
			longitude.setText(location.getLangitude().toString());
			lon=getActivity().getIntent().getDoubleExtra(Constant.INTENT_EXTRA_LOCATION_LONGITUDE, location.getLangitude());
			longitude.setText(lon+"");
			
			
			lattitude.setText(location.getLattitude().toString());
			lat=getActivity().getIntent().getDoubleExtra(Constant.INTENT_EXTRA_LOCATION_LATTITUDE, location.getLattitude());
			lattitude.setText(lat+"");
			
			
			
			radius.setText(location.getRadius()+"");
			rad=getActivity().getIntent().getIntExtra(Constant.INTENT_EXTRA_LOCATION_RADIUS, location.getRadius());
			radius.setText(rad+"");
			
			ent=getActivity().getIntent().getBooleanExtra(Constant.INTENT_EXTRA_LOCATION_ENTERING,location.isEntering());
			entering.setChecked(ent);
			leaving.setChecked(!ent);


		
			}
		setLocationMap = (Button) view.findViewById(R.id.button_setLocation_onMap);
		setLocationMap.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Activity activity = getActivity();
				if (activity != null) {
					startActivity(new Intent(activity, LocatorActivity.class));
				}

			}
		});
		
		
		return view;
	}

	public void updateData() {
		
		if (view != null && location !=null) {
			
		EditText name= (EditText)view.findViewById(R.id.editText_name);
		location.setName(name.getText().toString());
		
		EditText longitude= (EditText)view.findViewById(R.id.editText_longitude);
		location.setLangitude(Double.parseDouble(longitude.getText().toString()));
		
		EditText lattitude= (EditText)view.findViewById(R.id.editText_lttitude);
		location.setLattitude(Double.parseDouble(lattitude.getText().toString()));
		
		EditText radius=(EditText)view.findViewById(R.id.editText_radius);
		location.setRadius(Integer.parseInt(radius.getText().toString()));
		
		RadioButton entering=(RadioButton)view.findViewById(R.id.radiobutton_entering);
		location.setEntering(entering.isChecked());
		
		
		
			
		}
		
	}
	
    

}
