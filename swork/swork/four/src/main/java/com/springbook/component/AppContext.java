package com.springbook.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springbook.component")
public class AppContext {

	@Bean
	public Lg tv() {
		System.out.println("tv 메소드 실행하여 생성");
		return new Lg();
	}

	@Bean
	public Samsung stv() {
		System.out.println("stv 메소드 실행하여 생성");
		return new Samsung();
	}

	@Bean
	public int price() {
		System.out.println("price 메소드 실행하여 생성");
		return 500000;
	}
}
