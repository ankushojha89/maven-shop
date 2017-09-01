package com.ankush.mavenshop.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Post {

	private int post_id;
	
	@NotNull(message="Please Select") @Min(1)
    private Integer post_cat_id;
	
	@Min(0) @Max(1)
    private int post_status;
	
    @Size(min=5,max=255,message="Title of maximum lenght 250 is required")
	private String post_title;
    @Size(min=1,message="Post content required")
	private String post_content;
	private String created_data_time;
	
	@Size(min=10,max=255,message="Shot description of maximum lenght 250 is required")
	private String  post_desc;
	
	
	
	public Post() {
		super();
	}
	public Post(int post_id, int post_cat_id, int post_status, String post_title, String post_content, String post_desc,
			String created_data_time) {
		super();
		this.post_id = post_id;
		this.post_cat_id = post_cat_id;
		this.post_status = post_status;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_desc = post_desc;
		this.created_data_time = created_data_time;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public Integer getPost_cat_id() {
		return post_cat_id;
	}
	public void setPost_cat_id(Integer post_cat_id) {
		this.post_cat_id = post_cat_id;
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
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
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
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", post_cat_id=" + post_cat_id + ", post_status=" + post_status
				+ ", post_title=" + post_title + ", post_content=" + post_content + ", post_desc=" + post_desc
				+ ", created_data_time=" + created_data_time + "]";
	}
	
	
	
}
