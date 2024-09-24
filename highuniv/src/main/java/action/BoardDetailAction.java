package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import svc.CommentListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.CommentBean;

 public class BoardDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		int board_no=Integer.parseInt(request.getParameter("board_no"));
		String page = request.getParameter("page");
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_no);
		
		ArrayList<CommentBean> commentList = new ArrayList<CommentBean>();
		CommentListService commentListService = new CommentListService();
		commentList = commentListService.getcommentList(board_no);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
	   	request.setAttribute("commentList", commentList);
   		forward.setPath("/board/board_view.jsp");
   		return forward;

	 }
	 
}