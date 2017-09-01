package com.ankush.mavenshop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankush.mavenshop.dao.CategoryDao;
import com.ankush.mavenshop.dao.PostDao;



@Controller
public class WebHomePage {
	
	private String[] orderColumn=  { "post_id","post_title", "cat_name", "created_data_time","post_desc", "post_status" };

	private String webPath = "web/";
	
@Autowired
CategoryDao catDao;
@Autowired
PostDao postDao;

	@RequestMapping({ "/", "/index" })
	public String getWebHomePage(Model model,@RequestParam(required = false) Integer cat_id,@RequestParam(required = false) Integer post_id,@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer oId,@RequestParam(required = false) String oBy,@RequestParam(required = false) String sKey) {
	
		model.addAttribute("catLists", catDao.getActiveCategories());
		if(post_id!=null) {

			model.addAttribute("post", postDao.getPostWithCatById(post_id));
			
			return webPath+"post";
		}else if(cat_id!=null) {
		
			model.addAttribute("catDetails", catDao.getCategoryById( cat_id));
			
		}
		
		oId=oId == null ?0:oId;
		oBy=oBy == null ?"DESC":oBy;
		
		int postCounts=postDao.getAllActivePostsWithCatCount(sKey,cat_id);
		
		int perPagePost=3;
		
		int maxPages=postCounts%perPagePost==0?postCounts/perPagePost:1+postCounts/perPagePost;
		
		
		if (page == null || page < 1 || page > maxPages)
			page = 1;
		

		model.addAttribute("maxPages", maxPages);
		model.addAttribute("page", page);
		model.addAttribute("oId", oId);
		model.addAttribute("oBy", oBy);
		model.addAttribute("sKey", sKey);
	
		 if (page <= maxPages) {
			model.addAttribute("postsList", postDao.getActivePostsWithCat((page - 1) * perPagePost, perPagePost,orderColumn[oId],oBy,sKey,cat_id));
	 	 }
		
	
		return webPath+"index";
	}
	
	

}
