package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeListService;
import vo.ActionForward;
import vo.NoticeBean;
import vo.PageInfo;


public class NoticeListAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int page = 1;
        int limit = 10;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        NoticeListService noticeListService = new NoticeListService();

        // 공지사항을 포함한 게시글 리스트를 가져옴
        ArrayList<NoticeBean> noticeList = noticeListService.getNoticeList(page, limit);

        // 페이지 정보 설정
        int listCount = noticeListService.getListCount(); // 게시글 총 개수
        int maxPage = (int) ((double) listCount / limit + 0.95); // 총 페이지 수 계산
        int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1; // 시작 페이지 번호
        int endPage = startPage + 10 - 1; // 마지막 페이지 번호

        if (endPage > maxPage) {
            endPage = maxPage;
        }

        PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, listCount);

        // JSP에 데이터 전달
        request.setAttribute("noticeList", noticeList);
        request.setAttribute("pageInfo", pageInfo);

        ActionForward forward = new ActionForward();
        forward.setPath("/professor/notice_list.jsp");
        return forward;
    }
}
