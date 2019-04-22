package com.springbook.biz.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.Boardservice;
import com.springbook.biz.common.Paging;

@Controller
public class BoardController {
	@Autowired
	Boardservice service;

	//수정폼
	@RequestMapping(value="/boardUpdate/${seq}", method=RequestMethod.GET)
	public String boardUpdateForm(BoardVO vo,
							      @PathVariable Integer seq,
								  Model model) {
		vo.setSeq(seq);
		//단건조회
		model.addAttribute("board",service.getBoard(vo));
		return "boardUpdate"; 
	}
	
	//수정처리
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(BoardVO vo) {
		service.updateBoard(vo);
		return "redirect:boardList";
	}
	
	//삭제처리(단건,다건)
	@RequestMapping("/deleteBoard")
		public String deleteBoard(BoardVO vo) {
			service.deleteBoard(vo);
			return "redirect:boardList";
		}
	
	//목록조회
	@RequestMapping("/boardList")
	public String boardList(Model model, Paging paging, 
			@RequestParam(required=false, 
			defaultValue="TITLE",
			value="searchCondition") String cond,
			@RequestParam(required=false, defaultValue="") String searchKeyword) {
		
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(cond);
		vo.setSearchKeyword(searchKeyword);
		//페이징 처리
		
		//전체 건수
		paging.setTotalRecord(service.getBoardCount(vo));
		
		model.addAttribute("list",service.getBoardList(vo));
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
