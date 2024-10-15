package com.springbook.biz.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.BoardVO;

public class BoardRowMapper  implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
//		board.setRegdate(rs.getDate("regdate"));
		board.setRegdate(rs.getString("regdate"));
		board.setCnt(rs.getInt("cnt"));
		
		//######## 로직 추가 ########//
		board.setFilename(rs.getString("filename"));
		
		return board;
	}

}