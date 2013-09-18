package com.dinu.automator;

import java.io.Serializable;

public class BatteryLevel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int start;
	private int end;

	public BatteryLevel(int number1, int number2) {
		start = number1;
		end = number2;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}