package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		Boardservice service = (Boardservice)container.getBean("boardService");
		//Boardservice service2 =container.getBean(Boardservice.class); //방법이 두가지인것
		
		BoardVO vo = new BoardVO();
		vo.setContent("임시내용");
		vo.setWriter("홍길동");
		vo.setTitle("apo around 테스트");
		service.insertBoard(vo);
		
		List<BoardVO> list = service.getBoardList(null);
		for(BoardVO board : list) {
			System.out.println(board.getSeq() + " : " + board.getTitle());
		}
	}
}
