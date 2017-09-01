package com.ankush.mavenshop.model;

public class PostWithCat {
	
	private int post_id,post_status,post_cat_id;
	private String post_title,post_desc,created_data_time,cat_name,post_content;
	
	public PostWithCat(int post_id, int post_status, String post_title, String post_desc,
			String created_data_time, String cat_name,int post_cat_id,String post_content) {
		super();
		this.post_id = post_id;
		this.post_status = post_status;
		this.post_title = post_title;

		this.post_desc = post_desc;
		this.created_data_time = created_data_time;
		this.cat_name = cat_name;
		this.post_cat_id=post_cat_id;
		this.post_content=post_content;
	}
	public PostWithCat(int post_id, int post_status, String post_title, String post_desc,
			String created_data_time, String cat_name,int post_cat_id) {
		super();
		this.post_id = post_id;
		this.post_status = post_status;
		this.post_title = post_title;

		this.post_desc = post_desc;
		this.created_data_time = created_data_time;
		this.cat_name = cat_name;
		this.post_cat_id=post_cat_id;		
	}
	public PostWithCat() {
		super();
	}
	
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public int getPost_cat_id() {
		return post_cat_id;
	}
	public void setPost_cat_id(int post_cat_id) {
		this.post_cat_id = post_cat_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getPost_status() {
		return post_status;
	}
	public void setPost_status(int post_status) {
		this.post_status = post_status;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	
	public String getPost_desc() {
		return post_desc;
	}
	public void setPost_desc(String post_desc) {
		this.post_desc = post_desc;
	}
	public String getCreated_data_time() {
		return created_data_time;
	}
	public void setCreated_data_time(String created_data_time) {
		this.created_data_time = created_data_time;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	@Override
	public String toString() {
		return "PostWithCat [post_id=" + post_id + ", post_status=" + post_status + ", post_title=" + post_title
				+ ", post_desc=" + post_desc + ", created_data_time="
				+ created_data_time + ", cat_name=" + cat_name + "]";
	}
	
	
	

}
