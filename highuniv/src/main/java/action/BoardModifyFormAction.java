package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int board_no=Integer.parseInt(request.getParameter("board_no"));
			BoardDetailService boardDetailService = new BoardDetailService();	
		   	BoardBean article =boardDetailService.getArticle(board_no);
		   	request.setAttribute("page", request.getParameter("page"));
		   	request.setAttribute("article", article);
	   		forward.setPath("/board/qna_board_modify.jsp?BOARD_NUM="+request.getParameter("BOARD_NUM"));
	   		return forward;
	   		
	 }
	 
}