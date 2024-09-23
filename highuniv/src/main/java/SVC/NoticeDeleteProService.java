package svc;

import static util.JdbcUtil.*;
import java.sql.Connection;
import dao.NoticeDAO;

public class NoticeDeleteProService {
	

	public boolean isNoticeWriter(int notice_id, String NOTICE_PASS) throws Exception {
		
		boolean isNoticeWriter = false;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		isNoticeWriter = noticeDAO.isNoticesWriter(notice_id, NOTICE_PASS);
		close(con);
		return isNoticeWriter;
		
	}

    public boolean removeNotice(int notice_id) throws Exception {
        boolean isRemoveSuccess = false;
        Connection con = getConnection();
        NoticeDAO noticeDAO = NoticeDAO.getInstance();
        noticeDAO.setConnection(con);
        int deleteCount = noticeDAO.deleteNotice(notice_id);

        if (deleteCount > 0) {
            commit(con);
            isRemoveSuccess = true;
        } else {
            rollback(con);
        }

        close(con);
        return isRemoveSuccess;
    }
    
    
    
}
