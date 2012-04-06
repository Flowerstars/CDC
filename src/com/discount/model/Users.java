/**
 * 
 */
package com.discount.model;


/**
 * @author haoranguan
 *
 */
public class Users {
	private int id;
	private String username;
	private String password;
	private String email;
	private String location;
	private String notifications;
	private String followedMerchants;
	private String createAt;
	
	
	public Users(int id, String username, String password, String email, String location, String notifications, String followedMerchants, String createAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.location = location;
		this.notifications = notifications;
		this.followedMerchants = followedMerchants;
		this.createAt = createAt;
	}
	
	public Users() {}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return username;
	}
	
	public void setName(String username) {
		this.username = username;
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
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getNotifications() {
		return notifications;
	}
	
	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}
	
	public String getFollowedMerchants() {
		return followedMerchants;
	}
	
	public void setFollowedMerchants(String followedMerchants) {
		this.followedMerchants = followedMerchants;
	}
	
	public String getTimeStamp() {
		return createAt;
	}
	
	public void setTimeStamp(String createAt) {
		this.createAt = createAt;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Id = ").append(id).append(" - ");
		sb.append("Username = ").append(username).append(" - ");
		sb.append("Password = ").append(password).append(" - ");
		sb.append("Email = ").append(email).append(" - ");
		sb.append("Location = ").append(location).append(" - ");
		sb.append("Notifications = ").append(notifications).append(" - ");
		sb.append("FollowedMerchants = ").append(followedMerchants).append(" - ");
		sb.append("CreateAt = ").append(createAt);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {  
		Users user = (Users) obj;
		if (this.id != user.id){
			return false;
		}
		if (!this.username.equals(user.getName())){
			return false;
		}
		if (!this.email.equals(user.getEmail())){
			return false;
		}

		return true;
	}
}
