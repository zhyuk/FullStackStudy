package dbc2;
import java.sql.*;


public class Ex02 {
	public static void main(String[] args){
		Connection conn = null; // 객체를 finally에서 닫아주기 위해 선언
		PreparedStatement ps =  null; // 객체를 finally에서 닫아주기 위해 선언
		try {
			// 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "test";
			String password = "1111";
			conn = DriverManager.getConnection(url, user, password);
			// 명령문 객체 생성
			String sql = "insert into dept (deptno, dname, loc) values (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			// 명령문 객체 실행
			ps.setInt(1, 50 );
			ps.setString(2, "개발");
			ps.setString(3, "서울");
			int result = ps.executeUpdate();

			if(result > 0){
				System.out.println("데이터 수정 완료");
				System.out.println("처리된 행 수는 " + result + " 줄 입니다.");
			} else{
				System.err.println("데이터 수정 실패");
			}
		} catch(Exception e){
			System.out.println("드라이버 설치 또는 DB 연결 중 에러발생");
		} finally {
			// 객체 닫기 : 혹시 모를 에러에 의해 객체를 닫지 못하는 상황을 대비해 finally에서 객체를 닫아주는 것이 좋다. 
			try {
				if(ps != null) ps.close();
				if(conn != null)conn.close();
			} catch(SQLException e){
				System.out.println("객체 닫기에 실패했습니다.");
			}
		}
		
	}
}
