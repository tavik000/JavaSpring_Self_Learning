package com.key.controller;

import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private HttpServletRequest request;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hocme(Locale locale, Model model) {


//		request.setAttribute("abc",abc);
//		model.addAttribute("abc",abc);



		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		


		String idStr = "YAya";
		try {
			Method method = GetSql.class.getMethod("main", String[].class);
			method.invoke(GetSql.class.newInstance(), new Object[]{ new String[]{idStr}});
		} catch (Exception e) {
			e.printStackTrace();
		}



		// get SQL data
		GetSql Sql = new GetSql();
		Sql.display(model);




		return "home";

	}
	
//	@RequestMapping("/home")
//	public String hello(){
//		System.out.println("inside hello()");
//		return "home";
//	}
	
}
