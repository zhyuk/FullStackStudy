package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAODBCP {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//CRUD 기능의 메소드 구현
	//글등록
	private final String BOARD_INSERT = "insert into board(title, writer, content) values(?, ?, ?)";
	public int insertBoard(BoardVO vo) {
		System.out.println("===>Spring jdbcTemplate으로 insertBoard() 기능처리");
		return jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	//글수정
	private final String BOARD_UPDATE = "update board set title =?, content=? where seq=? ";
	public void updateBoard(BoardVO vo) {
		System.out.println("===>Spring jdbcTemplate으로updateBoard() 기능처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	//글삭제
	private final String BOARD_DELETE = "delete from board where seq = ?";
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>Spring jdbcTemplate으로 deleteBoard() 기능처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	//글상세 조회
	private final String BOARD_GET = "select * from board where seq=?";
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>Spring jdbcTemplate으로 getBoard() 기능처리");
		try {
//			Object[] args = {vo.getSeq()};
//			return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);
			return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), vo.getSeq());
		}catch(IncorrectResultSizeDataAccessException err) {
			return null;
		}
	}
	
	//글목록 조회
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	private final String BOARD_LIST_TITLE = "SELECT * FROM BOARD WHERE TITLE like "
											+"CONCAT(CONCAT('%',?),'%') ORDER BY SEQ DESC";
	private final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE "
											+"CONCAT(CONCAT('%',?),'%') ORDER BY SEQ DESC";
	
	public List<BoardVO> getBoardList(BoardVO vo,String keyword,String condition ) {
		System.out.println("===>Spring jdbcTemplate으로 getBoardList() 기능처리");
		try {
			if(condition.equals("TITLE")) {
				return jdbcTemplate.query(BOARD_LIST_TITLE, new BoardRowMapper(), keyword);
			}else if(condition.equals("CONTENT")) {
				return jdbcTemplate.query(BOARD_LIST_CONTENT, new BoardRowMapper(), keyword);
			}else {
				return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
			}
		}catch(EmptyResultDataAccessException err) {
			return null;
		}
	}

}


