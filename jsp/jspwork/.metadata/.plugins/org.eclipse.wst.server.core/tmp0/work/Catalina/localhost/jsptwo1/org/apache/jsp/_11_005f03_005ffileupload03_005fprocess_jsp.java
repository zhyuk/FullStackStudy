/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-08-29 09:00:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;

public final class _11_005f03_005ffileupload03_005fprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(7);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write("<!-- \r\n");
      out.write("필요한 패키지들\r\n");
      out.write("import java.io.File;\r\n");
      out.write("import java.io.IOException;\r\n");
      out.write("import java.io.PrintWriter;\r\n");
      out.write("import java.util.Collection;\r\n");
      out.write("import javax.servlet.ServletException;\r\n");
      out.write("import javax.servlet.annotation.MultipartConfig;\r\n");
      out.write("import javax.servlet.annotation.WebServlet;\r\n");
      out.write("import javax.servlet.http.HttpServlet;\r\n");
      out.write("import javax.servlet.http.HttpServletRequest;\r\n");
      out.write("import javax.servlet.http.HttpServletResponse;\r\n");
      out.write("import javax.servlet.http.Part;\r\n");
      out.write(" -->   \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>File Upload</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // 파일전송은 post 방식이므로 인코딩 처리
		
		String path = "C:\\upload";
		File targetDir = new File(path);
		
		// 디렉토리가 없을 경우 생성하기
		if(!targetDir.exists()) targetDir.mkdirs();
		
		// 요청 객체에서 요청 정볼ㄹ 가져옴. HttpServletRequest객체를 사용해야만 한다. jsp에는 내장 객체 있어서 주석처리
// 		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		
		// 파일 쓰기할 객체 만들기  response.getWriter() : out 객체를 의미함.
		PrintWriter writer = response.getWriter();
		
		// 요청 정보의 Content-Type 가져오기 : multipart/form-data ~~~~~
		String contentType = request.getContentType();
		
		// contentType가 null이 아니고, contentType를 소문자로 변환 후 "multipart/"로 시작되는 경우만
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")){
			// getParts()를 통해 Body에 넘어온 데이터들을 각각의 Part로 쪼개어 리턴
			Collection<Part> parts = request.getParts();
			
			for(Part part : parts){
				// Content를 가진 경우 : String이 아닌 경우. 
				String contType = part.getContentType();
				writer.println("파라미터 명 : " + part.getName() + "<br>");
				writer.println("contentType : " + contType + "<br>");
				writer.println("파일 크기 : " + part.getSize() + "Byte<br>");
				
				// 파일인 경우만 끌고 옴
				if(part.getHeader("Content-Disposition").contains("filename=")){
					String fileName = part.getSubmittedFileName();
					
					if(part.getSize() > 0) {
						writer.print("업로드 파일명 : " + fileName + "<br>");
						writer.print("File.separator: " + File.separator + "<br><br>");
						
						// 실제 파일이 저장되는 시점. // 새파일이름을 설정하지 않으면 기존 파일로 덮어쓰기 됨.
						part.write(path + File.separator + fileName);
						part.delete();
						// 임시저장된 파일 데이터를 제거함
						// HTTP요청이 처리되고 나면 자동으로 제거되지만 그 전에 메모리나 디스크 자원을 아끼기 위해 수동으로 제거해준다.
					}
				} else { // 그 외 전달된 파라미터들
					String formValue = request.getParameter(part.getName());
					writer.println("name: " + part.getName() + ", value: " + formValue + "<br>");
				}
			} // for문 종료 중괄호
			writer.println("<hr><p>업로드 완료</p>");	
		} else {
			writer.println("<h1>enctype이 multipart/form-data가 아닙니다.</h1>");
		}
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
