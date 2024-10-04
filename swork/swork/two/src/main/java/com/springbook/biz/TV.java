package com.springbook.biz;

public interface TV {
	// 인터페이스는 접근제어자, 기타제어자 생략 가능. 생략 시 public abstract가 기본값. 반드시 상속받은 클래스에서 오버라이딩 해줘야함.
	void powerOn();
	void powerOff();
	public void volumnUp();
	public void volumnDown();
}
