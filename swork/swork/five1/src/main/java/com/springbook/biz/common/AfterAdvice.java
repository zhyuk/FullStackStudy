package com.springbook.biz.common;

public class AfterAdvice {
	
	public void finallyLog() {
		System.out.println("[after시점] 비즈니스 로직 수행 후 무조건 동작");
	}
}
