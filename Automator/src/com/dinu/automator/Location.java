package com.dinu.automator;

import java.io.Serializable;

import android.util.Log;

import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	private Double langitude;
	private Double lattitude;
	private int radius;
	private String name;
	private boolean entering;
	private boolean enable;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Location(double langitude, double lattitude) {

		this.langitude = langitude;
		this.lattitude = lattitude;
		this.entering = true;
		radius = 500;
	}

	private boolean check(double lat, double lon) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEntering() {
		return entering;
	}

	public void setEntering(boolean entering) {
		this.entering = entering;
	}

	public Double getLangitude() {
		return langitude;
	}

	public void setLangitude(Double langitude) {
		this.langitude = langitude;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Location(Double langitude, Double lattitude, int radius) {
		this.langitude = langitude;
		this.langitude = lattitude;
		this.radius = radius;
	}
	
	public boolean checkNear( LocationInfo locInfo, double radius )
	{
		Log.d("Automator service","check near called");
        android.location.Location point= new android.location.Location(" ");
        point.setLatitude( locInfo.lastLat );
		point.setLongitude( locInfo.lastLong );
		
		android.location.Location location = new android.location.Location( "" );
		location.setLatitude( lattitude);
		location.setLongitude( langitude );
		
		float distance=point.distanceTo(location);

		if ( distance <= radius )
		{
			Log.d("Automator Sevice","In region");
			return true;
		}
		else
		{ 
			Log.d("Automator Sevice","not In region");
			return false;
		}

	}

}
