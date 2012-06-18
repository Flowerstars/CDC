/**
 * 
 */
package com.discount.model;

/**
 * @author Mai
 *
 */
public class MerchantDealMap {
	
	private int dmId;
	private int dealId;
	private int merId;
	/**
	 * @param dmId
	 * @param dealId
	 * @param merId
	 */
	public MerchantDealMap(int dmId, int dealId, int merId) {
		super();
		this.dmId = dmId;
		this.dealId = dealId;
		this.merId = merId;
	}

	/**
	 * 
	 */
	public MerchantDealMap() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the dmId
	 */
	public int getDmId() {
		return dmId;
	}

	/**
	 * @param dmId the dmId to set
	 */
	public void setDmId(int dmId) {
		this.dmId = dmId;
	}

	/**
	 * @return the dealId
	 */
	public int getDealId() {
		return dealId;
	}

	/**
	 * @param dealId the dealId to set
	 */
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	/**
	 * @return the merId
	 */
	public int getMerId() {
		return merId;
	}

	/**
	 * @param merId the merId to set
	 */
	public void setMerId(int merId) {
		this.merId = merId;
	}

}
