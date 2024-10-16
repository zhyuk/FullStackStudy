/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-16 06:05:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ajaxFile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
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
      out.write("	<!DOCTYPE html>\r\n");
      out.write("	<html>\r\n");
      out.write("\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"UTF-8\">\r\n");
      out.write("		<title>Ajax Test</title>\r\n");
      out.write("		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js\"></script>\r\n");
      out.write("		<style>\r\n");
      out.write("			table {\r\n");
      out.write("				border-collapse: collapse;\r\n");
      out.write("				border: 1px solid #333;\r\n");
      out.write("				width: 60%;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			th,\r\n");
      out.write("			td {\r\n");
      out.write("				border: 1px solid #333;\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			th {\r\n");
      out.write("				background-color: #aaa;\r\n");
      out.write("				color: #fff;\r\n");
      out.write("			}\r\n");
      out.write("		</style>\r\n");
      out.write("\r\n");
      out.write("		<script>\r\n");
      out.write("			//####################스크립트 작성하기####################//\r\n");
      out.write("			function getBoard1(val) {\r\n");
      out.write("				var objParams = {\r\n");
      out.write("					seq: val\r\n");
      out.write("				};\r\n");
      out.write("				var values = []; //ArrayList 값을 받을 변수 선언\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: \"reqAjax1.do\",\r\n");
      out.write("					type: \"POST\",\r\n");
      out.write("					data: objParams,\r\n");
      out.write("					cache: false,\r\n");
      out.write("					success: function (data) {\r\n");
      out.write("						$(\"#demo1\").hide();\r\n");
      out.write("						console.log(data);\r\n");
      out.write("						console.log(\"성공\");\r\n");
      out.write("						let str = \"\";\r\n");
      out.write("						$.each(data, function (i, o) {\r\n");
      out.write("							str += \"[\" + i + \"] {\" + o.seq + \",\" + o.title + \",\"\r\n");
      out.write("								+ o.writer + \"}<br>\";\r\n");
      out.write("						});\r\n");
      out.write("						$(\"#demo1_con\").html(str);\r\n");
      out.write("					},\r\n");
      out.write("					error: function (request, status) {\r\n");
      out.write("						alert(\"오류가 발생했습니다\");\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			function getBoard2(val) {\r\n");
      out.write("				var objParams = {\r\n");
      out.write("					seq: val\r\n");
      out.write("				};\r\n");
      out.write("				var values = [];\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					method: \"POST\",\r\n");
      out.write("					url: \"reqAjax2.do\",\r\n");
      out.write("					data: objParams,\r\n");
      out.write("					cache: false,\r\n");
      out.write("					success: function (data) {\r\n");
      out.write("						console.log(\"data: \" + data);\r\n");
      out.write("						if (data.code == \"OK\") { //controller에서 넘겨준 성공여부 코드\r\n");
      out.write("							values = data.boardList; //java에서 정의한 ArrayList명을 적어준다.\r\n");
      out.write("							$.each(values, function (index, value) {\r\n");
      out.write("								console.log(index + \" : \" + value.title);\r\n");
      out.write("								$(\"#status\").append(\r\n");
      out.write("									\"<tr><td>\" + value.seq + \"</td><td>\"\r\n");
      out.write("									+ value.title + \"</td><td>\"\r\n");
      out.write("									+ value.writer + \"</td></tr>\");\r\n");
      out.write("							});\r\n");
      out.write("							$(\"#demo2\").hide();\r\n");
      out.write("							console.log(\"성공\");\r\n");
      out.write("						} else {\r\n");
      out.write("							console.log(\"실패\");\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					error: function (request, status) {\r\n");
      out.write("						alert(\"오류가 발생했습니다\");\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("			function ajaxTest() {\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: \"ajaxTest.do\",\r\n");
      out.write("					type: \"post\",\r\n");
      out.write("					contentType: 'application/json; charset=utf-8', // 보내는 데이터를 json형식으로 변환하여 전송.\r\n");
      out.write("// 					data: { \"id\": \"admin\", \"password\": \"1111\", \"name\": \"관리자\", \"role\": \"Admin\" },\r\n");
      out.write("					data: JSON.stringify(\r\n");
      out.write("						{ \"id\": \"admin\", \"password\": \"1111\", \"name\": \"관리자\", \"role\": \"Admin\" }\r\n");
      out.write("					), // 보내는 데이터를 json형식으로 파싱하여 전송.\r\n");
      out.write("					cache: false,\r\n");
      out.write("					success: function (result) {\r\n");
      out.write("						alert(result);\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			}\r\n");
      out.write("		</script>\r\n");
      out.write("	</head>\r\n");
      out.write("\r\n");
      out.write("	<body>\r\n");
      out.write("		<h2>ajax Array 받기</h2>\r\n");
      out.write("		<div id=\"demo1\">\r\n");
      out.write("			<button type=\"button\" onclick=\"getBoard1(2)\">데이터 불러오기</button>\r\n");
      out.write("		</div>\r\n");
      out.write("		<p id=\"demo1_con\"></p>\r\n");
      out.write("		<hr>\r\n");
      out.write("		<br>\r\n");
      out.write("		<br>\r\n");
      out.write("\r\n");
      out.write("		<h2>ajax Object 받기</h2>\r\n");
      out.write("		<table id=\"status\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>번호</th>\r\n");
      out.write("				<th>제목</th>\r\n");
      out.write("				<th>작성자</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<br>\r\n");
      out.write("		<br>\r\n");
      out.write("\r\n");
      out.write("		<div id=\"demo2\">\r\n");
      out.write("			<button type=\"button\" onclick=\"getBoard2(2)\">데이터 불러오기</button>\r\n");
      out.write("		</div>\r\n");
      out.write("		<br>\r\n");
      out.write("		<br>\r\n");
      out.write("		<hr>\r\n");
      out.write("		<br>\r\n");
      out.write("		<br>\r\n");
      out.write("\r\n");
      out.write("		<button onclick=\"ajaxTest()\">테스트</button>\r\n");
      out.write("	</body>\r\n");
      out.write("\r\n");
      out.write("	</html>");
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
