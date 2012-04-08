/**
 * 
 */
package com.discount.model;


/**
 * @author haoranguan
 *
 */
public class Users {
	private int uId;
	private String userName;
	private String password;
	private String email;
	private double locationLong;
	private double locationLat;
	private String notifications;
	private String createAt;
	
	
	public Users(int uId, String userName, String password, String email, double locationLong, double locationLat, String notifications, String createAt) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.locationLong = locationLong;
		this.locationLat = locationLat;
		this.notifications = notifications;
		this.createAt = createAt;
	}
	
	public Users() {}


	public int getUId() {
		return uId;
	}
	
	public void setId(int uId) {
		this.uId = uId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	public String getNotifications() {
		return notifications;
	}
	
	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}
	
	public String getTimeStamp() {
		return createAt;
	}
	
	public void setTimeStamp(String createAt) {
		this.createAt = createAt;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("u_id = ").append(uId).append(" - ");
		sb.append("user_name = ").append(userName).append(" - ");
		sb.append("Password = ").append(password).append(" - ");
		sb.append("Email = ").append(email).append(" - ");
		sb.append("Location = (").append(locationLong).append(", ").append(locationLat).append(")").append(" - ");
		sb.append("Notifications = ").append(notifications).append(" - ");
		sb.append("CreateAt = ").append(createAt);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {  
		Users user = (Users) obj;
		if (this.uId != user.uId){
			return false;
		}
		if (!this.userName.equals(user.getUserName())){
			return false;
		}
		if (!this.email.equals(user.getEmail())){
			return false;
		}

		return true;
	}
}
