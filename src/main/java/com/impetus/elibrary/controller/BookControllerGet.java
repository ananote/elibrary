package com.impetus.elibrary.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.elibrary.controller.json.JSONListResponse;
import com.impetus.elibrary.controller.json.JSONMapperBean;
import com.impetus.elibrary.model.Book;
import com.impetus.elibrary.service.BookService;

@RestController
@RequestMapping("/book/")

public class BookControllerGet {
	@Autowired
	BookService bookService;
	
	@Autowired
	JSONMapperBean jsonMapperBean;
	
	private static final Logger logger = Logger.getLogger(BookControllerGet.class
			.getName());
	
	
	@RequestMapping(value = "/listBooks", method = RequestMethod.GET)
	public @ResponseBody List<Book> getAllBooks(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize, 
			@RequestParam(defaultValue="") String name, @RequestParam(defaultValue="") String author,
			@RequestParam(defaultValue="") String category) {
		logger.info("Start getAllBooks. jtStartIndex=" + jtStartIndex + ", jtPageSize=" + jtPageSize + ", name=" + name +
				", author=" + author + ", category =" + category);
		
		List<Book> list = new ArrayList<Book>();
		try {
			Book criteria = new Book();
			
			criteria.setAuthor(author);
			criteria.setCategory(category);
			criteria.setName(name);
			list = bookService.list(criteria);
			for (Book book : list) {
				book.setBookRequests(null);
			}
		} catch (Exception ex) {
			logger.warning(ex.getMessage());
		}
		return list;

	}
	
	@RequestMapping(value = "/listAllAuthors", method = RequestMethod.GET)
	public String getAllAuthors(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize, @RequestParam(required=false) String jtSorting) {
		logger.info("Start getAllAuthors. jtStartIndex=" + jtStartIndex + ", jtPageSize=" + jtPageSize + ", jtSorting=" + jtSorting);
		JSONListResponse<Book> response = null;
		try {
			Field field = null;
			boolean asc = false;
			if(! StringUtils.isEmpty(jtSorting)){
				
				field = Book.class.getField(jtSorting.substring(0, jtSorting.indexOf(" ")));
				asc = jtSorting.indexOf("ASC")!=0 ? true : false ;
			}
			List<Book> list = bookService.list(jtStartIndex, jtPageSize, null, null, field, asc);
			for (Book book : list) {
				book.setBookRequests(null);
				//book.setBookSubscriptions(null);
			}
			response = new JSONListResponse<Book>("OK", list, list.size());
		} catch (Exception ex) {
			response = new JSONListResponse<Book>("ERROR", ex.getMessage());
		}
		//return response;
		String json="";
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
	

}
