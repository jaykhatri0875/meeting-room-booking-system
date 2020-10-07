package com.hsbc.meetopia.model;

public class Amenities {
	
	private String roomId;
	
	private boolean projector;
	
	private boolean wifiConnection;
	
	private boolean conferenceCallFacility;
	
	private boolean whiteboard;
	
	private boolean waterDispenser;
	
	private boolean tv;
	
	private boolean coffeeMachine;
	
	
	public Amenities(String roomId, boolean projector, boolean wifiConnection, boolean conferenceCallFacility, boolean whiteboard, boolean waterDispenser, boolean tv, boolean coffeeMachine) {
		
		this.roomId = roomId;
		this.projector = projector;
		this.wifiConnection = wifiConnection;
		this.conferenceCallFacility = conferenceCallFacility;
		this.whiteboard = whiteboard;
		this.waterDispenser = waterDispenser;
		this.tv = tv;
		this.coffeeMachine = coffeeMachine;
	}
	
	public Amenities(boolean projector, boolean wifiConnection, boolean conferenceCallFacility, boolean whiteboard, boolean waterDispenser, boolean tv, boolean coffeeMachine) {
		this.projector = projector;
		this.wifiConnection = wifiConnection;
		this.conferenceCallFacility = conferenceCallFacility;
		this.whiteboard = whiteboard;
		this.waterDispenser = waterDispenser;
		this.tv = tv;
		this.coffeeMachine = coffeeMachine;
	}

	public boolean isProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	public boolean isWifiConnection() {
		return wifiConnection;
	}

	public void setWifiConnection(boolean wifiConnection) {
		this.wifiConnection = wifiConnection;
	}

	public boolean isConferenceCallFacility() {
		return conferenceCallFacility;
	}

	public void setConferenceCallFacility(boolean conferenceCallFacility) {
		this.conferenceCallFacility = conferenceCallFacility;
	}

	public boolean isWhiteboard() {
		return whiteboard;
	}

	public void setWhiteboard(boolean whiteboard) {
		this.whiteboard = whiteboard;
	}

	public boolean isWaterDispenser() {
		return waterDispenser;
	}

	public void setWaterDispenser(boolean waterDispenser) {
		this.waterDispenser = waterDispenser;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isCoffeeMachine() {
		return coffeeMachine;
	}

	public void setCoffeeMachine(boolean coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}

	@Override
	public String toString() {
		return "Amenities [projector=" + projector + ", wifiConnection=" + wifiConnection + ", conferenceCallFacility="
				+ conferenceCallFacility + ", whiteboard=" + whiteboard + ", waterDispenser=" + waterDispenser + ", tv="
				+ tv + ", coffeeMachine=" + coffeeMachine + "]";
	}
	
	
	
}