package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAODBCP dao;	
	
	@Override
	public UserVO login(UserVO vo) {
		return dao.login(vo);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public void userUpdate(UserVO vo) {
		dao.userUpdate(vo);
	}

	@Override
	public void userInsert(UserVO vo) {
		dao.userInsert(vo) ;
	}

	@Override
	public void userDelete(UserVO vo) {
		dao.userDelete(vo);
	}

}
