package action.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.NoticeListService;
import vo.ActionForward;
import vo.NoticeBean;
import vo.PageInfo;


public class NoticeSearchAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String searchType = request.getParameter("type");
		String keyword = request.getParameter("keyword");

		// 테이블 형식의 NoticeList 한줄 객체를 ArrayList 형식으로 받아옴
		ArrayList<NoticeBean> noticeList = new ArrayList<NoticeBean>();
		int page = 1; // 현재 선택한 페이지를 받을 변수(nowBtn에 해당됨)
		int limit = 10; // 한 페이지에 보여줄 목록 개수 (onePageListCnt에 해당됨)

		// 현재 페이지 번호가 1이거나 아닐때
		if (request.getParameter("page") == null || request.getParameter("page").equals(""))
			page = 1;
		else
			page = Integer.parseInt(request.getParameter("page"));

//			NoticeListService 객체 생성
		NoticeListService noticeListService = new NoticeListService();
//			NoticeListService getListCount메소드 실행
		int listCount = noticeListService.getListCount(); // 총 목록 개수를 받아옴.
//			BoardListService getArticleList메소드 실행
		// 검색 조건에 따라 게시글 목록 가져오기
		noticeList = noticeListService.searchNotices(searchType, keyword, page, limit);

		// 총 페이지 수(총 버튼 수 : totalBtnCnt에 해당됨)_수정
		int maxPage;
		if (listCount % limit == 0)
			maxPage = listCount / limit;
		else
			maxPage = listCount / limit + 1;

		// 현재 페이지에서 보여줄 시작 페이지번호(시작 버튼 버튼번호)_수정
		int startPage = (((int) ((double) page / limit + 0.9)) - 1) * limit + 1;
		// 현재 페이지에 보여줄 마지막 페이지 번호(마지막 버튼 버튼번호)_수정
		int endPage = startPage + limit - 1;

		if (endPage > maxPage)
			endPage = maxPage;
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);

		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("noticeList", noticeList);

//			/index.jsp로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("/professor/notice_list.jsp");
		return forward;

    }
}
