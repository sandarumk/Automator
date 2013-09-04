package com.dinu.automator.activity;

import com.dinu.automator.R;
import com.dinu.automator.R.layout;
import com.dinu.automator.view.SetLocationDialogFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.MyLocationOverlay;

import android.app.Activity;
import android.app.DialogFragment;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;


public class LocatorActivity extends Activity {
	
	Location location;
	int radius;
	GoogleMap map;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locator);
		map=((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.getUiSettings().setMyLocationButtonEnabled(true);;
		map.setMyLocationEnabled(true);
		final Marker marker1= map.addMarker(new MarkerOptions().position(new LatLng(37.4,-122.1)));
		CircleOptions circleOptions = new CircleOptions().center(marker1.getPosition()).radius(1000);
		final Circle circle = map.addCircle(circleOptions);
		circleOptions.strokeWidth(0.1f);
		marker1.setDraggable(true);
		
		map.setOnMarkerDragListener(new OnMarkerDragListener(
				) {
			
			@Override
			public void onMarkerDragStart(Marker marker) {
				// TODO Auto-generated method stub
				circle.remove();
				
				
			}
			
			@Override
			public void onMarkerDragEnd(Marker marker) {
				// TODO Auto-generated method stub
				CircleOptions circleOptions = new CircleOptions().center(marker.getPosition()).radius(1000);
				Circle circle = map.addCircle(circleOptions);
				DialogFragment dialog = new SetLocationDialogFragment();
				dialog.show(getFragmentManager(),"location");
				
			}
			
			@Override
			public void onMarkerDrag(Marker marker) {
				// TODO Auto-generated method stub
				Toast toast=Toast.makeText(getApplicationContext(), marker1.getPosition().toString(), Toast.LENGTH_SHORT);
				toast.show();
				
			
				
			}
		});
		
		map.setOnMapLongClickListener(new OnMapLongClickListener() {
			
			@Override
			public void onMapLongClick(LatLng point) {
				// TODO Auto-generated method stub
				marker1.setPosition(point);
				CircleOptions circleOptions = new CircleOptions().center(marker1.getPosition()).radius(1000);
				Circle circle = map.addCircle(circleOptions);
				DialogFragment dialog = new SetLocationDialogFragment();
				dialog.show(getFragmentManager(),"location");
				
			}
		});
		
		
		
		
		
		
		
		
		
	}

	
}
