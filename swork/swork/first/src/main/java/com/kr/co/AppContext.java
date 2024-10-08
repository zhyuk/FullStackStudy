package com.kr.co;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {

	/* <bean id="stv" class="com.kr.co.Samsung" init-method="initSamsung"/> */
	@Bean(initMethod = "initSamsung")
	public Samsung stv() {
		Samsung s = new Samsung();
		return s;
	}
	
	/* <bean id="greeter" class="com.kr.co.Greeter"/> */
//	@Bean
//	public Greeter greeter() {
//		Greeter g = new Greeter("0");
//		g.setFormat("%s, 안녕하세요!");
//		return g;
//	}
	
	@Bean @Scope("prototype")
	public Greeter greeter() {
		Greeter g = new Greeter("0");
		g.setFormat("%s, 안녕하세요!");
		return g;
	}
	
	@Bean
	public Greeter greeter1() {
		Greeter g = new Greeter("1");
		g.setFormat("%s, 시작합니다!");
		return g;
	}
	
//	@Bean @Lazy
//	public Greeter greeter1() {
//		Greeter g = new Greeter("1");
//		g.setFormat("%s, 시작합니다!");
//		return g;
//	}

	/*
	 *  기본 자료형으로는 객체를 생성할 수 없음. 자동으로 Integer 자료형으로 형 변환
	 *  inter => Integer, int , 즉시로딩, 싱글톤
	 */
	@Bean
	public int inter() {
		return 50;
	}
}
