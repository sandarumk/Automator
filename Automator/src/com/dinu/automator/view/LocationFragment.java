package com.dinu.automator.view;

import com.dinu.automator.R;
import com.dinu.automator.activity.LocatorActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LocationFragment extends Fragment{
	Button setLocationMap;
	
	public static LocationFragment newInstance() {
		LocationFragment fragment= new LocationFragment();
        

                return fragment;
    }
@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.location_fragment, null);
		setLocationMap=(Button)view.findViewById(R.id.button_setLocation_onMap);
		setLocationMap.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(getActivity(),LocatorActivity.class));
			
		}
	});
	
		
		
		
		//getActivity().getIntent().getIntExtra(name, defaultValue);
		//view.findViewById(id);
	
		
		
		
		
		
		
		return view;
	}

}
