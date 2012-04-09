/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class PreferenceTags {
	private int tagId;
	private int uId;
	private String tag;

	public PreferenceTags(int tagId, int uId, String tag) {
		super();
		this.tagId = tagId;
		this.uId = uId;
		this.tag = tag;
	}

	public PreferenceTags() {}

	/**
	 * @return the tag_id
	 */
	public int getTagId() {
		return tagId;
	}

	/**
	 * @param tag_id the tag_id to set
	 */
	public void setTagId(int tagId) {
		this.tagId = tagId;
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
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}


	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("tag_id = ").append(tagId).append(" - ");
		sb.append("u_id = ").append(uId).append(" - ");
		sb.append("tag = ").append(tag);
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
		PreferenceTags other = (PreferenceTags) obj;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (tagId != other.tagId)
			return false;
		if (uId != other.uId)
			return false;
		return true;
	}

	

}
