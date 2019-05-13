package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("mybatis insert procedure 실행");
		mybatis.insert("BoardDAO.insertBoardProcedure",vo);
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
	
	//페이징카운터수
	public int getBoardCount(BoardVO vo) {
		return mybatis.selectOne("BoardDAO.getBoardCount",vo);
	}
}
