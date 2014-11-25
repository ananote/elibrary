package com.impetus.elibrary.controller;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
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
import com.impetus.elibrary.model.User;
import com.impetus.elibrary.model.UserSubscription;
import com.impetus.elibrary.service.SubscriptionService;
import com.impetus.elibrary.service.UserService;
import com.impetus.elibrary.service.UserSubscriptionService;

@RestController
@RequestMapping("/userSubscription/")
public class UserSubscriptionController {

    @Autowired
    UserSubscriptionService userSubscriptionService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserService userService;

    @Autowired
    SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(UserSubscriptionController.class.getName());

    @RequestMapping("/crud")
    public ModelAndView getView(@ModelAttribute UserSubscription userSubscription) {
        return new ModelAndView("crud_userSubscription");
    }

    @RequestMapping("/subscribe")
    public String registerUserSubscription(@RequestParam int subscriptionId, HttpServletRequest request) {
        String status = "Success";
        try {
            User user = (User) request.getSession().getAttribute("loggedin_user");
            UserSubscription userSubscription = new UserSubscription();
            userSubscription.setUser(user);
            List<UserSubscription> list = userSubscriptionService.list(userSubscription);
            for (UserSubscription existing : list) {
                if (existing.getEndDate().getTime() > System.currentTimeMillis()) {
                    status = "You already have an active subscription.";
                    break;
                }
            }
            if (status.equals("Success")) {
                Subscription subscription = subscriptionService.getById(subscriptionId);
                userSubscription.setSubscription(subscription);

                userSubscriptionService.save(userSubscription);
            }
        } catch (Exception ex) {
            status = ex.getMessage();
        }
        return status;
    }

    @RequestMapping(value = "/listUserSubscriptions", method = RequestMethod.POST)
    public @ResponseBody JSONListResponse<UserSubscription> getAllUserSubscriptions(@RequestParam int jtStartIndex,
            @RequestParam int jtPageSize, @RequestParam(required = false) String jtSorting) {

        logger.info("Start getAllUserSubscriptions. jtStartIndex=" + jtStartIndex + ", jtPageSize=" + jtPageSize + ", jtSorting="
                + jtSorting);
        JSONListResponse<UserSubscription> response = null;
        try {
            Field field = null;
            boolean asc = false;
            if (!StringUtils.isEmpty(jtSorting)) {

                field = UserSubscription.class.getField(jtSorting.substring(0, jtSorting.indexOf(" ")));
                asc = jtSorting.indexOf("ASC") != 0 ? true : false;
            }
            List<UserSubscription> list = userSubscriptionService.list(jtStartIndex, jtPageSize, field, asc);
            /*
             * for (UserSubscription userSubscription : list) {
             * userSubscription.setBookRequests(null);
             * //userSubscription.setUserSubscriptionSubscriptions(null); }
             */
            response = new JSONListResponse<UserSubscription>("OK", list, list.size());
        } catch (Exception ex) {
            response = new JSONListResponse<UserSubscription>("ERROR", ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/getUserSubscription", method = RequestMethod.GET)
    public @ResponseBody UserSubscription getUserSubscription(@PathVariable("id") int userSubscriptionId) {

        logger.info("Start getUserSubscription. ID=" + userSubscriptionId);
        return userSubscriptionService.getById(userSubscriptionId);
    }

    @RequestMapping(value = "/createUserSubscription", method = RequestMethod.POST)
    public @ResponseBody JSONResponse<UserSubscription> createUserSubscription(@ModelAttribute UserSubscription userSubscription,
            BindingResult result) {

        logger.info("Start createUserSubscription.");
        JSONResponse<UserSubscription> response = null;
        if (result.hasErrors()) {
            response = new JSONResponse<UserSubscription>("ERROR", "Form invalid");
        }
        {
            try {
                // userSubscription.setJoinDate(new Date());
                int id = userSubscriptionService.save(userSubscription);
                UserSubscription newUserSubscription = userSubscriptionService.getById(id);
                response = new JSONResponse<UserSubscription>("OK", newUserSubscription);
            } catch (Exception ex) {
                response = new JSONResponse<UserSubscription>("ERROR", ex.getMessage());
            }

        }
        return response;
    }

    @RequestMapping(value = "/updateUserSubscription", method = RequestMethod.POST)
    public @ResponseBody JSONResponse<UserSubscription> updateUserSubscription(@ModelAttribute UserSubscription userSubscription,
            BindingResult result) {

        logger.info("Start updateUserSubscription.");
        JSONResponse<UserSubscription> response = null;
        if (result.hasErrors()) {
            response = new JSONResponse<UserSubscription>("ERROR", "Form invalid");
        }
        {
            try {
                int id = userSubscriptionService.save(userSubscription);
                UserSubscription newUserSubscription = userSubscriptionService.getById(id);
                response = new JSONResponse<UserSubscription>("OK", newUserSubscription);
            } catch (Exception ex) {
                response = new JSONResponse<UserSubscription>("ERROR", ex.getMessage());
            }

        }
        return response;
    }

    @RequestMapping(value = "/deleteUserSubscription", method = RequestMethod.POST)
    public @ResponseBody JSONResponse<UserSubscription> deleteUserSubscription(@RequestParam int userSubscriptionId) {

        logger.info("Start deleteUserSubscription.");
        JSONResponse<UserSubscription> response = null;
        try {
            userSubscriptionService.delete(userSubscriptionId);
            response = new JSONResponse<UserSubscription>("OK");
        } catch (Exception ex) {
            response = new JSONResponse<UserSubscription>("ERROR", ex.getMessage());
        }
        return response;
    }
}
