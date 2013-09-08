package com.dinu.automator;

public class DisplaySettings {
	private int brightness;
	private boolean autoRotation;
	private int sleep;
	private boolean pulse_notification_light;
	

	
	
	public DisplaySettings(int brightness, boolean autoRotation, int sleep, boolean pulse_notification_light) {
		super();
		this.brightness = brightness;
		this.autoRotation = autoRotation;
		this.sleep = sleep;
		this.pulse_notification_light = pulse_notification_light;
	}

	public void activate(){
		
	}
	
	public void setBrightness(int brightness){
	//	android.provider.Settings.System.putInt(getContentResolver(),android.provider.Settings.System.SCREEN_BRIGHTNESS, brightness);
	}
	
	public void setAutoRotation(boolean rotation){
		if (rotation==true){
			autoRotation=true;
			// set autorotation
		}else{
			autoRotation=false;
			// set autorotation off
		}
	}
	public void setSleep(int sleep){
		// set the sleep value
	}
	
	public void setPulseNotificationLight(boolean light){
		if(light==true){
			pulse_notification_light=true;
			// setpulse notification 
		}
	}
}
