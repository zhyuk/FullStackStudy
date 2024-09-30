package dao;

import static util.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.CourseVO;

public class CourseDAO {

	private static CourseDAO instance;
	Connection con;
	DataSource ds;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;

	private CourseDAO() {
	}

	// 싱글톤 패턴으로 CourseDAO 인스턴스 관리
	public static CourseDAO getInstance() {
		if (instance == null) {
			instance = new CourseDAO();
		}
		return instance;
	}

	// 커넥션 설정
	public void setConnection(Connection con) {
		this.con = con;
	}

	public ArrayList<CourseVO> getRegisterList(String[] subjectIds, String studentId) {
		System.out.println("다오입장");
		ArrayList<CourseVO> registerList = new ArrayList<>();

		rs = null;
		PreparedStatement pstmtInsert = null;
		PreparedStatement pstmtSelect = null;

		try {
			String insertSql = "INSERT INTO course_register (course_id, student_id, course_status, course_grade) "
					+ "SELECT c.course_id AS COURSE_ID, ? AS STUDENT_ID, '신청' AS COURSE_STATUS,"
					+ " sum(s.subject_credit) AS COURSE_GRADE " + " FROM course c"
					+ "	INNER JOIN subject s ON c.subject_id = s.subject_id	WHERE s.subject_id = ?"
					+ " GROUP BY c.course_id";


			String selectSql = "SELECT course_id, student_id, course_status, course_grade " + " FROM course_register"
					+ " WHERE student_id = ? and course_id = ?";

			// 각 subjectId에 대해 INSERT와 SELECT 처리
			for (String subjectId : subjectIds) {
				// INSERT 처리
				pstmtInsert = con.prepareStatement(insertSql);
				pstmtInsert.setString(1, studentId); // 학생 ID 설정
				pstmtInsert.setString(2, subjectId); // 현재 subjectId 설정
				int rowsAffected = pstmtInsert.executeUpdate();
				System.out.println("등록된 과목 ID: " + subjectId + ", 영향을 받은 행 수: " + rowsAffected);

				String courseIdSql = "SELECT course_id FROM course WHERE subject_id = ?";
				pstmtSelect = con.prepareStatement(courseIdSql);
				pstmtSelect.setString(1, subjectId);
				rs = pstmtSelect.executeQuery();

				String courseId = "";
				if (rs.next()) {
					courseId = rs.getString("course_id");
				}
				// SELECT 처리 (삽입된 데이터 조회)
				pstmtSelect = con.prepareStatement(selectSql);
				pstmtSelect.setString(1, studentId); // 학생 ID 설정
				pstmtSelect.setString(2, courseId); // 현재 subjectId 설정
				rs = pstmtSelect.executeQuery();

				// SELECT 결과를 CourseVO에 담기
				if (rs.next()) {
					CourseVO course = new CourseVO();
					course.setCourseId(rs.getString("course_id"));
					course.setStudentId(studentId);
					course.setCourseStatus(rs.getString("course_status"));
					course.setCourseGrade(rs.getInt("course_grade"));
					// registerList에 추가
					registerList.add(course);
				}
			}
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				// 에러 발생 시 롤백
				con.rollback();
			} catch (Exception rollbackEx) {
				rollbackEx.printStackTrace();
			}
		} finally {
			// 리소스 정리
			try {
				if (rs != null)
					rs.close();
				if (pstmtInsert != null)
					pstmtInsert.close();
				if (pstmtSelect != null)
					pstmtSelect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return registerList;
	}


	public int getRegisterDelete(String[] courseIds, String studentId) {
		System.out.println("DAO 입장 3: " + "courseId: " + courseIds + " studentId: " + studentId);
		pstmt = null;
		rs = null;

		int registerdelete = 0;
		String sql = "DELETE FROM course_register WHERE course_id in(?) and student_id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			for (String courseId : courseIds) {
				pstmt.setString(1, courseId);
				pstmt.setString(2, studentId);
				registerdelete += pstmt.executeUpdate();
			}
			System.out.println("registerdelete: " + registerdelete);
		} catch (Exception e) {

		} finally {

		}
		return registerdelete;
	}


	// 전체과목 조회
	public ArrayList<CourseVO> getCourseList(String login_id, String subjectSearch) {
		System.out.println("DAO들어옴");
		ArrayList<CourseVO> courseList = new ArrayList<>();
		PreparedStatement pstmt = null;
		rs = null;


		String sql = "SELECT c.course_id, s.subject_id, s.subject_name, c.course_maxpeople, s.subject_semester,"
					+ " s.subject_credit, s.subject_starttime, s.subject_endtime, s.subject_day, p.professor_name,"
					+ " s.subject_room, COALESCE(c.max_count, 0) AS max_count, COALESCE(c.status, '가능') AS status"
					+ " FROM subject s LEFT JOIN ("
					+ "     SELECT c.subject_id, c.course_id, c.course_maxpeople, COUNT(r.course_id) AS max_count, CASE WHEN COUNT(CASE WHEN r.student_id = ? THEN 1 END) > 0 THEN '완료' ELSE '가능' END AS status"
					+ "	 FROM course_register r FULL OUTER JOIN course c ON r.course_id = c.course_id"
					+ "	 GROUP BY c.subject_id, c.course_id, c.course_maxpeople"
					+ ") c ON s.subject_id = c.subject_id"
					+ " LEFT JOIN professor p ON s.professor_id = p.professor_id";
		
		if (!subjectSearch.equals("")) {
		    sql += " WHERE s.subject_name LIKE ? OR p.professor_name LIKE ? OR s.subject_day LIKE ?";
		}
		
		sql += " ORDER BY c.course_id";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login_id); // 학생 ID를 SQL에 바인딩

		    if (!subjectSearch.equals("")) {
		        pstmt.setString(2, "%" + subjectSearch + "%");
		        pstmt.setString(3, "%" + subjectSearch + "%");
		        pstmt.setString(4, "%" + subjectSearch + "%");
		    }
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseVO cs = new CourseVO();
				cs.setCourseId(rs.getString("course_id"));
				cs.setSubjectId(rs.getString("subject_id"));
				cs.setSubjectName(rs.getString("subject_name"));
				cs.setCourseMaxPeople(rs.getInt("course_maxpeople"));
				cs.setSubjectSemester(rs.getString("subject_semester"));
				cs.setSubjectCredit(rs.getInt("subject_credit"));
				cs.setSubjectStartTime(rs.getString("subject_starttime"));
				cs.setSubjectEndTime(rs.getString("subject_endtime"));
				cs.setSubjectDay(rs.getString("subject_day"));
				cs.setProfessorName(rs.getString("professor_name"));
				cs.setSubjectRoom(rs.getString("subject_room"));
				cs.setCourseStatus(rs.getString("status"));
				cs.setMaxCount(rs.getInt("max_count"));

				courseList.add(cs);
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외 처리
		} finally {
			if (rs != null)
				close(rs);
			if (stmt != null)
				close(stmt);
		}
		return courseList;
	}

	public ArrayList<CourseVO> getMyCourseList(String login_id) {
		ArrayList<CourseVO> MyCourseList = new ArrayList<>();
		pstmt = null;
		rs = null;

		String sql = " SELECT c.course_id, s.subject_id, s.subject_name, s.subject_semester, s.subject_credit,"
				+ " s.subject_starttime, s.subject_endtime, s.subject_day, p.professor_name, s.subject_room"
				+ "	from course_register cr" + "	inner join course c	on cr.course_id = c.course_id"
				+ "	inner join subject s on c.subject_id = s.subject_id"
				+ "	left join professor p on s.professor_id = p.professor_id" + "	where cr.student_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login_id);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				CourseVO cs = new CourseVO();
				cs.setCourseId(rs.getString("course_id"));
				cs.setSubjectId(rs.getString("subject_id"));
				cs.setSubjectName(rs.getString("subject_name"));
				cs.setSubjectSemester(rs.getString("subject_semester"));
				cs.setSubjectCredit(rs.getInt("subject_credit"));
				cs.setSubjectStartTime(rs.getString("subject_starttime"));
				cs.setSubjectEndTime(rs.getString("subject_endtime"));
				cs.setSubjectDay(rs.getString("subject_day"));
				cs.setProfessorName(rs.getString("professor_name"));
				cs.setSubjectRoom(rs.getString("subject_room"));

				MyCourseList.add(cs);
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외 처리
		} finally {
			if (rs != null)
				close(rs);
			if (stmt != null)
				close(stmt);
		}
		return MyCourseList;
	}
}