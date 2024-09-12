package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendDAO {

	public void attendList() {
		String sql = "SELECT a.course_id, s.subject_name, st.student_id, st.student_name, a.attend_remarks, a.status \n"
				+ "FROM attend a\n"
				+ "JOIN course e ON a.course_id = e.course_id\n"
				+ "JOIN subject s ON e.subject_id = s.subject_id\n"
				+ "JOIN course_register cr ON a.course_id = cr.course_id\n"
				+ "JOIN student st ON cr.student_id = st.student_id";
		
		
	}
}
