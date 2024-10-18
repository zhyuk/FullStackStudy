package com.my.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pathvar") /* pathvar객체만 */
public class HomeController {

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		return "intercept/home";
	}
	
	@RequestMapping
	public String test() {
		return "redirect:newFile.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "intercept/login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginAction(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		String userId = req.getParameter("userId");

		session.setAttribute("userId", userId);
		return "redirect:/main.do";
	}

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String main() {
		return "intercept/main";
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		return "intercept/join";
	}

	// Pathvariable 예제 /pathvar/page/one
	@RequestMapping("/page/{var}") // var = one
	public String page(@PathVariable("var") String v) {
		String returnUrl = "";

		if (v.equals("one")) {
			returnUrl = "pathvar/page1";
		} else if (v.equals("two")) {
			returnUrl = "pagevar/page2";
		}

		return returnUrl;
	}

	/* GET 방식 컨트롤러 @param key1 @param key2 */
	/*
	 * uri => http://localhost:8090/pathvar/byGet?key1=1111&key2=zzz url패턴의 범위 : -
	 * 인터넷프로토콜://서버이름(호스트명):포트번호[/컨텍스트패스]/경로...까지 **쿼리스트링은 url패턴에 포함되지 않는다.
	 * 인터넷프로토콜://서버이름(호스트명):포트번호[/컨텍스트패스]/경로...?쿼리스트링
	 */

	@RequestMapping("/byGet")
	public String resultByGet(@RequestParam(value = "key1") String k1, @RequestParam(value = "key2") String k2,
			Model model) {
		model.addAttribute("key1", k1);
		model.addAttribute("key2", k2);
		return "pathvar/path";
	}

	/* Pathvariable 방식 컨트롤러 @param key1, @param key2 */
	@RequestMapping("/byPath/{key1}/{key2}")
	public String resultByPath(@PathVariable String key1, @PathVariable String key2) {
		return "pathvar/path";
	}

	/* Pathvariable 방식 컨트롤러 @param key1, @param key2 */
	@RequestMapping("/byPath/key1/{key1}/key2/{key2}")
	public String resultByPath2(@PathVariable String key1, @PathVariable String key2) {
		return "pathvar/path";
	}
}
