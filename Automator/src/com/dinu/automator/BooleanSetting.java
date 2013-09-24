package com.dinu.automator;

public class BooleanSetting extends Settings{
	boolean setting;
	
	public BooleanSetting(boolean setting,boolean enable) {
		super(enable);
		this.setting=setting;
		
	}

	

	public boolean getBooleanSetting() {
		return setting;
	}

	public void setBooleanSetting(boolean setting) {
		this.setting = setting;
	}
	

}
