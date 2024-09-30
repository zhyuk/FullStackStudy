package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CourseDAO;
import vo.CourseVO;

public class CourseService {

	// 강의목록 담아오기
	public ArrayList<CourseVO> courseArticleList(String login_id, String subjectSearch) {
		System.out.println("서비스들어옴");
		ArrayList<CourseVO> courseList = null;
		Connection con = getConnection();
		CourseDAO courseDAO = CourseDAO.getInstance();
		courseDAO.setConnection(con);
		System.out.println("서비스->DAO호출");
		courseList = courseDAO.getCourseList(login_id, subjectSearch);

		System.out.println("dao종료 courseList size: " + courseList.size());
		close(con);

		System.out.println("서비스종료");
		return courseList;
	}


	public ArrayList<CourseVO> courseRegisterList(String[] subjectId, String studentId) {
		System.out.println("courseRegisterList 들어옴");
		ArrayList<CourseVO> registerList = null;
		Connection con = getConnection();
		CourseDAO courseDAO = CourseDAO.getInstance();
		courseDAO.setConnection(con);
		System.out.println("서비스에서 다오호출");
		registerList = courseDAO.getRegisterList(subjectId, studentId);

		System.out.println("dao다녀옴: " + registerList.size());
		close(con);

		System.out.println("서비스 종료함");
		return registerList;
	}

	public ArrayList<CourseVO> myCourseList(String login_id) {
		System.out.println("수강목록 서비스 들어옴");
		ArrayList<CourseVO> myCourseList = null;
		Connection con = getConnection();
		CourseDAO courseDAO = CourseDAO.getInstance();
		courseDAO.setConnection(con);
		System.out.println("서비스에서 다오호출2");
		myCourseList = courseDAO.getMyCourseList(login_id);
		System.out.println("dao 다녀옴:" + myCourseList.size());
		close(con);

		System.out.println("서비스 종료");
		return myCourseList;
	}

	public int registerDelete(String[] courseIds, String studentId) {
		System.out.println("수강삭제 서비스 들어옴");
		int registerdelete = 0;
		Connection con = getConnection();
		CourseDAO courseDAO = CourseDAO.getInstance();
		courseDAO.setConnection(con);
		System.out.println("서비스에서 다오호출3");
		registerdelete = courseDAO.getRegisterDelete(courseIds, studentId);
		System.out.println("registerdelete: " + registerdelete);

		if (registerdelete > 0) {
			commit(con);
			System.out.println("삭제성공");
		} else {
			rollback(con);
			System.out.println("삭제실패");
		}
		System.out.println("dao다녀옴 3: " + registerdelete);
		close(con);

		System.out.println("서비스 종료3");
		return registerdelete;

	}

}