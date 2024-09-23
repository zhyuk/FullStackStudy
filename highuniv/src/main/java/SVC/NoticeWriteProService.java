package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.NoticeBean;

public class NoticeWriteProService {

    
    public boolean writeNotice(NoticeBean noticeBean) throws Exception {
        boolean isWriteSuccess = false;
        Connection con = getConnection();
        
        // NoticeBean 객체 생성 및 데이터 설정
        NoticeDAO noticeDAO = NoticeDAO.getInstance();
        noticeDAO.setConnection(con);
        
        int insertCount = noticeDAO.insertNotice(noticeBean);

        if (insertCount > 0) {
            commit(con);
            isWriteSuccess = true;
        } else {
            rollback(con);
        }

        close(con);
        return isWriteSuccess;
    }
}
