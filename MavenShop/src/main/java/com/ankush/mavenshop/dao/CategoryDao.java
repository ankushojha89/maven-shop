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

import com.ankush.mavenshop.model.Category;


@Repository
public class CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private String selectAll = "SELECT * FROM categories ORDER BY cat_id DESC";
	private String selectByID = "SELECT * FROM categories WHERE cat_id=?";
	private String updateCat = "UPDATE categories SET cat_name=?,cat_desc=?,cat_status=? WHERE cat_id=?";
	private String deleteCat = "DELETE FROM categories WHERE cat_id=?";
	private String insertCat = "INSERT INTO categories(cat_name,cat_desc,cat_status) VALUES (?,?,?)";

	public boolean insertEmp(Category cat) {
		return jdbcTemplate.update(insertCat,
				new Object[] { cat.getCat_name(), cat.getCat_desc(), cat.getCat_status() }) > 0 ? true : false;
	}

	public Category getCategoryById(int catId) {

		try {
			return jdbcTemplate.queryForObject(selectByID, new Object[] { catId },
					new BeanPropertyRowMapper<Category>(Category.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public boolean updateCategory(Category cat) {
		return jdbcTemplate.update(updateCat,
				new Object[] { cat.getCat_name(), cat.getCat_desc(), cat.getCat_status(), cat.getCat_id() }) > 0 ? true
						: false;
	}

	public boolean deleteCategory(int cId) {
	
		return jdbcTemplate.update(deleteCat, new Object[] { cId }) > 0 ? true : false;
	}
	
	public  List<Category> getActiveCategories() {
		
		String temp = "SELECT * FROM categories WHERE  cat_status=1 ORDER BY cat_id DESC";
		return jdbcTemplate.query(temp, new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				return new Category(rs.getInt("cat_id"), rs.getString("cat_name"), rs.getString("cat_desc"),
						rs.getInt("cat_status"));
			}
		});

	}

	public List<Category> getCategories() {

		return jdbcTemplate.query(selectAll, new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				return new Category(rs.getInt("cat_id"), rs.getString("cat_name"), rs.getString("cat_desc"),
						rs.getInt("cat_status"));
			}
		});

	}
	
	public List<Category> getCategories(int offset, int row_count,String oId,String oBy,String sKey) {
		
	String temp=" ";	
	if(sKey!=null && !sKey.isEmpty()) {
	
	temp=" WHERE cat_id LIKE '%"+sKey+"%' or cat_name LIKE '%"+sKey+"%' or cat_desc LIKE '%"+sKey+"%' " ;
	
	}
		
		
		
	String selectAllWithLimit = "SELECT * FROM categories "+temp+" ORDER BY "+ oId+" "+oBy+" LIMIT ?,?";
	
		return jdbcTemplate.query(selectAllWithLimit, new Object[] {offset,row_count},new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				return new Category(rs.getInt("cat_id"), rs.getString("cat_name"), rs.getString("cat_desc"),
						rs.getInt("cat_status"));
			}
		});
		
	}

	public int getAllCategoriesCount(String sKey) {
		String temp=" ";
		if(sKey!=null && !sKey.isEmpty()) {
			
			temp=" WHERE cat_id LIKE '%"+sKey+"%' or cat_name LIKE '%"+sKey+"%' or cat_desc LIKE '%"+sKey+"%' " ;
			
		}
		
		 String countAll = "SELECT COUNT(*) FROM categories "+temp;
		return jdbcTemplate.queryForObject(countAll, Integer.class);

	}

	

}
