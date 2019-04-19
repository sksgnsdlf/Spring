package com.springbook.biz.board;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml",
								   "classpath:config/context-mapper.xml"})
public class BoardClient {

	@Autowired
	Boardservice service;
	
	BoardVO vo;
	
	@Before
	public void init() {
		vo = new BoardVO();
	}
	
	@Ignore //@test
	public void updateTest() {
		vo.setSeq(1);
		vo.setCnt(10);
		service.updateBoard(vo);
	}
	
	@Ignore //@test
	public void getBoardList() {
	//	vo.setSearchCondition("TITLE");
	//	vo.setSearchKeyword("임시제목");
		service.getBoardList(vo);
		List<BoardVO> list = service.getBoardList(vo);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	@Ignore //Ignore 막아주는개념 //@Test 
	public void insertTest() {
		vo.setSeq(27);
		vo.setTitle("트랜잭션");
		vo.setWriter("이순신");
		vo.setContent("트랜잭션 테스트");
		service.insertBoard(vo);
	}
	
	@Ignore //@Test
	public void test() {
		vo.setSeq(1);
		assertEquals(service.getBoard(vo).getWriter(), "3");
	}
	
	@Test
	public void deleteTest() {
//		vo.setSeq(10);
//		service.deleteBoard(vo);
		String[] seqs = {"11","12","13"};
		vo.setSeqs(seqs);
		service.deleteBoard(vo);
	}
}
