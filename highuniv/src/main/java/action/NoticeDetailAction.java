package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeDetailService;
import vo.ActionForward;
import vo.NoticeBean;


public class NoticeDetailAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int notice_id = Integer.parseInt(request.getParameter("notice_id"));
        String page = request.getParameter("page");
        NoticeDetailService noticeDetailService = new NoticeDetailService();
        NoticeBean notice = noticeDetailService.getNotice(notice_id);
        ActionForward forward = new ActionForward();
        request.setAttribute("page", page);
        request.setAttribute("notice", notice);
        forward.setPath("/professor/notice_view.jsp");
        return forward;
    }
}