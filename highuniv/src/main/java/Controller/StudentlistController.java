package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.StudentService;
import vo.PageInfo;
import vo.StudentVO;

@WebServlet("/professor/studentlist.pr")
public class StudentlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		int page=1;
		int limit=10; // 한 페이지에 표시할 학생 수 studentdelete에도 있음
		int pageBlockSize = 10; // 페이지 네이션에 표시할 페이지 번호 개수
		
		if(request.getParameter("page")==null || request.getParameter("page").equals("")) page = 1;
		else page=Integer.parseInt(request.getParameter("page"));
		
		
		StudentService studentintoservice = new StudentService();
		int listCount;
		
		// 검색 키워드 받기
		String studentSearch = request.getParameter("studentSearch");
		
		if (studentSearch == null || studentSearch.equals("")) {
		    // 검색 키워드가 없으면 전체 학생 목록 조회
		    listCount = studentintoservice.studentListCount();
		    studentList = studentintoservice.studentArticleList(page, limit);
		} else {
		    // 검색 키워드가 있으면 해당하는 학생 목록 조회
		    listCount = studentintoservice.searchStudentCount(studentSearch);
		    studentList = studentintoservice.searchStudentList(page, limit, studentSearch);   
		}
		
		// 총 페이지 수 계산 (총 리스트 수를 페이지 당 항목 수로 나눈 값)
		int maxPage = (int)((double)listCount / limit + 0.95); 
   		
		// 페이지 네이션에 표시할 시작 페이지 번호
		int startPage = ((int) ((double) page / pageBlockSize + 0.9) - 1) * pageBlockSize + 1;
		
		// 페이지 네이션에 표시할 마지막 페이지 번호
		int endPage = startPage + pageBlockSize - 1;

   		if (endPage> maxPage) endPage= maxPage;
   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		
		// 검색 키워드가 있으면 이를 다시 JSP로 넘김
		request.setAttribute("studentSearch", studentSearch);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("studentList", studentList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/professor/student_list.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		doGet(request, response);
	}

}
