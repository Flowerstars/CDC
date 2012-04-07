/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class Merchants {
	
	private int id;
	private String merchantname;
	private String merchantInfos;
	private String location;
	
	public Merchants(int id, String merchantname, String merchantInfos, String location) {
		super();
		this.id = id;
		this.merchantname = merchantname;
		this.merchantInfos = merchantInfos;
		this.location = location;
	}
	
	public Merchants() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMerchantName() {
		return merchantname;
	}
	
	public void setMerchantName(String merchantname) {
		this.merchantname = merchantname;
	}	
	
	public String getMerchantInfos() {
		return merchantInfos;
	}
	
	public void setMerchantInfos(String merchantInfos) {
		this.merchantInfos = merchantInfos;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Id = ").append(id).append(" - ");
		sb.append("Merchantname = ").append(merchantname).append(" - ");
		sb.append("MerchantInfos = ").append(merchantInfos).append(" - ");
		sb.append("Location = ").append(location);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {  
		Merchants merchant = (Merchants) obj;
		if (this.id != merchant.id){
			return false;
		}
		if (!this.merchantname.equals(merchant.getMerchantName())){
			return false;
		}
		if (!this.location.equals(merchant.getLocation())){
			return false;
		}

		return true;
	}
}
