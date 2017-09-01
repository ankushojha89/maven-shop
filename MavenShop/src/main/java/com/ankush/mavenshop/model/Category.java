package com.ankush.mavenshop.model;



public class Category {

	private int cat_id,cat_status;
	private String cat_name,cat_desc;
	
	public Category() {
		super();
	}
	public Category(int cat_id, String cat_name, String cat_desc,int cat_status) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.cat_desc = cat_desc;
		this.cat_status=cat_status;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getCat_desc() {
		return cat_desc;
	}
	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}
	public int getCat_status() {
		return cat_status;
	}
	public void setCat_status(int cat_status) {
		this.cat_status = cat_status;
	}
	@Override
	public String toString() {
		return "Category [cat_id=" + cat_id + ", cat_status=" + cat_status + ", cat_name=" + cat_name + ", cat_desc="
				+ cat_desc + "]";
	}
	

	
	
	
}
