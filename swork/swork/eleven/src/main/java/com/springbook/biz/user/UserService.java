package com.springbook.biz.user;

import java.util.List;

public interface UserService {

	UserVO getUser(UserVO vo);
	
	UserVO selUser(UserVO vo);
	
	int delUser(UserVO vo);
	
	int updateUser(UserVO vo);
	
	List<UserVO> userList(String keyword);
	
	int joinUser(UserVO vo);

}