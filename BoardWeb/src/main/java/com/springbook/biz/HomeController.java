package com.springbook.biz;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.board.Boardservice;

@Controller //@Component 와 같음(빈등록)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//HomeService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! 웰컴! The client locale is {}.", locale);		
		//service.print();		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );	
		return "home";
	}
	
}
