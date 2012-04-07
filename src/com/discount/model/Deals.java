/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class Deals {

	private int id;
	private String dealname;
	private int merchantId;
	private String dealInfos;
	private String createAt;
	
	public Deals(int id, String dealname, int merchantId, String dealInfos, String createAt) {
		super();
		this.id = id;
		this.dealname = dealname;
		this.merchantId = merchantId;
		this.dealInfos = dealInfos;
		this.createAt = createAt;
	}
	
	public Deals() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDealName() {
		return dealname;
	}
	
	public void setDealName(String dealname) {
		this.dealname = dealname;
	}	
	
	public int getMerchantId() {
		return merchantId;
	}
	
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	
	public String getDealInfos() {
		return dealInfos;
	}
	
	public void setDealInfos(String dealInfos) {
		this.dealInfos = dealInfos;
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
		sb.append("Dealname = ").append(dealname).append(" - ");
		sb.append("MerchantId = ").append(merchantId).append(" - ");
		sb.append("DealInfos = ").append(dealInfos).append(" - ");
		sb.append("CreateAt = ").append(createAt);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {  
		Deals deal = (Deals) obj;
		if (this.id != deal.id){
			return false;
		}
		if (!this.dealname.equals(deal.getDealName())){
			return false;
		}
		if (this.merchantId != deal.getMerchantId()){
			return false;
		}

		return true;
	}

}
