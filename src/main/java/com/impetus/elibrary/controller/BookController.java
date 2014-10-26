package com.impetus.elibrary.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
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
import com.impetus.elibrary.controller.json.JSONMapperBean;
import com.impetus.elibrary.controller.json.JSONResponse;
import com.impetus.elibrary.model.Book;
import com.impetus.elibrary.service.BookService;

@RestController
@RequestMapping("/book/")
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	JSONMapperBean jsonMapperBean;

	private static final Logger logger = Logger.getLogger(BookController.class
			.getName());

	@RequestMapping("/crud")
	public ModelAndView getView(@ModelAttribute Book book) {
		return new ModelAndView("crud_book");
	}

	@RequestMapping("/register")
	public ModelAndView registerBook(@ModelAttribute Book book) {
		bookService.save(book);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/listBooks", method = RequestMethod.POST)
	public @ResponseBody JSONListResponse<Book> getAllBooksPost(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize, @RequestParam(required=false) String jtSorting) {

		logger.info("Start getAllBooks. jtStartIndex=" + jtStartIndex + ", jtPageSize=" + jtPageSize + ", jtSorting=" + jtSorting);
		JSONListResponse<Book> response = null;
		try {
			Field field = null;
			boolean asc = false;
			if(! StringUtils.isEmpty(jtSorting)){
				
				field = Book.class.getField(jtSorting.substring(0, jtSorting.indexOf(" ")));
				asc = jtSorting.indexOf("ASC")!=0 ? true : false ;
			}
			List<Book> list = bookService.list(jtStartIndex, jtPageSize, field, asc);
			for (Book book : list) {
				book.setBookRequests(null);
				//book.setBookSubscriptions(null);
			}
			response = new JSONListResponse<Book>("OK", list, list.size());
		} catch (Exception ex) {
			response = new JSONListResponse<Book>("ERROR", ex.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/listBooks", method = RequestMethod.GET)
	public String getAllBooksGet(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize, @RequestParam(required=false) String jtSorting) {
		
		JSONListResponse<Book> response = this.getAllBooksPost(jtStartIndex, jtPageSize, jtSorting);
		String json = "";
		try {
			json = jsonMapperBean.writeValueAsString(response.getRecords());
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("JSON =" + json);
		return json;
	}

	@RequestMapping(value = "/getBook", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable("id") int bookId) {

		logger.info("Start getBook. ID=" + bookId);
		return bookService.getById(bookId);
	}

	@RequestMapping(value = "/createBook", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<Book> createBook(
			@ModelAttribute Book book, BindingResult result) {

		logger.info("Start createBook.");
		JSONResponse<Book> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<Book>("ERROR", "Form invalid");
		} {
			try {
				//book.setJoinDate(new Date());
				int id = bookService.save(book);
				Book newBook = bookService.getById(id);
				response = new JSONResponse<Book>("OK", newBook);
			} catch (Exception ex) {
				response = new JSONResponse<Book>("ERROR", ex.getMessage());
			}

		}
		return response;
	}
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<Book> updateBook(
			@ModelAttribute Book book, BindingResult result) {

		logger.info("Start updateBook.");
		JSONResponse<Book> response = null;
		if (result.hasErrors()) {
			response = new JSONResponse<Book>("ERROR", "Form invalid");
		} {
			try {
				int id = bookService.save(book);
				Book newBook = bookService.getById(id);
				response = new JSONResponse<Book>("OK", newBook);
			} catch (Exception ex) {
				response = new JSONResponse<Book>("ERROR", ex.getMessage());
			}

		}
		return response;
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public @ResponseBody JSONResponse<Book> deleteBook(@RequestParam int bookId) {

		logger.info("Start deleteBook.");
		JSONResponse<Book> response = null;
		try {
			bookService.delete(bookId);
			response = new JSONResponse<Book>("OK");
		} catch (Exception ex) {
			response = new JSONResponse<Book>("ERROR", ex.getMessage());
		}
		return response;
	}
}
