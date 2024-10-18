package com.springbook.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/join.do")
	public String join(UserVO vo, Model model) {
		userService.joinUser(vo);
		model.addAttribute("result", 1);
		return "user/login";
	}
	
	@RequestMapping("/joinForm.do")
	public String joinForm(UserVO vo) {
		return "user/joinForm";
	}
	
	@RequestMapping("/selUser.do")
	public String selUser(UserVO vo, Model model) {
		model.addAttribute("user", userService.selUser(vo));
		return "user/selUser";
	}
	
	@RequestMapping("/delUser.do")
	public String delUser(UserVO vo, HttpSession session) {
		userService.delUser(vo);
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(UserVO vo, HttpSession session) {
		session.setAttribute("userName", vo.getName());
		userService.updateUser(vo);
		return "redirect:selUser.do?id="+vo.getId();
	}
	
	@RequestMapping("/userList.do")
	public String getUserList( @RequestParam(value="searchKeyword", required=false) String keyword, Model model ) {
		model.addAttribute("userList", userService.getUserList(keyword));
		return "user/userList";
	}
	
	@GetMapping(value = "/login.do")
	public String loginView(UserVO vo) {
		vo.setId("admin");
		vo.setPassword("1111");
		return "user/login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session, Model model) {

		if (userService.getUser(vo) != null) {
			session.setAttribute("userId", userService.getUser(vo).getId());
			session.setAttribute("userName", userService.getUser(vo).getName());
			session.setAttribute("userRole", userService.getUser(vo).getRole());
			return "redirect:getBoardList.do";
		} else {
			model.addAttribute("error", "err");
			return "user/login";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "user/login";
	}
}
