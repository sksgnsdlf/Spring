package com.springbook.biz.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.Boardservice;

@Controller
public class BoardController {
	@Autowired
	Boardservice service;

	//목록조회
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("list",service.getBoardList(null));
		return "board";
	}
	
	// 등록폼
	@RequestMapping("/boardInsertForm")
	public String boardInsertForm() {
		return "boardInsert";

	}
	
	//등록처리
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) {
		service.insertBoard(vo);
		return "redirect:boardList";
	}
}
