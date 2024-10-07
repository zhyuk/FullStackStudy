package com.springbook.biz.user;

import java.util.List;

public interface UserService {

	public UserVO loginUser(UserVO vo);
	public List<UserVO> getUserList(UserVO vo);
	public int insertUser(UserVO vo);
	public int updateUser(UserVO vo);
	public int deleteUser(UserVO vo);
}
