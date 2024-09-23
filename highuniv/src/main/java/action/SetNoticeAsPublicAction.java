package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.NoticeUpdateService;
import vo.ActionForward;


public class SetNoticeAsPublicAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
    	HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id"); // 로그인한 사용자 ID 가져오기

        // 관리자 권한 확인
        if (!"admin".equals(userId)) {
            // 권한이 없을 때 처리
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script>");
            response.getWriter().println("alert('공지 등록은 관리자만 가능합니다.');");
            response.getWriter().println("history.back();");
            response.getWriter().println("</script>");
            return null;  // 권한이 없으므로 더 이상 진행하지 않음
        }

        // 공지 등록 로직
        String[] noticeIds = request.getParameterValues("notice_ids");
        ActionForward forward = null;
        
        if (noticeIds != null && noticeIds.length > 0) {
            NoticeUpdateService noticeUpdateService = new NoticeUpdateService();
            boolean isUpdateSuccess = noticeUpdateService.setNoticesAsPublic(noticeIds);

            if (isUpdateSuccess) {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("noticeList.nt"); // 공지 목록으로 리다이렉트
            } else {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println("<script>");
                response.getWriter().println("alert('공지 등록 실패');");
                response.getWriter().println("history.back();");
                response.getWriter().println("</script>");
            }
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script>");
            response.getWriter().println("alert('선택된 공지가 없습니다.');");
            response.getWriter().println("history.back();");
            response.getWriter().println("</script>");
        }

        return forward;
    }
}
