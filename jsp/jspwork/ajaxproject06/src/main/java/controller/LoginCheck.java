package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import VO.MemberVO;
import dao.MemberDAO;

@WebServlet("/loginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HelloServlet doProcess()");

		// 전송한 데이터가 form 데이터인 경우
		String id = request.getParameter("id");
		System.out.println("id : " + id);

		if (id == null) {
			// 전송한 데이터가 json데이터인 경우
			ServletInputStream req = request.getInputStream();
			StringBuilder stringBuilder = new StringBuilder();
			BufferedReader bufferedReader = null;
			try {
				InputStream inputStream = request.getInputStream();
				if (inputStream != null) {
					bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					char[] charBuffer = new char[128];
					int bytesRead = -1;
					while ((bytesRead = bufferedReader.read(charBuffer)) > -1) {
						stringBuilder.append(charBuffer, 0, bytesRead);
					}

				} else {
					stringBuilder.append("");
					System.out.println(stringBuilder);
				}
				JSONParser json = new JSONParser();
				JSONObject jobj;
				try {
					jobj = (JSONObject) json.parse(stringBuilder.toString());
					id = (String) jobj.get("id");
					System.out.println("json id : " + id);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} catch (IOException ex) {
				throw ex;
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ex) {
						throw ex;
					}
				}
			}
		}

		MemberVO mVO = new MemberVO();
		mVO.setId(id);
		MemberDAO mDAO = new MemberDAO();
		boolean result = mDAO.idCheck(mVO);
		String str;

		if (result) str = "사용하실 수 없는 아이디입니다.";
		else str = "사용 가능한 아이디입니다.";

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("str", str);
		map.put("id", id);

		// JSONObject : json 형태로 보내는 key와 value의 쌍으로 보냄
		JSONObject jObject = new JSONObject();
		jObject.put("map", map);

		response.setContentType("application/x-json; charset=utf-8");
		response.getWriter().print(jObject);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}