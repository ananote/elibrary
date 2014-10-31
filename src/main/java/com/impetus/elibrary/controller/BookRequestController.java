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
import com.impetus.elibrary.model.BookRequest;
import com.impetus.elibrary.service.BookRequestService;

@RestController
@RequestMapping("/bookRequest/")
public class BookRequestController {

	@Autowired
	BookRequestService bookRequestService;

	private static final Logger logger = Logger.getLogger(BookRequestController.class
			.getName());

	@RequestMapping("/crud")
	public ModelAndView getView(@ModelAttribute BookRequest bookRequest) {
		return new ModelAndView("crud_bookRequest");
	}

	@RequestMapping("/register")
	public ModelAndView registerBookRequest(@ModelAttribute BookRequest bookRequest) {
		bookRequestService.save(bookRequest);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/listBookRequests", method = RequestMethod.POST)
	public @ResponseBody JSONListResponse<BookRequest> getAllBookRequests(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize, @RequestParam(required=false) String jtSorting) {

		logger.info("Start getAllBookRequests. jtStartIndex=" + jtStartIndex + ", jtPageSize=" + jtPageSize + ", jtSorting=" + jtSorting);
		JSONListResponse<BookRequest> response = null;
		try {
			Field field = null;
			boolean asc = false;
			if(! StringUtils.isEmpty(jtSorting)){
				
				field = BookRequest.class.getField(jtSorting.substring(0, jtSorting.indexOf(" ")));
				asc = jtSorting.indexOf("ASC")!=0 ? true : false ;
			}
			List<BookRequest> list = bookRequestService.list(jtStartIndex, jtPageSize, field, asc);
			/*for (BookRequest bookRequest : list) {
				bookRequest.setBookRequests(null);
				bookRequest.setBookRequestSubscriptions(null);
			}*/
			response = new JSONListResponse<BookRequest>("OK", list, list.size());
		} catch (Exception ex) {
			response = new JSONListResponse<BookRequest>("ERROR", ex.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getBookRequest", method = RequestMethod.GET)
	public @ResponseBody BookRequest getBookRequest(@PathVariable("id") int bookRequestId) {

		logger.info("Start getBookRequest. ID=" + bookRequestId);
		return bookRequestService.getById(bookRequestId);
	}

	@RequestMapping(value = "/createBookRequest", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<BookRequest> createBookRequest(
			@ModelAttribute BookRequest bookRequest, BindingResult result) {

		logger.info("Start createBookRequest.");
		JSONResponse<BookRequest> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<BookRequest>("ERROR", "Form invalid");
		} {
			try {
				//bookRequest.setJoinDate(new Date());
				int id = bookRequestService.save(bookRequest);
				BookRequest newBookRequest = bookRequestService.getById(id);
				response = new JSONResponse<BookRequest>("OK", newBookRequest);
			} catch (Exception ex) {
				response = new JSONResponse<BookRequest>("ERROR", ex.getMessage());
			}

		}
		return response;
	}
	
	@RequestMapping(value = "/updateBookRequest", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<BookRequest> updateBookRequest(
			@ModelAttribute BookRequest bookRequest, BindingResult result) {

		logger.info("Start updateBookRequest.");
		JSONResponse<BookRequest> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<BookRequest>("ERROR", "Form invalid");
		} {
			try {
				int id = bookRequestService.save(bookRequest);
				BookRequest newBookRequest = bookRequestService.getById(id);
				response = new JSONResponse<BookRequest>("OK", newBookRequest);
			} catch (Exception ex) {
				response = new JSONResponse<BookRequest>("ERROR", ex.getMessage());
			}

		}
		return response;
	}

	@RequestMapping(value = "/deleteBookRequest", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<BookRequest> deleteBookRequest(@RequestParam int bookRequestId) {

		logger.info("Start deleteBookRequest.");
		JSONResponse<BookRequest> response = null;
		try {
			bookRequestService.delete(bookRequestId);
			response = new JSONResponse<BookRequest>("OK");
		} catch (Exception ex) {
			response = new JSONResponse<BookRequest>("ERROR", ex.getMessage());
		}
		return response;
	}
}
