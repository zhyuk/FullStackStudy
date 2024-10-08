package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository
public class UserDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String USER_LOGIN = "select * from users where id = ? and password = ?";
	private final String USER_LIST = "select * from users order by id";
	private final String USER_INSERT = "insert into users values (?, ?, ?, ?)";
	private final String USER_UPDATE = "update users set password = ? , name = ?, role = ? where id = ?";
	private final String USER_DELETE = "delete from users where id = ? and password = ?";

	// 로그인
	public UserVO loginUser(UserVO vo) {
		System.out.println("user의 DAO loginUser실행");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LOGIN);
			stmt.setString(1, vo.getId()); //"admin"
			stmt.setString(2, vo.getPassword()); //"1111"
			rs = stmt.executeQuery();
			while(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id")); //admin
				user.setPassword(rs.getString("password")); //1111
				user.setName(rs.getString("name")); //관리자
				user.setRole(rs.getString("role")); //Admin
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;
	}

	// 회원목록 조회
	public List<UserVO> getUserList() {
		System.out.println("===> JDBC로 getUserList() 기능 처리");
		List<UserVO> userList = new ArrayList();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	// 회원가입
	public int insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			cnt = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return cnt;
	}
 
	// 회원정보 수정
	public int updateUser(UserVO vo) {
		System.out.println("===> JDBC로 updateUser() 기능 처리");
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.setString(4, vo.getId());
			cnt = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return cnt;
	}

	// 회원정보 삭제
	public int deleteUser(UserVO vo) {
		System.out.println("===> JDBC로 deleteUser() 기능 처리");
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			cnt = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return cnt;
	}
}
