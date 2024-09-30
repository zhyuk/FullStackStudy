package action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.NoticeDetailService;
import vo.ActionForward;
import vo.NoticeBean;


public class NoticeModifyFormAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = new ActionForward();
        int notice_id = Integer.parseInt(request.getParameter("notice_id"));
        NoticeDetailService noticeDetailService = new NoticeDetailService();
        NoticeBean notice = noticeDetailService.getNotice(notice_id);
        request.setAttribute("page", request.getParameter("page"));
        request.setAttribute("notice", notice);
        forward.setPath("/professor/notice_modify.jsp?NOTICE_ID=" + request.getParameter("NOTICE_ID"));
        return forward;
    }
}