package com.springbook.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.springbook.view")
@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleException(ArithmeticException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/error/errorArithmetic.jsp");
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleException(NullPointerException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/error/errorNullPointer.jsp");
		return mav;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView handleException(IllegalArgumentException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/error/errorException.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/error/errorException.jsp");
		return mav;
	}
	
}
