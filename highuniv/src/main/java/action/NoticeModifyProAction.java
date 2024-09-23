package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.NoticeModifyProService;
import vo.ActionForward;
import vo.NoticeBean; 


public class NoticeModifyProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        ActionForward forward = null;
        boolean isModifySuccess = false;
        
        int notice_id = Integer.parseInt(request.getParameter("NOTICE_ID"));
        
        // 세션에서 로그인한 사용자 id 가져오기
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");  // 로그인한 사용자의 id (admin인지 확인)
        
        boolean isRightUser = false; // 사용자 권한 플래그
        
        // 로그인한 사용자가 admin인 경우 수정 권한을 부여
        if ("admin".equals(userId)) {
            isRightUser = true;
        } else {
            // admin이 아닌 경우 기존 방식으로 수정 권한 확인
            NoticeModifyProService noticeModifyProService = new NoticeModifyProService();
            isRightUser = noticeModifyProService.isNoticeWriter(notice_id, request.getParameter("NOTICE_PASS"));
        }
        
        if (!isRightUser) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('수정할 권한이 없습니다.');");
            out.println("history.back();");
            out.println("</script>");
        } else {
        	// 공지 수정 로직
        	NoticeBean notice = new NoticeBean();
        	notice.setNotice_id(notice_id);
        	notice.setNotice_title(request.getParameter("NOTICE_TITLE"));
        	notice.setNotice_content(request.getParameter("NOTICE_CONTENT"));
        	notice.setNotice_writer(request.getParameter("NOTICE_WRITER"));
            
        	NoticeModifyProService noticeModifyProService = new NoticeModifyProService();
            isModifySuccess = noticeModifyProService.modifyNotice(notice);

            if (!isModifySuccess) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('수정실패');");
                out.println("history.back()");
                out.println("</script>");
            } else {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("noticeDetail.nt?notice_id=" + notice.getNotice_id() + "&page=" + request.getParameter("page"));
            }
        }
        return forward;
    }
}