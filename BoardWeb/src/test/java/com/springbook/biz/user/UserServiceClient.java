package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		//패키지 경로에있는 모든 어노테이션(componet 같은거)를 객체로 생성하여 컨테이너에 담는다 - 즉시로딩
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		Userservice service = container.getBean(Userservice.class);
		UserVO vo = new UserVO();
		vo.setId("user1");
		vo.setPassword("user1");

		UserVO user = service.getUser(vo);
		if (user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}
	}
}
