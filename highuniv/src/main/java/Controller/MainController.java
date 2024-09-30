package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import svc.NoticeListService;
import vo.BoardBean;
import vo.NoticeBean;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int page=1; 
		int limit=5; 
		
		NoticeListService noticeListService = new NoticeListService();
		BoardListService boardListService = new BoardListService();
		
		ArrayList<NoticeBean> noticeList = null;
		ArrayList<BoardBean> boardList = null;
		
		try {
			noticeList = noticeListService.getNoticeList(page, limit);
			boardList = boardListService.getArticleList(page, limit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("boardList", boardList);
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
