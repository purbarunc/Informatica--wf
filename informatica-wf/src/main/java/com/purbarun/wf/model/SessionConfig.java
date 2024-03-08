package com.purbarun.wf.model;

import java.util.ArrayList;

public class SessionConfig {
	private int sequenceNumber;
	private ArrayList<String> sessionClass;

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public ArrayList<String> getSessionClass() {
		return sessionClass;
	}

	public void setSessionClass(ArrayList<String> sessionClass) {
		this.sessionClass = sessionClass;
	}

	@Override
	public String toString() {
		return "SessionConfig [sequenceNumber=" + sequenceNumber + ", sessionClass=" + sessionClass + "]";
	}
}
