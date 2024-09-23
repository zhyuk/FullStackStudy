package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;

import vo.StudentVO;

import dao.ModifyDAO;

public class ModifyService {
	public int modifyPh(StudentVO ph) {

		Connection con = getConnection();
		ModifyDAO modifyDAO = ModifyDAO.getInstance();
		modifyDAO.setConnection(con);

		int insertCount = modifyDAO.modifyPh(ph);

		if (insertCount > 0) {
			commit(con);
			System.out.println("전화번호변경성공");
		} else {
			rollback(con);
			System.out.println("전화번호변경실패");
		}

		close(con);

		return insertCount;
	}

	public int modifyEmail(StudentVO email) {

		Connection con = getConnection();
		ModifyDAO modifyDAO = ModifyDAO.getInstance();
		modifyDAO.setConnection(con);

		int insertCount = modifyDAO.modifyEmail(email);

		if (insertCount > 0) {
			commit(con);
			System.out.println("EMAIL변경성공");
		} else {
			rollback(con);
			System.out.println("EMAIL변경실패");
		}

		close(con);

		return insertCount;
	}

	public int modifyAddress(StudentVO address) {

		Connection con = getConnection();
		ModifyDAO modifyDAO = ModifyDAO.getInstance();
		modifyDAO.setConnection(con);

		int insertCount = modifyDAO.modifyAddress(address);

		if (insertCount > 0) {
			commit(con);
			System.out.println("주소변경성공");
		} else {
			rollback(con);
			System.out.println("주소변경실패");
		}

		close(con);

		return insertCount;
	}

	public boolean modifyStudentInfo(StudentVO student) {
		
		return false;
	}
}
