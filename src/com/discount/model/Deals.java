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
	private String title;
	private double discount;
	private String dealInfo;
	private String createAt;
	private String value;
	private String price;
	private String startTime;
	private String endTime;
	
	public Deals(int dealId, int catId, int merId, int picId, String title,
			double discount, String dealInfo, String createAt, String value,
			String price, String startTime, String endTime) {
		super();
		this.dealId = dealId;
		this.catId = catId;
		this.merId = merId;
		this.picId = picId;
		this.title = title;
		this.discount = discount;
		this.dealInfo = dealInfo;
		this.createAt = createAt;
		this.value = value;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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
		sb.append("title = ").append(title).append(" - ");
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
		if (this.title.equals(deal.getTitle())){
			return false;
		}
		if (this.discount != deal.getDiscount()){
			return false;
		}

		return true;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
