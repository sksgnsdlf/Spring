package com.springbook.biz.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")
public class UserClient {

	@Autowired
	Userservice service;
	
	UserVO vo;
	@Test
	public void test() {
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		assertNotNull(service.getUser(vo));
	}
}
