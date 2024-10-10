package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {

	// Object robj : 리턴값을 받는 매개변수
	public void afterLog(JoinPoint j, Object robj) {
		/* JoinPoint j => 
		 * // 포인트컷 - after-returning
		 * public UserVO loginUser(UserVO vo) {
		 * 		System.out.println("포인트컷 메소드");
		 * return userDAO.loginUser(vo);
		 * }
		 * */
		
		/* Object robj 
		 * => UserDAO 클래스의 리턴되는 user. 
		 * - Object, UserVO 자료형을 갖고 있음.
		 * 
		 * */
		
		String method = j.getSignature().getName();

		if (robj == null) {
			System.out.println("등록되지 않은 사용자입니다.");
		} else if (robj instanceof UserVO) { // 리턴값이 있는 경우만 True.
			UserVO user = (UserVO) robj;
			if (user.getRole().equals("admin")) {
				System.out.println(user.getName() + "로그인(Admin)");
			}
		}

		System.out.println("[사후처리] " + method + "() 메소드 리턴값: " + robj);
	}
}
