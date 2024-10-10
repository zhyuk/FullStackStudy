package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;

@Service
@Aspect
public class BeforeAdvice {

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
//	@Before("allPointcut()") // 옵션이 1개일 경우, 옵션명 생략 시 pointcut으로 인식함.
//	@Before("execution(* com.springbook.biz..*Impl.*(..))")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전처리] " + method + "() 메소드 args 정보 : " + args[0].toString());
	}
	
//	@Before("PointcutCommon.allPointcut()")
//	public void beforeLog(JoinPoint jp) {
//		String method = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
//		
//		System.out.println("[사전처리] " + method + "() 메소드 args 정보 : " + args[0].toString());
//	}
}
