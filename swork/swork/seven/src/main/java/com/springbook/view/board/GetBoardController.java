package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAODBCP;

public class GetBoardController implements Controller {
	@Autowired
	BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		// 1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardVO board = boardService.getBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		// request.setAttribute("board", board)와 동일함.
		mav.setViewName("board/getBoard");
		/* setViewName의 매개변수 안
		 * 1. "redirect:" 이 없는 경우 => forwarding 방식으로 페이지 이동(뷰리졸버 객체 실행)
		 * 2. "redirect:" 이 있는 경우 => redirect 방식으로 페이지 이동(뷰리졸버 객체 실행 X. WEB-INF 경로 안의 페이지들은 접근 안됨)
		 * 
		 */
		
		return mav;
	}

}







