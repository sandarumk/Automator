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
import android.widget.Toast;
import android.widget.ToggleButton;

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
		
		
		
		
		if (location !=null) {
			EditText name= (EditText)view.findViewById(R.id.editText_name);
			
			if(location.getName()!=null){
			name.setText(location.getName());
			}else{
				name.setText("");
			}

			EditText longitude= (EditText)view.findViewById(R.id.editText_longitude);
			longitude.setText(location.getLangitude().toString());

			EditText lattitude= (EditText)view.findViewById(R.id.editText_lttitude);
			lattitude.setText(location.getLattitude().toString());
			
			ToggleButton enableLocation=(ToggleButton)view.findViewById(R.id.toggle_button_enable_location);
			enableLocation.setChecked(location.isEnable());


			EditText radius=(EditText)view.findViewById(R.id.editText_radius);
			radius.setText(location.getRadius()+"");

			RadioButton entering=(RadioButton)view.findViewById(R.id.radiobutton_entering);
			RadioButton leaving=(RadioButton)view.findViewById(R.id.radiobutton_leaving);
			if(location.isEntering()==true){
				entering.setChecked(true);
				leaving.setChecked(false);
			}else{
				entering.setChecked(false);
				leaving.setChecked(true);
			}


			}


		setLocationMap = (Button) view.findViewById(R.id.button_setLocation_onMap);
		setLocationMap.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Activity activity = getActivity();
				if (activity != null) {
					startActivityForResult(new Intent(activity, LocatorActivity.class),9000);
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
		ToggleButton enableLocation=(ToggleButton)view.findViewById(R.id.toggle_button_enable_location);
		location.setEnable(enableLocation.isChecked());
		
		
		
			
		}
		
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  if (resultCode == Activity.RESULT_OK && requestCode == 9000) {
	   lat=data.getDoubleExtra(Constant.INTENT_EXTRA_LOCATION_LATTITUDE, 0);
	   if(lat!=0){
		   EditText lattitude= (EditText)view.findViewById(R.id.editText_lttitude);
			lattitude.setText(lat+"");
	   }
	   lon=data.getDoubleExtra(Constant.INTENT_EXTRA_LOCATION_LONGITUDE, 0);
	   if(lon!=0){
		   EditText longitude= (EditText)view.findViewById(R.id.editText_longitude);
			longitude.setText(lon+"");
	   }
	   rad=data.getIntExtra(Constant.INTENT_EXTRA_LOCATION_RADIUS, 0);
	   if(rad!=0){
		   EditText radius=(EditText)view.findViewById(R.id.editText_radius);
			radius.setText(rad+"");
	   }
	   nam=data.getStringExtra(Constant.INTENT_EXTRA_LOCATION_NAME);
	   if(nam!=null){
		   EditText name= (EditText)view.findViewById(R.id.editText_name);
		   name.setText(nam);
	   }
	   ent=data.getBooleanExtra(Constant.INTENT_EXTRA_LOCATION_ENTERING, false);
	   RadioButton entering=(RadioButton)view.findViewById(R.id.radiobutton_entering);
		RadioButton leaving=(RadioButton)view.findViewById(R.id.radiobutton_leaving);
		entering.setChecked(ent);
		leaving.setChecked(!ent);
	   
			   
	  }
	} 
    

}
