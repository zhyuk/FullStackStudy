package com.springbook.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component @Scope("prototype") @Lazy
public class Lg implements TV {

	public Lg() {
		System.out.println("===> LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("===> Lg 전원 켜기");
	}

	@Override
	public void powerOff() {
		System.out.println("===> Lg 전원 끄기");
	}

	@Override
	public void volumnUp() {
		System.out.println("===> Lg 볼륨 올리기");
	}

	@Override
	public void volumnDown() {
		System.out.println("===> Lg 볼륨 낮추기");
	}
	
}
