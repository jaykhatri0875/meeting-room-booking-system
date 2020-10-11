package com.hsbc.meetopia.model;

public class Amenities {
	
	private String uid;
	
	private String roomId;
	
	private int projector;
	
	private int wifiConnection;
	
	private int conferenceCallFacility;
	
	private int whiteboard;
	
	private int waterDispenser;
	
	private int tv;
	
	private int coffeeMachine;
	
	
	public Amenities(String uid, String roomId, int projector, int wifiConnection, int conferenceCallFacility, int whiteboard, int waterDispenser, int tv, int coffeeMachine) {
		
		this.uid = uid;
		this.roomId = roomId;
		this.projector = projector;
		this.wifiConnection = wifiConnection;
		this.conferenceCallFacility = conferenceCallFacility;
		this.whiteboard = whiteboard;
		this.waterDispenser = waterDispenser;
		this.tv = tv;
		this.coffeeMachine = coffeeMachine;
	}
	
	public Amenities(int projector, int wifiConnection, int conferenceCallFacility, int whiteboard, int waterDispenser, int tv, int coffeeMachine) {
		this.projector = projector;
		this.wifiConnection = wifiConnection;
		this.conferenceCallFacility = conferenceCallFacility;
		this.whiteboard = whiteboard;
		this.waterDispenser = waterDispenser;
		this.tv = tv;
		this.coffeeMachine = coffeeMachine;
	}

	public Amenities(String meetingId, int projector, int wifiConnection, int conferenceCallFacility, int whiteboard, int waterDispenser, int tv, int coffeeMachine) {
		this.uid = meetingId;
		this.projector = projector;
		this.wifiConnection = wifiConnection;
		this.conferenceCallFacility = conferenceCallFacility;
		this.whiteboard = whiteboard;
		this.waterDispenser = waterDispenser;
		this.tv = tv;
		this.coffeeMachine = coffeeMachine;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRoomId() {
		return roomId;
	}

	public int isProjector() {
		return projector;
	}

	public void setProjector(int projector) {
		this.projector = projector;
	}

	public int isWifiConnection() {
		return wifiConnection;
	}

	public void setWifiConnection(int wifiConnection) {
		this.wifiConnection = wifiConnection;
	}

	public int isConferenceCallFacility() {
		return conferenceCallFacility;
	}

	public void setConferenceCallFacility(int conferenceCallFacility) {
		this.conferenceCallFacility = conferenceCallFacility;
	}

	public int isWhiteboard() {
		return whiteboard;
	}

	public void setWhiteboard(int whiteboard) {
		this.whiteboard = whiteboard;
	}

	public int isWaterDispenser() {
		return waterDispenser;
	}

	public void setWaterDispenser(int waterDispenser) {
		this.waterDispenser = waterDispenser;
	}

	public int isTv() {
		return tv;
	}

	public void setTv(int tv) {
		this.tv = tv;
	}

	public int isCoffeeMachine() {
		return coffeeMachine;
	}

	public void setCoffeeMachine(int coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}

	@Override
	public String toString() {
		return "Amenities [projector=" + projector + ", wifiConnection=" + wifiConnection + ", conferenceCallFacility="
				+ conferenceCallFacility + ", whiteboard=" + whiteboard + ", waterDispenser=" + waterDispenser + ", tv="
				+ tv + ", coffeeMachine=" + coffeeMachine + "]";
	}
	
	
	
}