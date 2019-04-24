package com.springbook.biz.board.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.Boardservice;
import com.springbook.biz.common.Paging;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	Boardservice service;

	@ModelAttribute("condMap")			//model.addAttribute(, conditionMap);
	public Map<String, String> searchConditionMap(){
		HashMap<String,String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT");
		conditionMap.put("작성자","WRITER");
		return conditionMap;
	}
	
	//수정폼
	@RequestMapping(value="/boardUpdate/{seq}", method=RequestMethod.GET)
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
	public String boardUpdate(@ModelAttribute("board")BoardVO vo,
							  SessionStatus st) {
		System.out.println("=================" + vo);
		service.updateBoard(vo);
		st.setComplete(); //세션값 전부 clear
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
							@RequestParam(required=false, defaultValue="TITLE", value="searchCondition") String cond, 
							@RequestParam(required=false) String searchKeyword) { // @RequestParam의 required default값은 true 즉, 반드시 값이 있어야 함(파라미터 값이 null일때 실행 불가능)
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(cond);
		vo.setSearchKeyword(searchKeyword);
		
		paging.setPageUnit(5);
		// 페이지번호 파라미터
		if( paging.getPage() == 0) {
			paging.setPage(1); 
		}
		
		// 시작/마지막 레코드 번호
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		
		// 전체 건수
		paging.setTotalRecord(service.getBoardCount(vo));
				
		model.addAttribute("paging", paging );
		model.addAttribute("list", service.getBoardList(vo));
	    return "board";
	}
	
	// 등록폼
	@RequestMapping("/boardInsertForm")
	public String boardInsertForm() {
		return "boardInsert";

	}
	
	//등록처리
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo, MultipartFile uploadFile) throws IllegalStateException, IOException {
		if(! uploadFile.isEmpty() && uploadFile.getSize() > 0 ) {
			String filename = uploadFile.getOriginalFilename();
			long filesize = uploadFile.getSize();
			uploadFile.transferTo(new File("d:\\upload",filename));
			vo.setFilename(filename);
			System.out.println("업로드 파일" + filename +" : " +filesize);
		}
		service.insertBoard(vo);
		return "redirect:boardList";
	}
	
	/**
	 * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다.
	 *
	 * @param commandMap
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/FileDown")
	public void cvplFileDownload(@RequestParam Map<String, Object> commandMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String seq = (String) commandMap.get("seq");


		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(Integer.parseInt(seq));
		BoardVO result = service.getBoard(boardVO);

		File uFile = new File("d:/upload/", result.getFilename());
		long fSize = uFile.length();

		if (fSize > 0) {
			String mimetype = "application/x-msdownload";

			response.setContentType(mimetype);
			setDisposition(result.getFilename(), request, response);

			BufferedInputStream in = null;
			BufferedOutputStream out = null;

			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());

				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				in.close();
				out.close();
			}

		} else {
			response.setContentType("application/x-msdownload");

			PrintWriter printwriter = response.getWriter();
			
			printwriter.println("<html>");
			printwriter.println("<br><br><br><h2>Could not get file name:<br>" + result.getFilename() + "</h2>");
			printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("<br><br><br>&copy; webAccess");
			printwriter.println("</html>");
			
			printwriter.flush();
			printwriter.close();
		}
	}
	
	/**
	 * Disposition 지정하기.
	 *
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);

		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;

		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}

		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}
	
	/**
	 * 브라우저 구분 얻기.
	 *
	 * @param request
	 * @return
	 */
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}
}
