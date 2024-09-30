package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_no=Integer.parseInt(request.getParameter("BOARD_NO"));
		int board_num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		String session_id = request.getParameter("SESSION_ID");		
		BoardBean boardBean = new BoardBean();
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		boolean isRightUser=boardModifyProService.isArticleWriter(board_no, session_id);

		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			boardBean.setBOARD_NO(board_no);
			boardBean.setBOARD_NUM(board_num);
			boardBean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			boardBean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT")); 
			boardBean.setBOARD_MAIN(request.getParameter("BOARD_MAIN"));
			isModifySuccess = boardModifyProService.modifyArticle(boardBean);
			
			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_no="+boardBean.getBOARD_NO()+"&page="+request.getParameter("page")); 
			}

		}
			

		return forward;
	}

}