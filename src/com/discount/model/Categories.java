/**
 * 
 */
package com.discount.model;

/**
 * @author han
 *
 */
public class Categories {
	private int catId;
	private String catName;

	
	public Categories(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}
	
	/**
	 * 
	 */
	public Categories() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("cat_id = ").append(catId).append(" - ");
		sb.append("cat_name = ").append(catName);
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
		Categories other = (Categories) obj;
		if (catId != other.catId)
			return false;
		if (catName == null) {
			if (other.catName != null)
				return false;
		} else if (!catName.equals(other.catName))
			return false;
		
		return true;
	}



}
