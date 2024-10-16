package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

//@Component
@Controller
//@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("제목", "TITLE");
		return conditionMap;
	}

	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping(value = "/uploadBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, HttpSession session) {
		if (vo.getWriter().equals(session.getAttribute("userName").toString())) {
			boardService.updateBoard(vo);
			return "getBoardList.do";
		} else {
			return "getBoardList.do?error=1";
		}
	}

	// 글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "WEB-INF/board/getBoard.jsp";
	}

	// 글 목록
//	@RequestMapping(value = "/getBoardList.do")
//	public String getBoardList(BoardVO vo, Model model) {
//		System.out.println("글 목록 검색 처리");
//
//		model.addAttribute("board", boardService.getBoardList(vo));
//		return "WEB-INF/board/getBoardList.jsp";
//	}

	// 글 목록
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardListPost(BoardVO vo,
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
			ModelAndView mav) {
		System.out.println("글 목록 검색 처리: " + condition + ", " + keyword);

		mav.addObject("boardList", boardService.getBoardList(vo, keyword, condition));
		mav.setViewName("WEB-INF/board/getBoardList.jsp");
		return mav;
	}
}
