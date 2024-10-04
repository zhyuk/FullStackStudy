package com.springbook.setter;

public class Samsung implements TV{
	
	private Speaker speaker;
	private int price;
	
	public Samsung() {
		System.out.println("===> SamsungTV() 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrint() 호출");
		this.price = price;
	}
	
	public int getPrice() {
		System.out.println("===> getPrice() 호출");
		return price;
	}

	@Override
	public void powerOn() {
		System.out.printf("SamsungTV --- 전원을 켠다. (가격: %,d원) \n", price);
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
