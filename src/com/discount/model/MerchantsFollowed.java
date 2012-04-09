/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class MerchantsFollowed {
	private int mfId;
	private int uId;
	private int merId;
	
	
	public MerchantsFollowed() {}


	public MerchantsFollowed(int mfId, int uId, int merId) {
		super();
		this.mfId = mfId;
		this.uId = uId;
		this.merId = merId;
	}


	/**
	 * @return the mfId
	 */
	public int getMfId() {
		return mfId;
	}


	/**
	 * @param mfId the mfId to set
	 */
	public void setMfId(int mfId) {
		this.mfId = mfId;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + merId;
		result = prime * result + mfId;
		result = prime * result + uId;
		return result;
	}


	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("mf_id = ").append(mfId).append(" - ");
		sb.append("u_id = ").append(uId).append(" - ");
		sb.append("mer_id = ").append(merId);
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
		MerchantsFollowed other = (MerchantsFollowed) obj;
		if (merId != other.merId)
			return false;
		if (mfId != other.mfId)
			return false;
		if (uId != other.uId)
			return false;
		
		return true;
	}
	
	

}
