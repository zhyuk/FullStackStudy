package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.board.BoardVO;

public class BeforeAdvice {
	
	public void beforeLog(JoinPoint jp) {
//		JoinPoint : 포인트컷 메소드의 정보를 담는 클래스
//		getSignature() : 포인트컷 메소드의 메소드명, 매개변수 등의 정보를 가져옴.
//		getName() : getSignature() 메소드가 가진 정보 중 메소드 명만 가져옴.
//		getArgs() : getSignature() 메소드가 가진 정보 중 매개변수 정보만 가져옴.
		
		/* jp =>
		 * @Override
		 * public void insertBoard(BoardVO vo) {
		 * boardDAO.insertBoard(vo);
		 * }
		 * */

		String method = jp.getSignature().getName();
		// Object 자료형의 배열로 가져오는 이유 : 매개변수의 자료형이 다 다를 수 있기 때문에 모두 담을 수 있는 자료형으로
		Object[] args = jp.getArgs();
		
		System.out.print("args.length: ");
		System.out.println(args.length);
		
		BoardVO b = (BoardVO) args[0];
		System.out.println("b.getSeq(): " + b.getSeq());
		System.out.println("b.getTitle(): " + b.getTitle());
		
		System.out.println("[사전처리] "+ method + "() 메소드 args 정보 : " + args[0].toString());
	}
}
