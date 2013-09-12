package com.dinu.automator;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long langitude;
	private long lattitude;
	private long radius;
	private String name;
	private boolean entering;
	
	

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



	public long getLangitude() {
		return langitude;
	}



	public void setLangitude(long langitude) {
		this.langitude = langitude;
	}



	public long getLattitude() {
		return lattitude;
	}



	public void setLattitude(long lattitude) {
		this.lattitude = lattitude;
	}



	public long getRadius() {
		return radius;
	}



	public void setRadius(long radius) {
		this.radius = radius;
	}



	public Location(long langitude, long lattitude, long radius){
		this.langitude=langitude;
		this.langitude=lattitude;
		this.radius=radius;
	}

}
