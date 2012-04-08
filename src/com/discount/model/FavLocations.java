/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class FavLocations {
	private int flId;
	private int uId;
	private String locationName;
	private double locationLong;
	private double locationLat;
	
	public FavLocations(int flId, int uId, String locationName, double locationLong, double locationLat) {
		super();
		this.flId = flId;
		this.uId = uId;
		this.locationName = locationName;
		this.locationLong = locationLong;
		this.locationLat = locationLat;
	}

	/**
	 * 
	 */
	public FavLocations() {}

	/**
	 * @return the flId
	 */
	public int getFlId() {
		return flId;
	}

	/**
	 * @param flId the flId to set
	 */
	public void setFlId(int flId) {
		this.flId = flId;
	}

	/**
	 * @return the uId
	 */
	public int getuId() {
		return uId;
	}

	/**
	 * @param uId the uId to set
	 */
	public void setuId(int uId) {
		this.uId = uId;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the locationLong
	 */
	public double getLocationLong() {
		return locationLong;
	}

	/**
	 * @param locationLong the locationLong to set
	 */
	public void setLocationLong(double locationLong) {
		this.locationLong = locationLong;
	}

	/**
	 * @return the locationLat
	 */
	public double getLocationLat() {
		return locationLat;
	}

	/**
	 * @param locationLat the locationLat to set
	 */
	public void setLocationLat(double locationLat) {
		this.locationLat = locationLat;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("fl_id = ").append(flId).append(" - ");
		sb.append("u_id = ").append(uId).append(" - ");
		sb.append("location_name = ").append(locationName).append(" - ");
		sb.append("location = (").append(locationLong).append(", ").append(locationLat).append(")");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavLocations other = (FavLocations) obj;
		if (flId != other.flId)
			return false;
		if (Double.doubleToLongBits(locationLat) != Double
				.doubleToLongBits(other.locationLat))
			return false;
		if (Double.doubleToLongBits(locationLong) != Double
				.doubleToLongBits(other.locationLong))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (uId != other.uId)
			return false;
		
		return true;
	}
	
}
