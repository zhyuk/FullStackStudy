package com.springbook.biz.common;

public class AfterThrowingAdvice {
	
	public void afterThrowingLog() {
		System.out.println("[after-throwing시점] 비즈니스 로직 수행 중 예외 발생");
	}
}
