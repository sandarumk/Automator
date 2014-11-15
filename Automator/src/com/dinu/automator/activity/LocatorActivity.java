package com.dinu.automator.activity;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.dinu.automator.Constant;
import com.dinu.automator.R;
import com.dinu.automator.util.ViewUtils;
import com.dinu.automator.view.SetLocationDialogFragment;
import com.dinu.automator.view.SetLocationDialogFragment.NoticeDialogListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;

public class LocatorActivity extends SherlockActivity implements NoticeDialogListener {

	int radius;
	GoogleMap map;
	LatLng position;
	Double lattitude = 21.0;
	Double longitude = 7.0;
	String name;
	Boolean entering;

	Circle circle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locator);
		
		ViewUtils.setActionBarColor(this);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.getUiSettings().setMyLocationButtonEnabled(true);

		LocationInfo latestInfo = new LocationInfo(getBaseContext());
		lattitude = (double) latestInfo.lastLat;
		longitude = (double) latestInfo.lastLong;

		final Marker marker1 = map.addMarker(new MarkerOptions().position(new LatLng(lattitude, longitude)));
		CircleOptions circleOptions = new CircleOptions().center(marker1.getPosition()).radius(1000);
		circle = map.addCircle(circleOptions);
		circleOptions.strokeWidth(0.1f);
		marker1.setDraggable(true);

		map.setOnMarkerDragListener(new OnMarkerDragListener() {

			@Override
			public void onMarkerDragStart(Marker marker) {
				circle.remove();

			}

			@Override
			public void onMarkerDragEnd(Marker marker) {
				if (circle != null) {
					circle.remove();
				}
				CircleOptions circleOptions = new CircleOptions().center(marker.getPosition()).radius(1000);
				circle = map.addCircle(circleOptions);
				position = marker.getPosition();
				lattitude = position.latitude;
				longitude = position.longitude;
				DialogFragment dialog = new SetLocationDialogFragment(lattitude.toString(), longitude.toString());
				dialog.show(getFragmentManager(), "location");
				moveToMarker(marker);
			}

			@Override
			public void onMarkerDrag(Marker marker) {

			}
		});

		map.setOnMapLongClickListener(new OnMapLongClickListener() {

			@Override
			public void onMapLongClick(LatLng point) {
				if (circle != null) {
					circle.remove();
				}
				marker1.setPosition(point);
				CircleOptions circleOptions = new CircleOptions().center(marker1.getPosition()).radius(1000);
				circle = map.addCircle(circleOptions);
				position = marker1.getPosition();
				lattitude = position.latitude;
				longitude = position.longitude;
				showSelectionDialog();

				moveToMarker(marker1);
			}

		});

		// set initial map location
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lattitude, longitude), 14.0f));
	}

	private void showSelectionDialog() {
		DialogFragment dialog = new SetLocationDialogFragment(lattitude.toString(), longitude.toString());
		dialog.show(getFragmentManager(), "location");
	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogPositiveClick(DialogFragment dialog, double lattitude, double longitude, int radius, String name, boolean entering) {
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.radius = radius;
		this.entering = entering;
		this.name = name;

	}

	@Override
	public void onDialogError(int errorCode) {
		String message = "Invalid ";

		if (errorCode == 0) {

		} else {
			if (errorCode == 1) {
				message += "latitude";
			} else if (errorCode == 2) {
				message += "longtitude";
			} else if (errorCode == 3) {
				message += "radius value";
			} else if (errorCode == 4) {
				message += " entering or leaving selection";
			}

			Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
			showSelectionDialog();
		}

	}

	@Override
	public void finish() {
		// Prepare data intent
		Intent data = new Intent();
		data.putExtra(Constant.INTENT_EXTRA_LOCATION_LATTITUDE, lattitude);
		data.putExtra(Constant.INTENT_EXTRA_LOCATION_LONGITUDE, longitude);
		data.putExtra(Constant.INTENT_EXTRA_LOCATION_RADIUS, radius);
		data.putExtra(Constant.INTENT_EXTRA_LOCATION_ENTERING, entering);
		data.putExtra(Constant.INTENT_EXTRA_LOCATION_NAME, name);
		// Activity finished ok, return the data
		setResult(RESULT_OK, data);
		super.finish();
	}

	private void moveToMarker(Marker marker) {
//		double lat = marker.getPosition().latitude;
//		double lon = marker.getPosition().longitude;
//
//		double offset = 100000 / 1E6;
//
//		LatLng southwest = new LatLng(lat - offset, lon - offset);
//		LatLng northeast = new LatLng(lat + offset, lon + offset);
//		LatLngBounds center = new LatLngBounds(southwest, northeast);

//		CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(center, 10);
		CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 14.0f);
		if (map != null) {
			map.animateCamera(cu);
		}

	}

}
