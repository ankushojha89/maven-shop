package com.ankush.mavenshop;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ankush.mavenshop.dao.CategoryDao;
import com.ankush.mavenshop.dao.PostDao;
import com.ankush.mavenshop.model.Post;

@Controller
@RequestMapping("/admin")
public class AdminPostController {
	
	private String[] orderColumn=  { "post_id","post_title", "cat_name", "created_data_time","post_desc", "post_status" };

	private String adminPath = "admin/";

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryDao catDao;

	@RequestMapping({ "/posts" })
	public String getAdminPostsPage(Model model,@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer oId,@RequestParam(required = false) String oBy,@RequestParam(required = false) String sKey) {
		
		oId=oId == null ?0:oId;
		oBy=oBy == null ?"ASC":oBy;		
		int postCounts=postDao.getAllPostsWithCatCount(sKey);
		
		int perPagePost=5;
		
		int maxPages=postCounts%perPagePost==0?postCounts/perPagePost:1+postCounts/perPagePost;
		
		
		if (page == null || page < 1 || page > maxPages)
			page = 1;
		
		model.addAttribute("maxPages", maxPages);
		model.addAttribute("page", page);
		model.addAttribute("oId", oId);
		model.addAttribute("oBy", oBy);
		 if (page <= maxPages) {
			model.addAttribute("postsList", postDao.getPostsWithCat((page - 1) * perPagePost, perPagePost,orderColumn[oId],oBy,sKey));
		}
		
		return adminPath + "posts";
	}
	
	@RequestMapping({ "/addpost" })
	public String addPost(Model model,@Valid @ModelAttribute("post") Post post,BindingResult result) {

		  if(!result.hasErrors() && post.getPost_content()!=null && post.getPost_title()!=null && post.getPost_desc()!=null)
		{			
			System.out.println(post);
			postDao.insertPost(post);
			return "redirect:/admin/posts";			
		} 
		
		model.addAttribute("catList", catDao.getActiveCategories());
		return adminPath + "addPost";
	}
	
	@RequestMapping({ "/editpost/{pId}" })
	public String editPost(@RequestParam(required = false) String editSubmit ,@PathVariable(required=true) Integer pId, Model model,@Valid @ModelAttribute("post") Post post,BindingResult result) {

		post.setPost_id(pId);
		if(editSubmit==null) {
			post=postDao.getPostById(pId);
		}
		  if( !result.hasErrors() &&post.getPost_content()!=null && post.getPost_title()!=null && post.getPost_desc()!=null)
		{			
			postDao.updatePost(post);
			return "redirect:/admin/editpost/"+pId;			
		} 	
	
		model.addAttribute("post", post);
		
		model.addAttribute("catList", catDao.getActiveCategories());
		return adminPath + "editPost";
	}
	
	@RequestMapping(value = "/deletepost", method = RequestMethod.POST)
	public String deletePost(@ModelAttribute("deletePost") Post post) {

		postDao.deletePost(post.getPost_id());
		
		return "redirect:/admin/posts";	
		
	}
	
	

}
