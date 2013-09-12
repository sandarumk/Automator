package com.dinu.automator;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Double langitude;
	private Double lattitude;
	private int radius;
	private String name;
	private boolean entering;
	
	
	
	

	public Location(double langitude, double lattitude) {
		
		this.langitude = langitude;
		this.lattitude = lattitude;
		this.entering = true;
		radius=500;
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



	public Location(Double langitude, Double lattitude, int radius){
		this.langitude=langitude;
		this.langitude=lattitude;
		this.radius=radius;
	}

}
