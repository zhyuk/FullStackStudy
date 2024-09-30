package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CommentWriteService;
import vo.ActionForward;
import vo.CommentBean;

public class CommentWriteAction implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = new ActionForward();
       
        
        String boardNo = request.getParameter("board_no");
        String commentId = request.getParameter("COMMENT_ID");
        String commentName = request.getParameter("COMMENT_NAME");
        String commentContent = request.getParameter("COMMENT_CONTENT");
        String page = request.getParameter("page");
        
        // CommentBean 객체 생성 및 정보 설정
        CommentBean commentBean = new CommentBean();
        commentBean.setBOARD_NO(Integer.parseInt(boardNo)); // 보드 번호 설정
        commentBean.setCOMMENT_ID(commentId);
        commentBean.setCOMMENT_NAME(commentName);
        commentBean.setCOMMENT_CONTENT(commentContent); // 댓글 내용 설정

        // CommentDAO 객체 생성 및 댓글 저장
        CommentWriteService commentWriteService = new CommentWriteService();
        boolean isWriteSuccess = commentWriteService.registArticle(commentBean);

        if (!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");	
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardDetail.bo?board_no=" + boardNo + "&page=" + page);
		}
   
        return forward;
    }
}
