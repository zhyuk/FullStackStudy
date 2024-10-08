package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");

		BoardVO vo = new BoardVO();
		vo.setTitle("JdbcTemplate 테스트");
		vo.setWriter("홍길동");
		vo.setContent("JdbcTemplate 테스트");

		boardService.insertBoard(vo);

		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("-----> " + board.toString());
		}
		
		System.out.println("시스템 종료");

		container.close();

	}

}
