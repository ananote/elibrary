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
import com.impetus.elibrary.model.Subscription;
import com.impetus.elibrary.service.SubscriptionService;

@RestController
@RequestMapping("/subscription/")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;

	private static final Logger logger = Logger.getLogger(SubscriptionController.class
			.getName());

	@RequestMapping("/crud")
	public ModelAndView getView(@ModelAttribute Subscription subscription) {
		return new ModelAndView("crud_subscription");
	}

	@RequestMapping("/register")
	public ModelAndView registerSubscription(@ModelAttribute Subscription subscription) {
		subscriptionService.save(subscription);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/listSubscriptions", method = RequestMethod.POST)
	public @ResponseBody JSONListResponse<Subscription> getAllSubscriptions(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize, @RequestParam(required=false) String jtSorting) {

		logger.info("Start getAllSubscriptions. jtStartIndex=" + jtStartIndex + ", jtPageSize=" + jtPageSize + ", jtSorting=" + jtSorting);
		JSONListResponse<Subscription> response = null;
		try {
			Field field = null;
			boolean asc = false;
			if(! StringUtils.isEmpty(jtSorting)){
				
				field = Subscription.class.getField(jtSorting.substring(0, jtSorting.indexOf(" ")));
				asc = jtSorting.indexOf("ASC")!=0 ? true : false ;
			}
			List<Subscription> list = subscriptionService.list(jtStartIndex, jtPageSize, field, asc);
			/*for (Subscription subscription : list) {
				subscription.setBookRequests(null);
				subscription.setSubscriptionSubscriptions(null);
			}*/
			response = new JSONListResponse<Subscription>("OK", list, list.size());
		} catch (Exception ex) {
			response = new JSONListResponse<Subscription>("ERROR", ex.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getSubscription", method = RequestMethod.GET)
	public @ResponseBody Subscription getSubscription(@PathVariable("id") int subscriptionId) {

		logger.info("Start getSubscription. ID=" + subscriptionId);
		return subscriptionService.getById(subscriptionId);
	}

	@RequestMapping(value = "/createSubscription", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<Subscription> createSubscription(
			@ModelAttribute Subscription subscription, BindingResult result) {

		logger.info("Start createSubscription.");
		JSONResponse<Subscription> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<Subscription>("ERROR", "Form invalid");
		} {
			try {
				//subscription.setJoinDate(new Date());
				int id = subscriptionService.save(subscription);
				Subscription newSubscription = subscriptionService.getById(id);
				response = new JSONResponse<Subscription>("OK", newSubscription);
			} catch (Exception ex) {
				response = new JSONResponse<Subscription>("ERROR", ex.getMessage());
			}

		}
		return response;
	}
	
	@RequestMapping(value = "/updateSubscription", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<Subscription> updateSubscription(
			@ModelAttribute Subscription subscription, BindingResult result) {

		logger.info("Start updateSubscription.");
		JSONResponse<Subscription> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<Subscription>("ERROR", "Form invalid");
		} {
			try {
				int id = subscriptionService.save(subscription);
				Subscription newSubscription = subscriptionService.getById(id);
				response = new JSONResponse<Subscription>("OK", newSubscription);
			} catch (Exception ex) {
				response = new JSONResponse<Subscription>("ERROR", ex.getMessage());
			}

		}
		return response;
	}

	@RequestMapping(value = "/deleteSubscription", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<Subscription> deleteSubscription(@RequestParam int subscriptionId) {

		logger.info("Start deleteSubscription.");
		JSONResponse<Subscription> response = null;
		try {
			subscriptionService.delete(subscriptionId);
			response = new JSONResponse<Subscription>("OK");
		} catch (Exception ex) {
			response = new JSONResponse<Subscription>("ERROR", ex.getMessage());
		}
		return response;
	}
}
