package com.springbook.biz.user.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOSpring extends JdbcDaoSupport {

	private final String USER_LOGIN = "select * from users where id = ? and password = ?";
	private final String USER_LIST = "select * from users order by id";
	private final String USER_INSERT = "insert into users values (?, ?, ?, ?)";
	private final String USER_UPDATE = "update users set password = ? , name = ?, role = ? where id = ?";
	private final String USER_DELETE = "delete from users where id = ? and password = ?";

	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	// 로그인
	public UserVO loginUser(UserVO vo) {
		System.out.println("user의 DAO loginUser실행");
		try {
			return getJdbcTemplate().queryForObject(USER_LOGIN, new UserRowMapper());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}

	// 회원목록 조회
	public List<UserVO> getUserList() {
		System.out.println("===> JDBC로 getUserList() 기능 처리");
		try {
			return getJdbcTemplate().query(USER_LIST, new UserRowMapper());
		} catch (EmptyResultDataAccessException err) {
			return null;
		}
	}

	// 회원가입
	public int insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		return getJdbcTemplate().update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());

	}

	// 회원정보 수정
	public int updateUser(UserVO vo) {
		System.out.println("===> JDBC로 updateUser() 기능 처리");
		return getJdbcTemplate().update(USER_UPDATE, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());

	}

	// 회원정보 삭제
	public int deleteUser(UserVO vo) {
		System.out.println("===> JDBC로 deleteUser() 기능 처리");
		return getJdbcTemplate().update(USER_DELETE, vo.getId(), vo.getPassword());

	}
}
