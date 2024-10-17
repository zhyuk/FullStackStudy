package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServeImpl implements UserService{
	@Autowired
	private UserDAOMybatis userDAO;

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public int joinUser(UserVO vo) {
		return userDAO.joinUser(vo);
	}

	@Override
	public List<UserVO> userList(String keyword) {
		return userDAO.userList(keyword);
	}

	@Override
	public UserVO selUser(UserVO vo) {
		return userDAO.selUser(vo);
	}

	@Override
	public int delUser(UserVO vo) {
		return userDAO.delUser(vo);
	}

	@Override
	public int updateUser(UserVO vo) {
		return userDAO.updateUser(vo);
	}


}
