package com.kr.co;

public class Samsung implements TV{
	public Samsung() {
		System.out.println("삼성TV 객체 생성");
	}
	
	public void initSamsung() {
		System.out.println("삼성TV 초기메소드 실행");
	}
	
	@Override
	public void powerOn() {
		System.out.println("삼성 전원 켜기");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 전원 끄기");
	}

	@Override
	public void volumeUp() {
		System.out.println("삼성 볼륨 올리기");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성 볼륨 낮추기");
	}
	
	public void destroySamsung() {
		System.out.println("삼성TV 객체 삭제 전 호출 메소드");
	}
}
