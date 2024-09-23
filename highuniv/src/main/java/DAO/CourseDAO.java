package dao;

import static util.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.CourseVO;

public class CourseDAO {

	private static CourseDAO instance;
	Connection con;
	DataSource ds;
	Statement stmt;
	ResultSet rs;

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

	public int updateCourseStatus(String courseId) {
		System.out.println("다오입장1");
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "UPDATE course SET course_status = '신청완료' WHERE course_id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, courseId);
			updateCount = pstmt.executeUpdate();

			if (updateCount > 0) {
				con.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

//		String str = "";
//
//		for (int i = 0; i < registerList.size(); i++) {
//			if (i != registerList.size() - 1)
//				str += registerList.get(i) + ",";
//			else
//				str += registerList.get(i);
//			System.out.println("str: " + str);
//		}
	public ArrayList<CourseVO> getRegisterList(String[] subjectIds, String studentId) {
		System.out.println("다오입장");
		ArrayList<CourseVO> registerList = new ArrayList<>();

		rs = null;
		PreparedStatement pstmtInsert = null;
		PreparedStatement pstmtSelect = null;
		PreparedStatement pstmtTotalCredit = null;

		try {
			String insertSql = "INSERT INTO course_register (course_id, student_id, course_status, course_grade) "
					+ "SELECT c.course_id AS COURSE_ID, ? AS STUDENT_ID, '신청' AS COURSE_STATUS,"
					+ " sum(s.subject_credit) AS COURSE_GRADE " + " FROM course c"
					+ "	INNER JOIN subject s ON c.subject_id = s.subject_id	WHERE s.subject_id = ?"
					+ " GROUP BY c.course_id";

//			String sql2 = "SELECT course_id, ? as student_id, course_status, course_grade FROM course_register WHERE subject_id = ?";

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

	public int getCourseRegisterCount(String courseId) {
		System.out.println("카운트 다오입장");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "SELECT COUNT(*) as count FROM course_register WHERE course_id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, courseId); // 첫 번째 ?에 courseId 값을 바인딩
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1); // 첫 번째 컬럼에서 count 값을 가져옴
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return count; // 해당 course_id의 등록된 수강생 수 반환
	}

	// 전체과목 조회
	public ArrayList<CourseVO> getCourseList(String login_id) {
		System.out.println("DAO들어옴");
		ArrayList<CourseVO> courseList = new ArrayList<>();
//    	PreparedStatement pstmt = null;
		stmt = null;
		rs = null;
//    	CourseVO cs = null;
		String sql = "select c.course_id as COURSE_ID, s.subject_id as SUBJECT_ID, "
				+ " s.subject_name as SUBJECT_NAME, c.course_maxpeople as COURSE_MAXPEOPLE, "
				+ " s.subject_semester as SUBJECT_SEMESTER, s.subject_credit as SUBJECT_CREDIT,"
				+ " s.subject_starttime as SUBJECT_STARTTIME, s.subject_endtime as SUBJECT_ENDTIME,"
				+ "	s.subject_day as SUBJECT_DAY, s.professor_id as PROFESSOR_ID,"
				+ "	s.subject_room as SUBJECT_ROOM " + "	from course c" + " inner join subject s "
				+ " on c.subject_id = s.subject_id";
		try {
//    		stmt = con.createStatement();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
//    		pstmt = con.prepareStatement(sql);
//    		pstmt.setString(1, studentId); // 학생 ID를 SQL에 바인딩
//    		rs = pstmt.executeQuery();
//			private String subjectId	;
			// 결과 집합을 순회하며 CourseVO 객체 생성 및 리스트에 추가
//    		int total = 0;
			while (rs.next()) {
				System.out.println(rs);
//    			int count = 0;
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
				cs.setProfessorId(rs.getString("professor_id"));
				cs.setSubjectRoom(rs.getString("subject_room"));

				courseList.add(cs);
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외 처리
		} finally {
			// 자원 해제
//    		if (rs != null) rs.close();
//    		if (stmt != null) stmt.close();
			if (rs != null)
				close(rs);
			if (stmt != null)
				close(stmt);
		}
		return courseList;
	}

}
