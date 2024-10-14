package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class LoginController implements Controller {
	@Autowired
	UserService userService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(); 
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserVO user = userService.login(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user!=null){
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			mav.setViewName("redirect:getBoardList.do");
		}else {
			mav.setViewName("redirect:login.jsp?error=1");
		}
		return mav;
	}

}


