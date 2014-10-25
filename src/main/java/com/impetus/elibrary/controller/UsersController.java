/**
 * NOT IN USE RIGHT NOW....
 * WILL BE USED LATER
 */

package com.impetus.elibrary.controller;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.elibrary.model.User;
import com.impetus.elibrary.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserService userService;

	private static final Logger logger = Logger.getLogger(UsersController.class
			.getName());


	@RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") int userId) {

		logger.info("Start getUser. ID=" + userId);
		return userService.getById(userId);
	}

	
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {

		logger.info("Start createUser.");
		user.setJoinDate(new Date());
		userService.save(user);
		return user;
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody User user) {

		logger.info("Start updateUser.");
		user.setJoinDate(new Date());
		userService.save(user);
		return user;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public @ResponseBody User deleteUser(@PathVariable("id") int userId) {

		logger.info("Start deleteUser.");
		User user = userService.getById(userId);
		userService.delete(userId);
		return user;
	}
}
