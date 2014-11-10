package com.impetus.elibrary.controller;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.impetus.elibrary.controller.json.JSONListResponse;
import com.impetus.elibrary.controller.json.JSONResponse;
import com.impetus.elibrary.model.User;
import com.impetus.elibrary.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger logger = Logger.getLogger(UserController.class
			.getName());

	@RequestMapping("/crud")
	public ModelAndView getView(@ModelAttribute User user) {
		return new ModelAndView("crud_user");
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		try{
			user.setRole("Role_User");
			System.out.println("Favourite Cat1 = = " + user.getFavoruiteCategory1());
			System.out.println("Favourite Cat1 = = " + user.getFavoruiteCategory2());
			userService.save(user);
		} catch (Exception ex){
			logger.warning("Error while registering user - "+ ex.getMessage());
			ModelAndView registerMAV = new ModelAndView("register_user");
			registerMAV.addObject("user", user);
			registerMAV.addObject("error", "System error occured while registering user...");
			return registerMAV;
		}
		return new ModelAndView("lib_login");
	}

	@RequestMapping(value = "/listUsers", method = RequestMethod.POST)
	public @ResponseBody JSONListResponse<User> getAllUsers(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize, @RequestParam(required=false) String jtSorting,
			@RequestParam String filterColumnName, @RequestParam String filterColumnValue) {

		logger.info("Start getAllUsers. jtStartIndex=" + jtStartIndex + ", jtPageSize=" + jtPageSize + ", jtSorting=" + jtSorting);
		JSONListResponse<User> response = null;
		try {
			Field field = null;
			boolean asc = false;
			if(! StringUtils.isEmpty(jtSorting)){
				
				field = User.class.getField(jtSorting.substring(0, jtSorting.indexOf(" ")));
				asc = jtSorting.indexOf("ASC")!=0 ? true : false ;
			}
			List<User> list = userService.list(jtStartIndex, jtPageSize, filterColumnName, filterColumnValue, field, asc);
			for (User user : list) {
				//user.setBookRequests(null);
				user.setUserSubscriptions(null);
			}
			response = new JSONListResponse<User>("OK", list, list.size());
		} catch (Exception ex) {
			response = new JSONListResponse<User>("ERROR", ex.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") int userId) {

		logger.info("Start getUser. ID=" + userId);
		return userService.getById(userId);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<User> createUser(
			@ModelAttribute User user, BindingResult result) {

		logger.info("Start createUser.");
		JSONResponse<User> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<User>("ERROR", "Form invalid");
		} {
			try {
				user.setJoinDate(new Date());
				int id = userService.save(user);
				User newUser = userService.getById(id);
				response = new JSONResponse<User>("OK", newUser);
			} catch (Exception ex) {
				response = new JSONResponse<User>("ERROR", ex.getMessage());
			}

		}
		return response;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<User> updateUser(
			@ModelAttribute User user, BindingResult result) {

		logger.info("Start updateUser.");
		JSONResponse<User> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<User>("ERROR", "Form invalid");
		} {
			try {
				int id = userService.save(user);
				User newUser = userService.getById(id);
				response = new JSONResponse<User>("OK", newUser);
			} catch (Exception ex) {
				response = new JSONResponse<User>("ERROR", ex.getMessage());
			}

		}
		return response;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<User> deleteUser(@RequestParam int userId) {

		logger.info("Start deleteUser.");
		JSONResponse<User> response = null;
		try {
			userService.delete(userId);
			response = new JSONResponse<User>("OK");
		} catch (Exception ex) {
			response = new JSONResponse<User>("ERROR", ex.getMessage());
		}
		return response;
	}
}
