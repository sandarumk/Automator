package com.dinu.automator;

public class IntSetting extends Settings{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int setting;
	
	public IntSetting(int setting, boolean enable){
		super(enable);
		this.setting=setting;
		
		
	}

	public int getSetting() {
		return setting;
	}

	public void setSetting(int setting) {
		this.setting = setting;
	}
	

}
