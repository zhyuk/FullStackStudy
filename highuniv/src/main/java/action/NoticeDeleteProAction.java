package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeDeleteProService;
import vo.ActionForward;


public class NoticeDeleteProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        ActionForward forward = null;
        int notice_id = Integer.parseInt(request.getParameter("notice_id"));
        
        
        
        String nowPage = request.getParameter("page");
        NoticeDeleteProService noticeDeleteProService = new NoticeDeleteProService();
        boolean isNoticeWriter = noticeDeleteProService.isNoticeWriter(notice_id, request.getParameter("NOTICE_PASS"));

        if (!isNoticeWriter) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('삭제할 권한이 없습니다');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        } else {
            boolean isDeleteSuccess = noticeDeleteProService.removeNotice(notice_id);

            if (!isDeleteSuccess) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('삭제실패');");
                out.println("history.back();");
                out.println("</script>");
                out.close();
            } else {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("noticeList.nt?page=" + nowPage);
            }
        }
        return forward;
    }
}