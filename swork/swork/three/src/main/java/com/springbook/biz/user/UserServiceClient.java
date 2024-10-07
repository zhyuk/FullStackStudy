package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardVO;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		UserService userService = (UserService) container.getBean("userService");

		// 로그인
		UserVO userVO = new UserVO();
		userVO.setId("admin");
		userVO.setPassword("1111");
		userVO = userService.loginUser(userVO);
		if (userVO != null)
			System.out.println("로그인 정보 : " + userVO);
		else
			System.out.println("로그인 실패");

		List<UserVO> userList = userService.getUserList(userVO);
		for (UserVO user : userList) {
			System.out.println(user);
		}

		// 회원가입
//		userVO.setId("duly");
//		userVO.setPassword("1111");
//		userVO.setName("둘리");
//		userVO.setRole("User");
//		int result = userService.insertUser(userVO);
//		
//		if (result > 0) {
//			System.out.println("회원가입 성공");
//		} else {
//			System.out.println("회원가입 실패");
//		}
		
		// 회원탈퇴
//		userVO.setId("duly");
//		userVO.setPassword("1111");
//		int result = userService.deleteUser(userVO);
//		
//		if (result > 0) {
//			System.out.println("회원탈퇴 성공");
//		} else {
//			System.out.println("회원탈퇴 실패");
//		}
		
		// 회원수정
		userVO.setPassword("1234");
		userVO.setName("고길동");
		userVO.setRole("Admin");
		userVO.setId("user1");
		int result = userService.updateUser(userVO);
		
		if (result > 0) {
			System.out.println("회원정보 수정 성공");
		} else {
			System.out.println("회원정보 수정 실패");
		}
		container.close();
	}

}
