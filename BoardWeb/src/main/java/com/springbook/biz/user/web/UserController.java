package com.springbook.biz.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.Userservice;

@Controller
public class UserController {
	
	@Autowired
	Userservice service;
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginFrom() {
		return "login";
	}
	//로그인 처리
	@RequestMapping("/login")
	public String login(UserVO vo) {
		if(service.getUser(vo) == null )
		return "login";
		else 
			return "redirect:boardList";
	}
}
