package svc;

import dao.AttendDAO;
import vo.AttendVO;

public class AttendSVC {

	public int updateAttend(AttendVO avo) {
		System.out.println("updateAttend() 실행");
		AttendDAO adao = new AttendDAO();
		int rs = adao.updateAttend(avo);
		
		return rs;
		
		
	}
}
