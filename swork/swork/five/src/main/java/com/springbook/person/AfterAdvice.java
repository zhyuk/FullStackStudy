package com.springbook.person;

public class AfterAdvice {

	public void afterAll() {
		System.out.println("문을 연다.");
		System.out.println("문을 닫는다.");
		System.out.println("불을 켠다.");
	}
}
