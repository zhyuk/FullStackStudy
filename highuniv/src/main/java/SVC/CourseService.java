package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CourseDAO;
import vo.CourseVO;

public class CourseService {
	
	//강의목록 담아오기
	public ArrayList<CourseVO> courseArticleList(String login_id){
		System.out.println("서비스들어옴");
		ArrayList<CourseVO> courseList = null;
		Connection con = getConnection();
		CourseDAO courseDAO = CourseDAO.getInstance();
		courseDAO.setConnection(con);
		System.out.println("서비스->DAO호출");
		courseList = courseDAO.getCourseList(login_id);
		
		System.out.println("dao종료 courseList size: "+courseList.size());
		close(con);
		
		System.out.println("서비스종료");
		return courseList;
	}
	
	public ArrayList<CourseVO> courseRegisterList(String[] subjectId, String studentId){
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
	
	 public int getCourseRegisterCount(String courseId) {
		 	System.out.println("카운트 서비스 들어옴");
	        Connection con = getConnection();
	        CourseDAO courseDAO = CourseDAO.getInstance();
	        courseDAO.setConnection(con);
	        System.out.println("카운트 서비스에서 다오호출");

	        int count = courseDAO.getCourseRegisterCount(courseId);
	        
	        System.out.println("count DAO 다녀옴 : " + count);

	        close(con);  // 연결 닫기
	        return count;
	    }
	
	
	public boolean registerCourse(String courseId) {
	    boolean isSuccess = false;
	    System.out.println("registerCourse 들어옴" );
	    Connection con = getConnection();
	    CourseDAO courseDAO = CourseDAO.getInstance();
	    courseDAO.setConnection(con);
	    System.out.println("서비스에서 다오호출");

	    int updateCount = courseDAO.updateCourseStatus(courseId);
	    
	    if (updateCount > 0) {
	        isSuccess = true;
	        System.out.println("수강 신청 완료 및 상태 업데이트 성공");
	    } else {
	        System.out.println("수강 신청 실패");
	    }

	    close(con);
	    return isSuccess;
	}
	
}