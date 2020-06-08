package com.bean;

public class CategoryBean {

	int category_id;
	String category_name;
	boolean is_active;
	
	public CategoryBean() {
	}

	public CategoryBean(String category_id) {
		this.category_id = Integer.parseInt(category_id);
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
}
