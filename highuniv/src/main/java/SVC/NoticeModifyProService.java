package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.NoticeBean;


public class NoticeModifyProService {

	public boolean isNoticeWriter(int notice_num, String pass) throws Exception {
		
		boolean isNoticeWriter = true;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
//		isNoticeWriter = noticeDAO.isNoticesWriter(notice_num, pass);
		close(con);
		return isNoticeWriter;
		
		
	}

	public boolean modifyNotice(NoticeBean notice) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		int updateCount = noticeDAO.updateNotice(notice);
		
		if(updateCount > 0){
			commit(con);
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
		
		
		
	}
}
