/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class Deals {

	private int dealId;
	private int catId;
	private int merId;
	private int picId;
	private String dealName;
	private double discount;
	private String dealInfo;
	private String createAt;
	
	public Deals(int dealId, int catId, int merId, int picId, String dealName, double discount, String dealInfo, String createAt) {
		super();
		this.dealId = dealId;
		this.catId = catId;
		this.merId = merId;
		this.picId = picId;
		this.dealName = dealName;
		this.discount = discount;
		this.dealInfo = dealInfo;
		this.createAt = createAt;
	}
	
	public Deals() {
		// TODO Auto-generated constructor stub
	}

	public int getDealId() {
		return dealId;
	}
	
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	
	public int getMerId() {
		return merId;
	}
	
	public void setMerId(int merId) {
		this.merId = merId;
	}
	
	public int getCatId() {
		return catId;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	
	public int getPicId() {
		return picId;
	}
	
	public void setPicId(int picId) {
		this.picId = picId;
	}
	
	public String getDealName() {
		return dealName;
	}
	
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}	
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String getDealInfo() {
		return dealInfo;
	}
	
	public void setDealInfo(String dealInfo) {
		this.dealInfo = dealInfo;
	}
	
	public String getTimeStamp() {
		return createAt;
	}
	
	public void setTimeStamp(String createAt) {
		this.createAt = createAt;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("deal_id = ").append(dealId).append(" - ");
		sb.append("mer_id = ").append(merId).append(" - ");
		sb.append("cat_id = ").append(catId).append(" - ");
		sb.append("pic_id = ").append(picId).append(" - ");
		sb.append("deal_name = ").append(dealName).append(" - ");
		sb.append("discount = ").append(discount).append(" - ");
		sb.append("deal_info = ").append(dealInfo).append(" - ");
		sb.append("create_at = ").append(createAt);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {  
		Deals deal = (Deals) obj;
		if (this.dealId != deal.dealId){
			return false;
		}
		if (this.merId != (deal.getMerId())){
			return false;
		}
		if (this.catId != deal.getCatId()){
			return false;
		}
		if (this.dealName.equals(deal.getDealName())){
			return false;
		}
		if (this.discount != deal.getDiscount()){
			return false;
		}

		return true;
	}

}
