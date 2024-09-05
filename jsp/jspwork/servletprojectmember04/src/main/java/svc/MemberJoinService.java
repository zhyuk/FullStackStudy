package svc;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MemberDAO;

public class MemberJoinService {

	public boolean joinMember(MemberBean member) { // &100
		boolean joinSuccess = false;

		MemberDAO memberDAO = MemberDAO.getInstance(); // &300 반환받음
		Connection con = getConnection(); // &400 반환받음
		memberDAO.setConnection(con);

		int insertCount = memberDAO.insertMember(member); // 1 반환받음
		if (insertCount > 0) {
			joinSuccess = true;
			commit(con); // &400
		} else {
			rollback(con);
		}
		close(con); // &400 close
		return joinSuccess; // true 반환
	}

}
