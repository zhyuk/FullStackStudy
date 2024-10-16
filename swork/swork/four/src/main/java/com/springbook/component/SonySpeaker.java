package com.springbook.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("sony")
@Primary
public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체 생성");
	}

	public void volumnUp() {
		System.out.println("SonySpeaker --- 소리를 올린다.");
	}

	public void volumnDown() {
		System.out.println("SonySpeaker --- 소리를 내린다.");
	}
}
