package com.kr.co;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		// AnnotationConfigApplicationContext 어노테이션으로 설정한 스프링 빈 설정파일 (자바 설정) 정보를 읽어오는 클래스
		// AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Class.forName("com.kr.co.AppContext"));
		
//		Greeter g = (Greeter)ctx.getBean("greeter");
		Greeter g = ctx.getBean("greeter", Greeter.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class); 
		
		String msg = g.greet("스프링");
		System.out.println(msg); // "스프링, 안녕하세요!"
		
		String msg1 = g1.greet("스프링1");
		System.out.println(msg1); // "스프링1, 안녕하세요!"
		System.out.println(msg); // "스프링, 안녕하세요!"
		
		/* Greeter 객체의 scope 속성이 prototype일 경우, g.getStr()과 g1.getStr()의 값이 다름.
		 * => 값을 독립적으로 사용해야한다면 scope 속성을 prototype으로 설정
		 *  */
		System.out.println("g.getStr() : " + g.getStr()); 
		System.out.println("g1.getStr() : " + g1.getStr());
		
		Greeter s1 = ctx.getBean("greeter1", Greeter.class);
		msg = s1.greet("스프링");
		System.out.println(msg);
		
		int i = ctx.getBean("inter", Integer.class);
		System.out.println("i의 값은 : " + i);
		
		System.out.println("g: " + g);
		System.out.println("g1: " + g1);
		System.out.println("s1: " + s1);
		
		/* Greeter 객체의 scope 속성을 prototype으로 설정하면 false 출력. 미 기술 또는 singleton 설정 시 true 출력*/
		System.out.println("g == g1: " + (g == g1));
		System.out.println("g == s1: " + (g == s1));
		
		TV tv = (TV)ctx.getBean("stv");
		tv.powerOn();
		ctx.close();
	}

}
