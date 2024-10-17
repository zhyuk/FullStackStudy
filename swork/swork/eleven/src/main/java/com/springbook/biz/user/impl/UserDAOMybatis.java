package com.springbook.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired
	SqlSessionTemplate mybatis;
	
	public UserVO getUser(UserVO vo) {
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	public int joinUser(UserVO vo) {
		return mybatis.insert("UserDAO.joinUser", vo);
	}
	
	public int delUser(UserVO vo) {
		return mybatis.delete("UserDAO.delUser", vo);
	}
	
	public int updateUser(UserVO vo) {
		return mybatis.update("UserDAO.updateUser", vo);
	}
	
	public UserVO selUser(UserVO vo) {
		return (UserVO) mybatis.selectOne("UserDAO.selUser", vo);
	}
	
	
	public List<UserVO> userList(String keyword){
		return mybatis.selectList("UserDAO.userList", keyword);
		
	}
}
