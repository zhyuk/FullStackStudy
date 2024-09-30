package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CommentDeleteService;
import vo.ActionForward;
import vo.CommentBean;

public class CommentDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {     

        ActionForward forward = null;
        CommentBean commentBean = new CommentBean();
        int board_no = Integer.parseInt(request.getParameter("board_no"));
        int comment_no = Integer.parseInt(request.getParameter("comment_no"));
        String comment_id = request.getParameter("comment_id");
        String nowPage = request.getParameter("page");
        CommentDeleteService commentDeleteService = new CommentDeleteService();
        boolean isCommentWriter = commentDeleteService.isCommentWriter(comment_no, comment_id);

        if (!isCommentWriter) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('삭제할 권한이 없습니다.');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        } else {
            boolean isDeleteSuccess = commentDeleteService.removeComment(comment_no);

            if (!isDeleteSuccess) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('삭제 실패');");
                out.println("history.back();");
                out.println("</script>");
                out.close();
            } else {
            	
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("boardDetail.bo?board_no="+ board_no + "&page=" + nowPage);
            }
        }

        return forward;
    }
}
