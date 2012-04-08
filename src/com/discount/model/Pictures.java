/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */

public class Pictures {
	private int picId;
	private String picLink;
	
	
	public Pictures(int picId, String picLink) {
		super();
		this.picId = picId;
		this.picLink = picLink;
	}

	public Pictures() {}
	
	public int getPicId() {
		return picId;
	}
	
	public void setPicId(int picId) {
		this.picId = picId;
	}
	
	public String getPicLink() {
		return picLink;
	}
	
	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("pic_id = ").append(picId).append(" - ");
		sb.append("pic_link = ").append(picLink);
		return sb.toString();
	}
	
	public boolean equals(Object obj) {  
		Pictures picture = (Pictures) obj;
		if (this.picId != picture.picId){
			return false;
		}
		if (this.picLink != (picture.getPicLink())){
			return false;
		}

		return true;
	}

}
