package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.NoticeBean;


public class NoticeDetailService {

    public NoticeBean getNotice(int notice_id) throws Exception {
    	
        NoticeBean notice = null;
        Connection con = getConnection();
        NoticeDAO noticeDAO = NoticeDAO.getInstance();
        noticeDAO.setConnection(con);
        
        //조회수 업데이트
        int updateCount = noticeDAO.updateNoticeView(notice_id);
        if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
        notice = noticeDAO.selectNotice(notice_id);
        close(con);
        return notice;
    }
}
