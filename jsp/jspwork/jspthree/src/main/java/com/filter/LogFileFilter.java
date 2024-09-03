package com.filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(
//		filterName = "Filter02_2", 
//		urlPatterns = { "/18_01_filter02_process.jsp" }, 
//		initParams = { 
//				@WebInitParam(name = "filename", value = "monitor.log")
//		})
public class LogFileFilter implements Filter {
	PrintWriter writer;
//	FileWriter writer;
	String filename; // null => "moniter.log"
	String realpath = "C:\\log\\";

	/*	FilterConfig fConfig => n : "filename / v : "moniter.log"
	 * */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter02_2 초기화...");
		File f = new File(realpath);
		if (!f.exists())
			f.mkdirs();

		filename = fConfig.getInitParameter("filename");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Filter02_2 doFilter()...");
		if (filename == null)
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		try {
			writer = new PrintWriter(new FileWriter(realpath + filename, true), true);
			// FileWriter : 파일을 출력해주는 클래스. realpath 경로에 filename 파일을 추가.
//			writer = new FileWriter(realpath + filename, true);
		} catch (IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}

		// writer.write : flush() 또는 close()를 이용해야 출력됨.
		writer.write("현재일시 : " + getCurrentTime() + "\n");
		String clientAddr = request.getRemoteAddr();
		writer.write("클라이언트 주소 : " + clientAddr + "\n");
		String contentType = response.getContentType();
		writer.write("문서의 콘텐츠 유형 : " + contentType + "\n");
		writer.write("----------------------------------------\n");

		// 다음 필터가 있는 경우, 해당 필터에 요청,응답 객체 전달. 다음 필터가 없는 경우, 최종 목적지인 url에 전달
		chain.doFilter(request, response); 

//		writer.printf("현재일시 : %s %n", getCurrentTime());
		clientAddr = request.getRemoteAddr();
//		writer.printf("클라이언트 주소 : %s %n", clientAddr());
		contentType = response.getContentType();
//		writer.printf("문서의 콘텐츠 유형 : " + contentType + "\n");
//		writer.printf("----------------------------------------\n");

		writer.close();

	}

	public void destroy() {
		try {
			writer.write("destory() 메소드 호출. filter 객체해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
