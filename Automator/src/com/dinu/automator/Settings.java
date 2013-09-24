package com.dinu.automator;

import java.io.Serializable;

public class Settings implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean enable;
	
	public Settings(boolean enable) {
		this.enable=enable;
	}
	


	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}
