package com.springbook.biz.common;

public class BeforeAdvice {
	
	public void beforeLog() {
		System.out.println("[before시점] 비즈니스 로직 수행 전 동작");
	}
}
