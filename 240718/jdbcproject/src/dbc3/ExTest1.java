package dbc3;

import java.util.ArrayList;

public class ExTest1 {

	public static void main(String[] args) {
		ExDAO dao = new ExDAO();
		ArrayList<ExDTO> list = dao.select();

		for (ExDTO dto : list) {
			int deptno = dto.getDeptno();
			String dname = dto.getDname();
			String loc = dto.getLoc();
			System.out.println(deptno + " " + dname + " " + loc);
		}
		
		int rowCount = dao.insert(80, "관리과", "대구");
		if(rowCount > 0) System.out.println("데이터 추가 완료"); 
		else System.out.println("데이터 추가 실패");

	}

}
