package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteService;
import vo.ActionForward;

public class BoardDeleteAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {     

        ActionForward forward = null;
        int board_no = Integer.parseInt(request.getParameter("board_no"));
        String session_id = request.getParameter("session_id");
        String nowPage = request.getParameter("page");
        
        BoardDeleteService boardDeleteService = new BoardDeleteService();
        boolean isArticleWriter = boardDeleteService.isArticleWriter(board_no, session_id);

        if (!isArticleWriter) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('삭제할 권한이 없습니다.');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        } else {
            boolean isDeleteSuccess = boardDeleteService.removeArticle(board_no);

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
                forward.setPath("boardList.bo?page=" + nowPage);
            }
        }

        return forward;
    }
}
