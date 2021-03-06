package com.dinu.automator;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.android.gms.internal.am;

import android.content.Context;
import android.telephony.SmsManager;

public class Sms implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String number;
	private String message;
	private Location location;
	private boolean enabled;
	private boolean sent;
	
	public Sms(){
		location=new Location(Constant.INITIAL_LONGITUDE,Constant.INITIAL_LATTITUDE);
		enabled = true;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void sendSMS(){
		
		SmsManager smsManager=SmsManager.getDefault();
		ArrayList<String> parts = smsManager.divideMessage(message);
		smsManager.sendMultipartTextMessage(number, null, parts, null, null);
	}
	
	public boolean getsent(){
		return sent;
	}
	
	public void setSent(boolean send){
		sent=send;
	}
	
	
}
