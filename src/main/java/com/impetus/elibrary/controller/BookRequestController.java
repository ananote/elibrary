package com.impetus.elibrary.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
import com.impetus.elibrary.model.Book;
import com.impetus.elibrary.model.BookRequest;
import com.impetus.elibrary.service.BookRequestService;
import com.impetus.elibrary.service.BookService;

@RestController
@RequestMapping("/bookRequest/")
public class BookRequestController {

	@Autowired
	BookRequestService bookRequestService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserSOAPService userSOAPService;

	private static final Logger logger = Logger
			.getLogger(BookRequestController.class.getName());

	@RequestMapping("/crud")
	public ModelAndView getView(@ModelAttribute BookRequest bookRequest) {
		return new ModelAndView("crud_bookRequest");
	}

	@RequestMapping("/register")
	public ModelAndView registerBookRequest(
			@ModelAttribute BookRequest bookRequest) {
		bookRequestService.save(bookRequest);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/listBookRequests", method = RequestMethod.POST)
	public @ResponseBody JSONListResponse<BookRequest> getAllBookRequests(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@RequestParam(required = false) String jtSorting,
			@RequestParam String filterColumnName,
			@RequestParam String filterColumnValue) {

		logger.info("Start getAllBookRequests. jtStartIndex=" + jtStartIndex
				+ ", jtPageSize=" + jtPageSize + ", jtSorting=" + jtSorting);
		JSONListResponse<BookRequest> response = null;
		try {
			Field field = null;
			boolean asc = false;
			if (!StringUtils.isEmpty(jtSorting)) {

				field = BookRequest.class.getField(jtSorting.substring(0,
						jtSorting.indexOf(" ")));
				asc = jtSorting.indexOf("ASC") != 0 ? true : false;
			}
			List<BookRequest> list = bookRequestService
					.list(jtStartIndex, jtPageSize, filterColumnName,
							filterColumnValue, field, asc);
			 
			response = new JSONListResponse<BookRequest>("OK", list,
					list.size());
		} catch (Exception ex) {
			response = new JSONListResponse<BookRequest>("ERROR",
					ex.getMessage());
		}
		
		return response;
	}
	
	@RequestMapping(value = "/listUserBookRequests", method = RequestMethod.GET)
	public @ResponseBody List<BookRequest> getUserBookRequests(
			@RequestParam String userId,
			@RequestParam String pageType) {

		logger.info("Start getUserBookRequests. userId=" + userId
				+ ", pageType=" + pageType);
		List<BookRequest> response = new ArrayList<BookRequest>();
		try {
			//Field field = null;
			//boolean asc = false;
			
			BookRequest br = new BookRequest();
			br.setUserId(Integer.parseInt(userId));
			//br.setStatus(pageType);
			response = bookRequestService.list(br);
			 
		} catch (Exception ex) {
			logger.warning("Error : " + ex.getMessage());
		}
		
		logger.info("Invoking PDF report...");
		userSOAPService.bookDeliveryToUsers();
		return response;
	}

	@RequestMapping(value = "/getBookRequest", method = RequestMethod.GET)
	public @ResponseBody BookRequest getBookRequest(
			@PathVariable("id") int bookRequestId) {

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
		}
		{
			try {
				// bookRequest.setJoinDate(new Date());
				int id = bookRequestService.save(bookRequest);
				BookRequest newBookRequest = bookRequestService.getById(id);
				response = new JSONResponse<BookRequest>("OK", newBookRequest);
			} catch (Exception ex) {
				response = new JSONResponse<BookRequest>("ERROR",
						ex.getMessage());
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
		}
		{
			try {
				int id = bookRequestService.save(bookRequest);
				BookRequest newBookRequest = bookRequestService.getById(id);
				response = new JSONResponse<BookRequest>("OK", newBookRequest);
			} catch (Exception ex) {
				response = new JSONResponse<BookRequest>("ERROR",
						ex.getMessage());
			}

		}
		return response;
	}

	@RequestMapping(value = "/deleteBookRequest", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<BookRequest> deleteBookRequest(
			@RequestParam int bookRequestId) {

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

	@RequestMapping(value = "/makeBookRequest", method = RequestMethod.GET)
	public String makeBookRequest(@RequestParam int bookId,
			@RequestParam int userId, @RequestParam String status) {

		logger.info("Start makeBookRequest.");
		String response = new String();
		try {
			BookRequest br = new BookRequest();
			Book book = bookService.getById(bookId);
			br.setBookId(bookId);
			br.setBookName(book.getName());
			br.setBookImageUrl(book.getImageUrl());
			if (status=="Requested"){
				Date date = new Date();
				br.setRequestDate(date);
			}
			br.setStatus(status);
			br.setUserId(userId);
			// bookRequest.setJoinDate(new Date());
			int id = bookRequestService.save(br);
			BookRequest newBookRequest = bookRequestService.getById(id);
			response =  "Book Request Successful";
		} catch (Exception ex) {
			response = "Book Request Failed. Please check your shelf, may be selected";
			logger.warning(response+' '+ex.getMessage());
		}

		return response;
	}
}
