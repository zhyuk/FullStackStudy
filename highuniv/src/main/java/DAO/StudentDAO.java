package dao;

import static util.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import util.JdbcUtil;
import vo.StudentVO;

public class StudentDAO {
	public static StudentDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private StudentDAO() {
		
	}
	public static StudentDAO getInstance(){
		if(instance == null){
			instance = new StudentDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	
	//학생 한명 데이터 받아오기
	public StudentVO selectStudent(String student_id) {
		pstmt =  null;
		rs = null;
		String sql ="";
		StudentVO student = null;
		
		try {
			sql = "select * from student where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = new StudentVO();
				student.setStudent_id(student_id);
				student.setStudent_pw(rs.getString("student_pw"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_email(rs.getString("student_email"));
				student.setStudent_ph(rs.getString("student_ph"));
				student.setStudent_birth(rs.getString("student_birth"));
				student.setStudent_intoday(rs.getString("student_intoday"));
				student.setStudent_year(rs.getInt("student_year"));
				student.setStudent_major(rs.getString("student_major"));
				student.setStudent_address(rs.getString("student_address"));
				student.setStudent_gender(rs.getString("student_gender"));
				student.setStudent_status(rs.getString("student_status"));
				student.setStudent_use(rs.getString("student_use"));
				student.setStudent_image(rs.getString("student_image"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return student;
	}
	
	//학생 등록하기
	public int insertStudent(StudentVO student) {
		pstmt =  null;
		String sql ="";
		int insertCount = 0;
		
		try {
			sql = "insert into student (student_id, student_pw , student_name, student_email, student_ph, student_birth, student_intoday, student_year, student_major, student_address, student_gender, student_status, student_use, student_image)";
			sql += "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getStudent_id());
			pstmt.setString(2, student.getStudent_pw());
			pstmt.setString(3, student.getStudent_name());
			pstmt.setString(4, student.getStudent_email());
			pstmt.setString(5, student.getStudent_ph());
			pstmt.setString(6, student.getStudent_birth());
			pstmt.setString(7, student.getStudent_intoday());
			pstmt.setInt(8, student.getStudent_year());
			pstmt.setString(9, student.getStudent_major());
			pstmt.setString(10, student.getStudent_address());
			pstmt.setString(11, student.getStudent_gender());
			pstmt.setString(12, student.getStudent_status());
			pstmt.setString(13, student.getStudent_use());
			pstmt.setString(14,student.getStudent_image());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("StudentInsert 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	//학생 목록 구하기
	public int StudentListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			pstmt=con.prepareStatement("select count(*) from student");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	//학생 페이지목록 보기.	
	public ArrayList<StudentVO> studentArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String student_list_sql="select * from (select rownum rnum, A.* from (select * from student order by STUDENT_ID desc ) A ) where rnum between ? and ?";
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		int startrow=(page-1)*limit+1; //읽기 시작할 row 번호..	
		int endrow=(page-1)*limit+limit;

		try{
			pstmt = con.prepareStatement(student_list_sql);	
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				StudentVO student = new StudentVO();
				student.setStudent_id(rs.getString("student_id"));
				student.setStudent_pw(rs.getString("student_pw"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_email(rs.getString("student_email"));
				student.setStudent_ph(rs.getString("student_ph"));
				student.setStudent_birth(rs.getString("student_birth"));
				student.setStudent_intoday(rs.getString("student_intoday"));
				student.setStudent_year(rs.getInt("student_year"));;
				student.setStudent_major(rs.getString("student_major"));
				student.setStudent_address(rs.getString("student_address"));
				student.setStudent_gender(rs.getString("student_gender"));
				if(student.getStudent_gender().equals("F")) {
					student.setStudent_gender("여");
				}else {
					student.setStudent_gender("남");
				}
				student.setStudent_status(rs.getString("student_status"));
				student.setStudent_use(rs.getString("student_use"));
				student.setStudent_image(rs.getString("student_image"));
				studentList.add(student);
			}

		}catch(Exception ex){
			System.out.println("studentArticleList 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}
			return studentList;
	}
	
	//해당 학생삭제하기
	public int deleteStudent(String student_id) {
		pstmt =  null;
		String sql ="";
		int deleteCount = 0;
		
		try {
			sql = "delete student where student_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			
			deleteCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("deleteStudent 에러 : "+e);
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	//학생 수정하기
	public int updateStudent(StudentVO student) {
		pstmt =  null;
		String sql ="";
		int updateCount = 0;
		
		try {
			sql = "UPDATE student SET student_pw = ?, student_name = ?, student_email = ?, student_ph = ?, student_birth = ?, "
				+ "student_intoday = ?, student_year = ?, student_major = ?, student_address = ?, student_gender = ?, student_status = ?, "
				+ "student_use = ?, student_image = ? WHERE student_id = ?";
			System.out.println(sql);
			System.out.println(student);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getStudent_pw());
			pstmt.setString(2, student.getStudent_name());
			pstmt.setString(3, student.getStudent_email());
			pstmt.setString(4, student.getStudent_ph());
			pstmt.setString(5, student.getStudent_birth());
			pstmt.setString(6, student.getStudent_intoday());
			pstmt.setInt(7, student.getStudent_year());
			pstmt.setString(8, student.getStudent_major());
			pstmt.setString(9, student.getStudent_address());
			pstmt.setString(10, student.getStudent_gender());
			pstmt.setString(11, student.getStudent_status());
			pstmt.setString(12, student.getStudent_use());
			pstmt.setString(13,student.getStudent_image());
			pstmt.setString(14, student.getStudent_id());
				
			updateCount = pstmt.executeUpdate();
				
		} catch (Exception e) {
			System.out.println("updateStudent 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	// 검색된 학생의 수 구하기
	public int searchStudentCount(String studentSearch) {
	    int listCount = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        pstmt = con.prepareStatement("SELECT COUNT(*) FROM student WHERE student_name LIKE ? OR student_id LIKE ?");
	        pstmt.setString(1, "%" + studentSearch + "%");
	        pstmt.setString(2, "%" + studentSearch + "%");	        
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            listCount = rs.getInt(1);
	        }
	    } catch (Exception ex) {
	        System.out.println("searchStudentCount 에러: " + ex);			
	    } finally {
	        close(rs);
	        close(pstmt);
	    }
	    
	    return listCount;
	}
	
	// 검색된 학생 리스트 구하기
	public ArrayList<StudentVO> searchStudentList(int page, int limit, String studentSearch) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
	    int startrow = (page - 1) * limit + 1;
	    int endrow = page * limit;
	    
	    try {
	        String query = "SELECT * FROM (SELECT ROWNUM rnum, A.* FROM "
	                     + "(SELECT * FROM student WHERE student_name LIKE ?  OR student_id LIKE ? ORDER BY student_id DESC) A "
	                     + ") WHERE rnum BETWEEN ? AND ?";
	        
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, "%" + studentSearch + "%");
	        pstmt.setString(2, "%" + studentSearch + "%");
	        pstmt.setInt(3, startrow);
	        pstmt.setInt(4, endrow);
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            StudentVO student = new StudentVO();
	            student.setStudent_id(rs.getString("student_id"));
	            student.setStudent_pw(rs.getString("student_pw"));
	            student.setStudent_name(rs.getString("student_name"));
	            student.setStudent_email(rs.getString("student_email"));
	            student.setStudent_ph(rs.getString("student_ph"));
	            student.setStudent_birth(rs.getString("student_birth"));
	            student.setStudent_intoday(rs.getString("student_intoday"));
	            student.setStudent_year(rs.getInt("student_year"));
	            student.setStudent_major(rs.getString("student_major"));
	            student.setStudent_address(rs.getString("student_address"));
	            student.setStudent_gender(rs.getString("student_gender"));
	            if(student.getStudent_gender().equals("F")) {
					student.setStudent_gender("여");
				}else {
					student.setStudent_gender("남");
				}
	            student.setStudent_status(rs.getString("student_status"));
	            student.setStudent_use(rs.getString("student_use"));
	            student.setStudent_image(rs.getString("student_image"));
	            
	            studentList.add(student);
	        }
	    } catch (Exception ex) {
	        System.out.println("searchStudentList 에러: " + ex);
	    } finally {
	        close(rs);
	        close(pstmt);
	    }
	    
	    return studentList;
	}
	public boolean updateStudentInfo(String studentId, Map<String, String> updateFields) throws SQLException {
	    if (updateFields.isEmpty()) {
	        return false;
	    }

	    StringBuilder sql = new StringBuilder("UPDATE STUDENT SET ");
	    List<String> setClauses = new ArrayList<>();
	    for (String field : updateFields.keySet()) {
	        setClauses.add(field + " = ?");
	    }
	    sql.append(String.join(", ", setClauses));
	    sql.append(" WHERE STUDENT_ID = ?");

	    PreparedStatement pstmt = null;
	    try {
	        pstmt = con.prepareStatement(sql.toString());
	        System.out.println("sql문: "+sql.toString());
	        int index = 1;
	        for (String field : updateFields.keySet()) {
	        	String str = updateFields.get(field);
	        	
	            pstmt.setString(index, str);
	            System.out.println("바인드변수["+index+"] :  " + str);
	            index++;
	        }
	        pstmt.setString(index, studentId);

	        int rowsAffected = pstmt.executeUpdate();
	        if(rowsAffected > 0) {
	        	JdbcUtil.commit(con);
	        	return true;
	        }else {
	        	JdbcUtil.rollback(con);
	        	return false;
	        	
	        }
	    } finally {
	        if (pstmt != null) try { pstmt.close(); } catch (Exception ignore) {}
	    }
	}
}
