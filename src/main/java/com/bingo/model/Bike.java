package com.bingo.model;

public class Bike {
	private String id;
	private double longitude;
	private double latitude;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", status=" + status + "]";
	}
	
	
}
