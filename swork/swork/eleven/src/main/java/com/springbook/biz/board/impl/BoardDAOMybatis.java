package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	/*
	 * insert문 => insert메소드사용 insert("맵퍼객체명.쿼리객체명", vo클래스객체);
	 * delete문 => delete메소드사용 delete("맵퍼객체명.쿼리객체명", vo클래스객체);
	 * update문 => update메소드사용 update("맵퍼객체명.쿼리객체명", vo클래스객체);
	 * select 1줄 => selectOne("맵퍼객체명.쿼리객체명", vo클래스객체);
	 * select 여러 줄 => selectList("맵퍼객체명.쿼리객체명", vo클래스객체);
	 * */

	// CRUD 기능의 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>mybatis insertBoard() 기능처리");
		/*
		 * INSERT INTO BOARD(TITLE, WRITER, CONTENT, FILENAME)
		VALUES(#{title},#{writer},#{content},#{filename})
		"mybatis 테스트", "홍길동" , "mybatis테스트 내용입니다.", "abc.jpg"
		 * */
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===>mybatis로 updateBoard() 기능처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>mybatis로 deleteBoard() 기능처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	// 글상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>mybatis로 getBoard() 기능처리");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	// 글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>mybatis로 getBoardList() 기능처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}

}

