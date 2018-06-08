package com.bingo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Bike类
 * 与MongoDB中的bikes collection关联
 * 
 * @author bingo
 *
 */
@Document(collection="bikes")
public class Bike {
	@Id
	private String id;
	
	private double longitude;
	
	private double latitude;
	
	// 建立索引
	@Indexed
	private Long bikeNo;
	
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
	public Long getBikeNo() {
		return bikeNo;
	}
	public void setBikeNo(Long bikeNo) {
		this.bikeNo = bikeNo;
	}
	
	@Override
	public String toString() {
		return "Bike [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", status=" + status + "]";
	}
	
	
}
