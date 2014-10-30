package com.impetus.elibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.impetus.elibrary.dao.UserDao;
import com.impetus.elibrary.model.User;
import com.impetus.elibrary.service.LoginService;

@RestController
@RequestMapping("/login/")
public class LoginController {
	@Autowired
	UserDao userDao;

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	protected ModelAndView loginUser(@RequestParam String username,
			@RequestParam String password, HttpServletRequest request) {
		try {
			System.out.println("username = " + username);
			System.out.println("password = " + password);
			boolean result = loginService.authenticate(username, password);
			System.out.println("login result = " + result);

			if (result == true) {
				User user = userDao.getUserByUsername(username);
				request.getSession().setAttribute("user", user);
				if ("Role_Admin".equalsIgnoreCase(user.getRole())) {
					return new ModelAndView("admin_home");
				}
				return new ModelAndView("user_home");
			} else {
				ModelAndView loginMAV = new ModelAndView("lib_login");
				loginMAV.addObject("errorMsg",
						"Either user name or password is incorrect!!");
				return loginMAV;
			}
		} catch (Exception ex) {
			ModelAndView loginMAV = new ModelAndView("lib_login");
			loginMAV.addObject("errorMsg", ex.getMessage());
			return loginMAV;
		}
	}

		
	@RequestMapping(value = "/logoutUser", method = RequestMethod.GET)
	protected ModelAndView logoutUser(HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("Signing out user..." + user.getName());
			request.getSession().removeAttribute("user");
			return new ModelAndView("lib_home");
		} catch (Exception ex) {
			ModelAndView homeMAV = new ModelAndView("lib_home");
			homeMAV.addObject("errorMsg", ex.getMessage());
			return homeMAV;
		}
	}

}
