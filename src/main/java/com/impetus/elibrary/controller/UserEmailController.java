package com.impetus.elibrary.controller;

import java.lang.reflect.Field;
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
import com.impetus.elibrary.model.UserEmail;
import com.impetus.elibrary.service.UserEmailService;

@RestController
@RequestMapping("/userEmail/")
public class UserEmailController {

	@Autowired
	UserEmailService userEmailService;

	private static final Logger logger = Logger
			.getLogger(UserEmailController.class.getName());

	@RequestMapping("/crud")
	public ModelAndView getView(@ModelAttribute UserEmail userEmail) {
		return new ModelAndView("crud_userEmail");
	}

	@RequestMapping("/register")
	public ModelAndView registerUserEmail(@ModelAttribute UserEmail userEmail) {
		userEmailService.save(userEmail);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/listUserEmails", method = RequestMethod.POST)
	public @ResponseBody
	JSONListResponse<UserEmail> getAllUserEmails(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@RequestParam(required = false) String jtSorting) {

		logger.info("Start getAllUserEmails. jtStartIndex=" + jtStartIndex
				+ ", jtPageSize=" + jtPageSize + ", jtSorting=" + jtSorting);
		JSONListResponse<UserEmail> response = null;
		try {
			Field field = null;
			boolean asc = false;
			if (!StringUtils.isEmpty(jtSorting)) {

				field = UserEmail.class.getField(jtSorting.substring(0,
						jtSorting.indexOf(" ")));
				asc = jtSorting.indexOf("ASC") != 0 ? true : false;
			}
			List<UserEmail> list = userEmailService.list(jtStartIndex,
					jtPageSize, field, asc);
			/*for (UserEmail userEmail : list) {
	//			userEmail.setBookRequests(null);
		//		userEmail.setUserEmailSubscriptions(null);
			}*/
			response = new JSONListResponse<UserEmail>("OK", list, list.size());
		} catch (Exception ex) {
			response = new JSONListResponse<UserEmail>("ERROR", ex.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getUserEmail", method = RequestMethod.GET)
	public @ResponseBody
	UserEmail getUserEmail(@PathVariable("id") int userEmailId) {

		logger.info("Start getUserEmail. ID=" + userEmailId);
		return userEmailService.getById(userEmailId);
	}

	@RequestMapping(value = "/createUserEmail", method = RequestMethod.POST)
	public @ResponseBody
	JSONResponse<UserEmail> createUserEmail(
			@ModelAttribute UserEmail userEmail, BindingResult result) {

		logger.info("Start createUserEmail.");
		JSONResponse<UserEmail> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<UserEmail>("ERROR", "Form invalid");
		}
		{
			try {
				//userEmail.setJoinDate(new Date());
				int id = userEmailService.save(userEmail);
				UserEmail newUserEmail = userEmailService.getById(id);
				response = new JSONResponse<UserEmail>("OK", newUserEmail);
			} catch (Exception ex) {
				response = new JSONResponse<UserEmail>("ERROR", ex.getMessage());
			}

		}
		return response;
	}

	@RequestMapping(value = "/updateUserEmail", method = RequestMethod.POST)
	public @ResponseBody
	JSONResponse<UserEmail> updateUserEmail(
			@ModelAttribute UserEmail userEmail, BindingResult result) {

		logger.info("Start updateUserEmail.");
		JSONResponse<UserEmail> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<UserEmail>("ERROR", "Form invalid");
		}
		{
			try {
				int id = userEmailService.save(userEmail);
				UserEmail newUserEmail = userEmailService.getById(id);
				response = new JSONResponse<UserEmail>("OK", newUserEmail);
			} catch (Exception ex) {
				response = new JSONResponse<UserEmail>("ERROR", ex.getMessage());
			}

		}
		return response;
	}

	@RequestMapping(value = "/deleteUserEmail", method = RequestMethod.POST)
	public @ResponseBody
	JSONResponse<UserEmail> deleteUserEmail(@RequestParam int userEmailId) {

		logger.info("Start deleteUserEmail.");
		JSONResponse<UserEmail> response = null;
		try {
			userEmailService.delete(userEmailId);
			response = new JSONResponse<UserEmail>("OK");
		} catch (Exception ex) {
			response = new JSONResponse<UserEmail>("ERROR", ex.getMessage());
		}
		return response;
	}
}
