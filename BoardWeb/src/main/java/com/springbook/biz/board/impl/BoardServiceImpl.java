package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.Boardservice;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements Boardservice {

	//@Autowired BoardDAO dao;
	@Autowired BoardDAOSpring dao;
	
	@Override
	public void insertBoard(BoardVO vo) {
	//around AOP 트랜잭션 처리
		dao.insertBoard(vo); 
	//commit
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
			dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
			dao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.getBoardList(vo);
	}

}
