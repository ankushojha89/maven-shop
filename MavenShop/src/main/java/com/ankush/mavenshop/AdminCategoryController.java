package com.ankush.mavenshop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ankush.mavenshop.dao.CategoryDao;
import com.ankush.mavenshop.model.Category;
//git test
@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

	private String[] orderColumn=  { "cat_id", "cat_name", "cat_desc", "cat_status" };

	private String adminPath = "admin/";

	@Autowired
	private CategoryDao catDao;

	
	@RequestMapping({ "/categories" })
	public String getAdminCategoriesPage(Model model) {

		model.addAttribute("catList", catDao.getCategories());
		model.addAttribute("category", new Category());
		model.addAttribute("editCategory", new Category());
		model.addAttribute("deleteCategory", new Category());
		return adminPath + "categories";
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addNewCategory(@ModelAttribute("category") Category category) {

	
		if (catDao.insertEmp(category)) {
			return "{\"status\":1,\"message\":\"New Category added !\"}";
		}

		return "{\"status\":0,\"message\":\"Application error, try after some time !\"}";
	}


	@RequestMapping(value = "/editcategory", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String editCategory(@ModelAttribute("editCategory") Category category) {

	
		if (catDao.updateCategory(category)) {
			return "{\"status\":1,\"message\":\"Category Updated !\"}";
		}

		return "{\"status\":0,\"message\":\"Application error, try after some time !\"}";
	}

	
	@RequestMapping(value = "/deletecategory", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String deleteCategory(@ModelAttribute("deleteCategory") Category category) {

		if (catDao.deleteCategory(category.getCat_id())) {
			return "{\"status\":1,\"message\":\"Category Deleted !\"}";
		}
		return "{\"status\":0,\"message\":\"Application error, try after some time !\"}";
	}

	
	
	@RequestMapping(value = "/getCategoryDataById", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Category getCategoryDataById(@RequestParam(required = true) Integer catId) {
		return catDao.getCategoryById(catId);
	}

	@RequestMapping(value = "/getCategoriesList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getCategoriesList(@RequestParam(required = false) String sKey,@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer oId,@RequestParam(required = false) String oBy) {

	
		if (oId == null )
			oId=0;
		if (oBy == null )
			oBy="ASC";
		
		
		
		
		int pagePerPost = 10, maxCount = catDao.getAllCategoriesCount(sKey);

		int maxPages = maxCount % pagePerPost == 0 ? maxCount / pagePerPost : 1 + maxCount / pagePerPost;

		if (page == null || page < 1 || page > maxPages)
			page = 1;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", page);
		map.put("maxPages", maxPages);
		map.put("oId", oId);
		map.put("oBy", oBy);
		if(sKey==null)
			map.put("sKey", "");
		else
			map.put("sKey",sKey);
		map.put("catList", catDao.getCategories((page - 1) * pagePerPost, pagePerPost,orderColumn[oId],oBy,sKey));
		return map;
	}

}
