package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		// GenericXmlApplicationContext() : classpath: 정보까지 갖고있음. * classpath: -> src/main/resources/
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목2");
		vo.setWriter("홍길동2");
		vo.setContent("임시내용2.....");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("-----> " + board);
			// toString() 객체를 출력할 때, 출력할 값이 없으면 자동으로 실행되는 특수 케이스의 메소드.
		}
		
		container.close();
		
	}

}
