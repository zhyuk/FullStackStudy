package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		/* 3. udao => 자료형 : UserDAO, 싱글톤, 즉시로딩
		 * 4. userService => 자료형 : UserServiceImpl, UserService, 싱글톤, 즉시로딩
		 * =>@Autowired UserDAO userDAO; => 3번 객체 자동주입
		 * */
		UserService userService = (UserService) container.getBean("userService");

		UserVO vo = new UserVO();
		vo.setId("admin");
		vo.setPassword("1111");

		UserVO user = userService.loginUser(vo);
		if (user != null)
			System.out.println(user.getName() + "님 환영합니다. ");
		else
			System.out.println("로그인 실패");

//		List<UserVO> ulist = userService.getUserList(vo);
//		for (UserVO uvo : ulist) {
//			System.out.println("---> " + uvo);
//		}

		container.close();
	}

}
