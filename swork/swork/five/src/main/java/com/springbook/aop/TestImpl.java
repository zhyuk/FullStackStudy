package com.springbook.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestImpl {
	@Autowired
	private TestDAO td;
	
	public int getNum() {
		return td.getNum();
	}
	
	public void intNum(int no) {
		td.intNum(no);
	}
	
	// Log4jAdvice => printLogging (공통로직 먼저 실행)
	public void setNum(String str, int no) { // "한글창제", 1446
		td.setNum(str, no);
	}
}
