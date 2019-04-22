package com.springbook.biz.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.Userservice;

@Controller
public class UserController {
	
	@Autowired
	Userservice service;
	
	//유저전체조회
	@RequestMapping("/getUserList")
	public ModelAndView getUserList(ModelAndView mv, UserVO vo) {
		mv.addObject("userList",service.getUserMap(vo));
		mv.setViewName("user/userList");
		return mv;
	}
	
	//로그인 폼
	@RequestMapping(value= {"/loginForm","/login"}, method=RequestMethod.GET)
	public String loginFrom() {
		return "login";
	}
	//로그인 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("user") UserVO vo, 
			HttpServletRequest request,HttpSession session) {
		UserVO user = service.getUser(vo);
		if(user == null )
		return "login";
		else {
			session.setAttribute("userName",user.getName());
			session.setAttribute("id",user.getId());
			session.setAttribute("user",user);
			return "redirect:boardList";
		}
	}
	
	//로그아웃 처리
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션무효화
		return "login";
	}
}
