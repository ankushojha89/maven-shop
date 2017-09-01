package com.ankush.mavenshop;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ankush.mavenshop.dao.CategoryDao;
import com.ankush.mavenshop.dao.PostDao;
import com.ankush.mavenshop.model.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private String adminPath = "admin/";

	@Autowired
	private CategoryDao catDao;
	@Autowired
	private PostDao postDao;

	@RequestMapping({ "/" })
	public String adminHomePage(Model model) {

		model.addAttribute("catCount", catDao.getAllCategoriesCount(null));
		model.addAttribute("postCount", postDao.getAllPostsCount());

		return adminPath + "index";
	}

	@RequestMapping({ "/world" })
	public String adminWorldPage(Model model,@Valid @ModelAttribute("world") WorldTest world, BindingResult result) {

		
		model.addAttribute("message","Welcome to Assignment");
		if(result.hasErrors()) {
			System.out.println("Errors : "+world.getState());
			
			if(world.getCountry()!=null) {
				model.addAttribute("stateList", getStateList(world.getCountry()));
				model.addAttribute("message","bummer! Error in Form");
			}
			
		}else if(world.getCountry()!=null&&world.getState()!=null&&world.getPinCode()!=null) {
			System.out.println("Done : "+world.getState());
			System.out.println(world);
			model.addAttribute("message"," Error Free Assignment Form Submitted");
			return "redirect:/admin/world";
		}else
			model.addAttribute("world",new WorldTest());
		
		
		System.out.println(world);
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("SG", "Singapore");
		country.put("IND", "India");

		model.addAttribute("countryList", country);

		return adminPath + "world";
	}

	@RequestMapping(value = "/getStateList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, String> getStateList(@RequestParam String ct) {

		Map<String, String> state = new LinkedHashMap<String, String>();
		switch (ct) {

		case "US":
			state.put("AK", "Alaska");
			state.put("CA", "California");
			state.put("FL", "Florida");
			state.put("NY", "New York");
			break;

		case "SG":
			state.put("CR", "Central Region");
			state.put("ER", "East Region");
			state.put("NR", "North Region");
			state.put("NER", "North-East Region");
			state.put("WR", "West Region");

			break;

		case "IND":		
			state.put("AP", "Andhra Pradesh");
			state.put("GUJ", "Gujarat");
			state.put("HY", "Haryana");
			state.put("JK", "Jammu and Kashmir");
			
			default:
				state.put("", "Select country first");

		}

		return state;
	}

}
