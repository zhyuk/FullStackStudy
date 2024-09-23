package svc;

import static util.JdbcUtil.commit;
import static util.JdbcUtil.rollback;

import dao.JoinDAO;
import vo.ProfessorVO;

public class JoinSVC {

	
	public int insertProf(ProfessorVO pvo) {
		JoinDAO joinDAO = new JoinDAO();
		int result = joinDAO.insertInfo(pvo);
		
		return result;
	}
}
