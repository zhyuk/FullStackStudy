package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;

@Repository
public class BoardDAODBCP {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// sql명령어들
	// BOARD_INSERT 쿼리문 수정 (filename)
	private final String BOARD_INSERT = "insert into board(title, writer, content, filename) values( ?, ?, ?, ?)";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_LIST_T = "select * from board where title like CONCAT('%',?,'%') order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like CONCAT('%',?,'%') order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 insertBoard() 기능처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getFilename());
	}

	// 글상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoard() 기능처리");
		Object[] args = { vo.getSeq() };
		try {
			return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// 글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoardList() 기능처리");

		Object[] args = { vo.getSearchKeyword() };
		if (vo.getSearchCondition() != null) {
			if (vo.getSearchCondition().equals("TITLE")) {
				System.out.println("TITLE: " + vo.getSearchKeyword());
				return jdbcTemplate.query(BOARD_LIST_T, new BoardRowMapper(), args);
			} else if (vo.getSearchCondition().equals("CONTENT")) {
				System.out.println("CONTENT: " + vo.getSearchKeyword());
				return jdbcTemplate.query(BOARD_LIST_C, new BoardRowMapper(), args);
			}
		} else {
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}
		return null;
	}

}