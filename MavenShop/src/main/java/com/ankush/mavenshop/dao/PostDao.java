package com.ankush.mavenshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ankush.mavenshop.model.Post;
import com.ankush.mavenshop.model.PostWithCat;

@Repository
public class PostDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String selectAllWithLimit = "SELECT * FROM posts ORDER BY post_id DESC LIMIT ?,?";

	private String countAll = "SELECT COUNT(*) FROM posts";
	private String selectByID = "SELECT * FROM posts WHERE post_id=?";
	private String updatePost = "UPDATE posts SET post_title=?,post_content=?,post_desc=?,post_cat_id=?,post_status=? WHERE post_id=?";
	private String deletePost = "DELETE FROM posts WHERE post_id=?";
	private String insertPost = "INSERT INTO posts(post_title,post_content,post_desc,post_cat_id,post_status) VALUES (?,?,?,?,?)";
	

	public boolean insertPost(Post post) {
	
		return jdbcTemplate.update(insertPost,
				new Object[] { post.getPost_title(),post.getPost_content(),post.getPost_desc(),post.getPost_cat_id(),post.getPost_status() }) > 0 ? true : false;
	}
	
	public Post getPostById(int postId) {

		try {
			return jdbcTemplate.queryForObject(selectByID, new Object[] { postId },
					new BeanPropertyRowMapper<Post>(Post.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
	
	public boolean updatePost(Post post) {
		return jdbcTemplate.update(updatePost,
				new Object[] { post.getPost_title(),post.getPost_content(),post.getPost_desc(),post.getPost_cat_id(),post.getPost_status(),post.getPost_id() }) > 0 ? true
						: false;
	}
	
	public boolean deletePost(int postId) {		
		return jdbcTemplate.update(deletePost, new Object[] { postId }) > 0 ? true : false;
	}

	public int getAllPostsCount() {

		return jdbcTemplate.queryForObject(countAll, Integer.class);

	}
	
	public int getAllPostsWithCatCount(String sKey) {
		String temp=" ";	
		if(sKey!=null && !sKey.isEmpty()) {
		
		temp=" WHERE post_id LIKE '%"+sKey+"%' or cat_name LIKE '%"+sKey+"%' or post_title LIKE '%"+sKey+"%' or post_content LIKE '%"+sKey+ "%' or post_desc LIKE '%"+sKey+ "%'";
		
		}
			
		
		String selectAllWithLimitCat = "SELECT COUNT(*) FROM posts LEFT JOIN categories ON (posts.post_cat_id=categories.cat_id)  "+temp;   


		return jdbcTemplate.queryForObject(selectAllWithLimitCat, Integer.class);

	}
	
	public int getAllActivePostsWithCatCount(String sKey,Integer cat_id) {
		String temp=" ";	
		
		if(cat_id!=null) {
			temp=" AND cat_id="+cat_id+" ";
		}
		if(sKey!=null && !sKey.isEmpty()) {
		
		temp=" AND (post_id LIKE '%"+sKey+"%' or cat_name LIKE '%"+sKey+"%' or post_title LIKE '%"+sKey+"%' or post_content LIKE '%"+sKey+ "%' or post_desc LIKE '%"+sKey+ "%')";
		
		}
			
		
		String selectAllWithLimitCat = "SELECT COUNT(*) FROM posts,categories WHERE post_status=1 AND posts.post_cat_id=categories.cat_id  "+temp;   


		return jdbcTemplate.queryForObject(selectAllWithLimitCat, Integer.class);

	}
	
public List<Post> getPosts(int offset, int row_count) {
		
		
		return jdbcTemplate.query(selectAllWithLimit, new Object[] {offset,row_count},new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int row) throws SQLException {
				return new Post(rs.getInt("post_id"),rs.getInt("post_cat_id"),rs.getInt("post_status"),rs.getString("post_title"),rs.getString("post_content"),rs.getString("post_desc"),rs.getString("created_data_time") );
			}
		});
		
	}


public List<PostWithCat> getPostsWithCat(int offset, int row_count,String oId,String oBy,String sKey) {
	
	String temp=" ";	
	if(sKey!=null && !sKey.isEmpty()) {
	
	temp=" WHERE post_id LIKE '%"+sKey+"%' or cat_name LIKE '%"+sKey+"%' or post_title LIKE '%"+sKey+"%' or post_content LIKE '%"+sKey+ "%' or post_desc LIKE '%"+sKey+ "%'";
	
	}
		
	
	String selectAllWithLimitCat = "SELECT post_id,post_cat_id,post_status,post_title,post_desc,created_data_time,cat_name FROM posts LEFT JOIN categories ON(posts.post_cat_id=categories.cat_id) "+temp+" ORDER BY "+ oId+" "+oBy+" LIMIT ?,?";   

	return jdbcTemplate.query(selectAllWithLimitCat, new Object[] {offset,row_count},new RowMapper<PostWithCat>() {
		@Override
		public PostWithCat mapRow(ResultSet rs, int row) throws SQLException {
			return new PostWithCat(rs.getInt("post_id"),rs.getInt("post_status"),rs.getString("post_title"),rs.getString("post_desc"),rs.getString("created_data_time"),rs.getString("cat_name"),rs.getInt("post_cat_id") );
		}
	});
	
}

public List<PostWithCat> getActivePostsWithCat(int offset, int row_count,String oId,String oBy,String sKey,Integer cat_id) {
	
	String temp=" ";	
	if(cat_id!=null) {
		temp=" AND cat_id="+cat_id+" ";
	}
	
	if(sKey!=null && !sKey.isEmpty()) {
	
		
	temp=" AND (post_id LIKE '%"+sKey+"%' or cat_name LIKE '%"+sKey+"%' or post_title LIKE '%"+sKey+"%' or post_content LIKE '%"+sKey+ "%' or post_desc LIKE '%"+sKey+ "%')";
	
	}
		
	
	String selectAllWithLimitCat = "SELECT post_id,post_cat_id,post_status,post_title,post_desc,created_data_time,cat_name FROM posts,categories WHERE post_status=1 AND posts.post_cat_id=categories.cat_id "+temp+" ORDER BY "+ oId+" "+oBy+" LIMIT ?,?";   

	return jdbcTemplate.query(selectAllWithLimitCat, new Object[] {offset,row_count},new RowMapper<PostWithCat>() {
		@Override
		public PostWithCat mapRow(ResultSet rs, int row) throws SQLException {
			return new PostWithCat(rs.getInt("post_id"),rs.getInt("post_status"),rs.getString("post_title"),rs.getString("post_desc"),rs.getString("created_data_time"),rs.getString("cat_name"),rs.getInt("post_cat_id") );
		}
	});
	
}


public PostWithCat getPostWithCatById(int postId) {
	
	String query = "SELECT * FROM posts,categories WHERE post_id=?  AND posts.post_cat_id=categories.cat_id ";

	try {
		return jdbcTemplate.queryForObject(query, new Object[] { postId },
				new BeanPropertyRowMapper<PostWithCat>(PostWithCat.class));

	} catch (EmptyResultDataAccessException e) {
		return null;
	}

}

}
