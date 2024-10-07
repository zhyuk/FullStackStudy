package com.springbook.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Samsung implements TV{

	private Speaker speaker;
	private int price;
	
	public Samsung() {
		System.out.println("===> SamsungTV() 객체 생성");
	}
	
	@Autowired
	public void setTwo(Speaker speaker, int price) {
		System.out.println("===> SamsungTV setTwo(speaker, price) 메소드 호출");
		this.speaker = speaker;
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- 전원을 끈다.");
	}

	@Override
	public void volumnUp() {
		speaker.volumnUp();
		System.out.println("SamsungTV --- 소리를 올린다.");
	}

	@Override
	public void volumnDown() {
		speaker.volumnDown();
		System.out.println("SamsungTV --- 소리를 내린다.");
	}
}
