package com.hsbc.meetopia.model;

public enum MeetingType {

	CLASSROOM_TRAINING("Classroom Training"), ONLINE_TRAINING("Online Training"), CONFERENCE_CALL("Conference Call"),
	BUSINESS("Business");

	private final String text;

	/**
	 * @param text
	 */
	MeetingType(final String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
}
