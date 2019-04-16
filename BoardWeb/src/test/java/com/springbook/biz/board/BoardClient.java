package com.springbook.biz.board;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")
public class BoardClient {

	@Autowired
	Boardservice service;
	
	BoardVO vo;
	
	@Before
	public void init() {
		vo = new BoardVO();
	}
	
	@Test
	public void insertTest() {
		vo.setSeq(27);
		vo.setTitle("트랜잭션");
		vo.setWriter("이순신");
		vo.setContent("트랜잭션 테스트");
		service.insertBoard(vo);
	}
	
	@Ignore //@test
	public void test() {
		vo.setSeq(1);
		assertEquals(service.getBoard(vo).getWriter(), "3");
	}
	
	@Ignore //@test
	public void deleteTest() {
		vo.setSeq(10);
		service.deleteBoard(vo);
	}
}
