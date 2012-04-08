/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class Merchants {
	
	private int merId;
	private int picId;
	private String merName;
	private String merInfo;
	private double locationLong;
	private double locationLat;
	private String dealHistory;
	
	public Merchants(int merId, int picId, String merName, String merInfo, double locationLong, double locationLat, String dealHistory) {
		super();
		this.merId = merId;
		this.picId = picId;
		this.merName = merName;
		this.merInfo = merInfo;
		this.locationLong = locationLong;
		this.locationLat = locationLat;
		this.dealHistory = dealHistory;
	}
	
	public Merchants() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMerId() {
		return merId;
	}
	
	public void setMerId(int merId) {
		this.merId = merId;
	}
	
	public int getPicId() {
		return picId;
	}
	
	public void setPicId(int picId) {
		this.picId = picId;
	}
	
	public String getMerName() {
		return merName;
	}
	
	public void setMerName(String merName) {
		this.merName = merName;
	}	
	
	public String getMerInfo() {
		return merInfo;
	}
	
	public void setMerInfo(String merInfo) {
		this.merInfo = merInfo;
	}
	
	public double getLocationLong() {
		return locationLong;
	}
	
	public void setLocationLong(double locationLong) {
		this.locationLong = locationLong;
	}
	
	public double getLocationLat() {
		return locationLat;
	}
	
	public void setLocationLat(double locationLat) {
		this.locationLat = locationLat;
	}
	
	public String getDealHistory() {
		return dealHistory;
	}
	
	public void setDealHistory(String dealHistory) {
		this.dealHistory = dealHistory;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("mer_id = ").append(merId).append(" - ");
		sb.append("pic_id = ").append(picId).append(" - ");
		sb.append("mer_name = ").append(merName).append(" - ");
		sb.append("mer_info = ").append(merInfo).append(" - ");
		sb.append("location_long = ").append(locationLong);
		sb.append("location_lat = ").append(locationLat);
		sb.append("deal_history = ").append(dealHistory);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {  
		Merchants merchant = (Merchants) obj;
		if (this.merId != merchant.merId){
			return false;
		}
		if (!this.merName.equals(merchant.getMerName())){
			return false;
		}
		if (this.locationLong != merchant.getLocationLong()){
			return false;
		}
		if (this.locationLat != merchant.getLocationLat()){
			return false;
		}

		return true;
	}
}
