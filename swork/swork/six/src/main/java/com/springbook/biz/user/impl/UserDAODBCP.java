package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springbook.biz.user.UserVO;

public class UserDAODBCP {

	private final String USER_LOGIN = "select * from users where id = ? and password = ?";
	private final String USER_LIST = "select * from users order by id";
	private final String USER_INSERT = "insert into users values (?, ?, ?, ?)";
	private final String USER_UPDATE = "update users set password = ? , name = ?, role = ? where id = ?";
	private final String USER_DELETE = "delete from users where id = ? and password = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 로그인
	public UserVO loginUser(UserVO vo) {
		System.out.println("user의 DAO loginUser실행");
		try {
			return jdbcTemplate.queryForObject(USER_LOGIN, new UserRowMapper());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}

	// 회원목록 조회
	public List<UserVO> getUserList() {
		System.out.println("===> JDBC로 getUserList() 기능 처리");
		try {
			return jdbcTemplate.query(USER_LIST, new UserRowMapper());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}

	// 회원가입
	public int insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		return jdbcTemplate.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());

	}

	// 회원정보 수정
	public int updateUser(UserVO vo) {
		System.out.println("===> JDBC로 updateUser() 기능 처리");
		return jdbcTemplate.update(USER_UPDATE, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());

	}

	// 회원정보 삭제
	public int deleteUser(UserVO vo) {
		System.out.println("===> JDBC로 deleteUser() 기능 처리");
		return jdbcTemplate.update(USER_DELETE, vo.getId(), vo.getPassword());

	}
}
