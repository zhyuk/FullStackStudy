package svc;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StudentDAO;
import vo.StudentVO;

public class StudentService {
	
	//학생등록
	public int insertStudent(StudentVO student) {
		
		Connection con = getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);
		
		int insertCount = studentDAO.insertStudent(student);
		
		if(insertCount>0) {
			commit(con);
			System.out.println("DB입력성공");
		}else {
			rollback(con);
			System.out.println("DB입력실패");
		}
		
		close(con);
		
		return insertCount; 
	}
	
	//학생학번중복검사
	public int studentid_chk(String student_id) {
		Connection con = getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);

		int chkCount = studentDAO.studentid_chk(student_id);

		close(con);
		return chkCount;
	}
	
	//학생수정
	public int updateStudent(StudentVO student) {
			
		Connection con = getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);
		
		int updateCount = studentDAO.updateStudent(student);
		
		if(updateCount>0) {
			commit(con);
			System.out.println("DB업데이트성공");
		}else {
			rollback(con);
			System.out.println("DB업데이트 실패");
		}
			
		close(con);
			
		return updateCount; 
	}
	
	
	//학생 배열에 받아오기
	public ArrayList<StudentVO> studentArticleList(int page, int limit){
		
		ArrayList<StudentVO> studentList = null;
		Connection con = getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);
		studentList = studentDAO.studentArticleList(page,limit);
		close(con);
		
		return studentList;
		
	}
	
	//학생 한명 데이터 받아오기
	public StudentVO selectStudent(String student_id) {
		StudentVO student = null;
		
		Connection con =getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);
		student = studentDAO.selectStudent(student_id);
		close(con);
		
		return student;
	}
	
	//학생 삭제
	public int deleteStudent(String student_id) {
		
		Connection con = getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);
		
		int deleteCount = studentDAO.deleteStudent(student_id);
		
		if(deleteCount>0) {
			commit(con);
			System.out.println("DB삭제성공");
		}else {
			rollback(con);
			System.out.println("DB삭제실패");
		}
		
		close(con);
		
		return deleteCount; 
	}
	
	//학생 리스트 갯수
		public int studentListCount(){
			// TODO Auto-generated method stub
			
			int listCount = 0;
			Connection con = getConnection();
			StudentDAO studentDAO = StudentDAO.getInstance();
			studentDAO.setConnection(con);
			listCount = studentDAO.StudentListCount();
			close(con);
			
			return listCount;
			
		}
	
	// 검색된 학생 수 반환
	public int searchStudentCount(String studentSearch) {
	    Connection con = getConnection();
	    StudentDAO studentDAO = StudentDAO.getInstance();
	    studentDAO.setConnection(con);
	    
	    int listCount = studentDAO.searchStudentCount(studentSearch);
	    System.out.println("검색된 갯수:" + listCount);
	    close(con);
	    
	    return listCount;
	}

	// 검색된 학생 리스트 반환
	public ArrayList<StudentVO> searchStudentList(int page, int limit, String studentSearch) {
	    Connection con = getConnection();
	    StudentDAO studentDAO = StudentDAO.getInstance();
	    studentDAO.setConnection(con);
	    
	    ArrayList<StudentVO> studentList = studentDAO.searchStudentList(page, limit, studentSearch);
	    close(con);
	    
	    return studentList;
	}
}
