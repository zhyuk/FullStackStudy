package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAODBCP {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public final String USER_LOGIN = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	public UserVO login(UserVO vo){
		System.out.println("getJdbcTemplate() getUser메소드 실행");
		Object[] args = {vo.getId(), vo.getPassword()};
		
		try {
			return jdbcTemplate.queryForObject(USER_LOGIN, new UserRowMapper(), args);
//		}catch(EmptyResultDataAccessException e) {
		}catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	
	public final String USER_LIST ="SELECT * FROM USERS ORDER BY ID " ;
	public List<UserVO> getUserList(){
		System.out.println("jdbcTemplate selectList메소드 실행");
		try {
			return jdbcTemplate.query(USER_LIST, new UserRowMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ? , NAME =?, ROLE = ? WHERE ID = ?";
	public void userUpdate(UserVO vo) {
		//UPDATE USERS SET PASSWORD = ? , NAME =?, ROLE = ? WHERE ID = ?
		System.out.println("jdbcTemplate updateUser메소드 실행");
		Object[] args = { vo.getPassword(), vo.getName(), vo.getRole(), vo.getId() };
		jdbcTemplate.update(USER_UPDATE, args);
	}
	
	public final String USER_INSERT = "INSERT INTO USERS VALUES (?, ? ,?, ?)";
	public void userInsert(UserVO vo) {
		System.out.println("jdbcTemplate insertUser메소드 실행");
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		jdbcTemplate.update(USER_INSERT, args);
	}
	
	public final String USER_DELETE = "DELETE FROM USERS WHERE ID = ? AND PASSWORD = ?";
	public void userDelete(UserVO vo) {
		System.out.println("jdbcTemplate deleteUser메소드 실행");
		jdbcTemplate.update(USER_DELETE, vo.getId());
	}
}
