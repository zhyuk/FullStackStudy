package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;
import vo.NoticeBean;


public class NoticeListService {

    // 리스트 카운트를 구하는 메서드
    public int getListCount() throws Exception {
        int listCount = 0;
        Connection con = getConnection();
        NoticeDAO noticeDAO = NoticeDAO.getInstance();
        noticeDAO.setConnection(con);
        listCount = noticeDAO.selectListCount();
        close(con);
        return listCount;
    }

    // 게시글 목록 조회 (공지사항 포함)
    public ArrayList<NoticeBean> getNoticeList(int page, int limit) throws Exception {
        ArrayList<NoticeBean> noticeList = null;
        Connection con = getConnection();
        NoticeDAO noticeDAO = NoticeDAO.getInstance();
        noticeDAO.setConnection(con);
//        noticeList = noticeDAO.selectNoticeList(page, limit); // 공지사항 포함 조회
        noticeList = noticeDAO.selectNoticeList(page, limit); // 공지사항 포함 조회
        close(con);
        return noticeList;
    }
    
    // 글 목록 조회
    public ArrayList<NoticeBean> searchNotices(String type, String keyword, int page, int limit) {
		ArrayList<NoticeBean> noticeList = new ArrayList<>();
	    Connection con = getConnection();
	    NoticeDAO noticeDAO = NoticeDAO.getInstance();
	    noticeDAO.setConnection(con);
	    noticeList = noticeDAO.searchNoticeList(type,keyword,page,limit);
		close(con);
		return noticeList;
	}
    
    
}
