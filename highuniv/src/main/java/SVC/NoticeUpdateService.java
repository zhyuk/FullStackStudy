package svc;

import java.sql.Connection;
import static util.JdbcUtil.*;
import dao.NoticeDAO;

public class NoticeUpdateService {

    // 공지를 등록하는 메서드
    public boolean setNoticesAsPublic(String[] noticeIds) throws Exception {
        boolean isUpdateSuccess = false;
        Connection con = getConnection();
        
        // NoticeBean 객체 생성 및 데이터 설정
        NoticeDAO noticeDAO = NoticeDAO.getInstance(); 
        noticeDAO.setConnection(con);

        // 공지 업데이트 쿼리를 실행
        int updateCount = noticeDAO.updateNoticesToPublic(noticeIds);

        // 업데이트 성공 여부에 따라 트랜잭션 처리
        if (updateCount > 0) {
            commit(con);
            isUpdateSuccess = true;
        } else {
            rollback(con);
        }

        close(con);
        return isUpdateSuccess;
    }
    
    
    // 공지를 취소하는 메서드
    public boolean setNoticesAsPrivate(String[] noticeIds) throws Exception {
        boolean isUpdateSuccess = false;
        Connection con = getConnection();
        
        NoticeDAO noticeDAO = NoticeDAO.getInstance(); 
        noticeDAO.setConnection(con);

        int updateCount = noticeDAO.updateNoticesToPrivate(noticeIds);

        // 업데이트 성공 여부에 따라 트랜잭션 처리
        if (updateCount > 0) {
            commit(con);
            isUpdateSuccess = true;
        } else {
            rollback(con);
        }

        close(con);
        return isUpdateSuccess;
    }

}
