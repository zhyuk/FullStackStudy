package action.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.NoticeDeleteProService;
import vo.ActionForward;


public class NoticeDeleteProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        ActionForward forward = null;
        int notice_id = Integer.parseInt(request.getParameter("notice_id"));
        
        NoticeDeleteProService noticeDeleteProService = new NoticeDeleteProService();
            noticeDeleteProService.removeNotice(notice_id);
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("noticeList.nt");
        return forward;
    }
}