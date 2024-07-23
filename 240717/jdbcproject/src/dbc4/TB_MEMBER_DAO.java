package dbc4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// DAO(=Data Access Object) : SQL명령문을 담고 있는 클래스
public class TB_MEMBER_DAO {

//	-- 회원 로그인
//	select * from tb_member where m_yn = 'Y' and m_userid = 'honggd123' and m_pwd = '1234';
	public TB_MEMBER_VO login(String userid, String password) {
		String sql = "select * from tb_member where m_yn = 'Y' and m_userid = ? and m_pwd = ?";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TB_MEMBER_VO tvo = null; // 초기화값이 new TB_MEMBER_VO();이면 값이 없어도 null 값이 아니기 때문에 값이 없어도 리턴될 수 있음. 따라서 null로
									// 선언

		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				tvo = new TB_MEMBER_VO(); // tvo 객체는 TB_MEMEBER_VO 클래스를 인스턴스한 객체임
				tvo.setM_seq(rs.getInt("m_seq")); // tvo에 접근(=B_MEMEBER_VO 클래스에 접근)해서 setM_seq 메소드 실행 -> 매개변수로
													// rs.getInt("m_seq")를 넣는다.
				tvo.setM_userid(rs.getString("m_userid"));
				tvo.setM_pwd(rs.getString("m_pwd"));
				tvo.setM_email(rs.getString("m_email"));
				tvo.setM_hp(rs.getString("m_hp"));
				tvo.setM_registdate(rs.getString("m_registdate"));
				tvo.setM_point(rs.getInt("m_point"));
				tvo.setM_yn(rs.getString("m_yn"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				DBConnec1.close(); // DB 정보를 가져온 곳에서 닫아주는 것이 좋다. 따라서 DBConnec1 클래스의 close() 메소드 실행. -> 메소드 안에 연결
									// 해제하는 코드 적어둬야함
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return tvo;
	}

//	--전체회원목록 조회(보기)
//	select * from tb_member; -- ArrayList<> 클래스 이용
	public ArrayList<TB_MEMBER_VO> memberList() {
		String sql = "select * from tb_member";
		ArrayList<TB_MEMBER_VO> mList = new ArrayList<TB_MEMBER_VO>(); // 칸 수가 생성되지 않기 때문에 new로 생성해도 됨

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DBConnec1.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				TB_MEMBER_VO tvo = new TB_MEMBER_VO(); // while문 밖에서 객체 생성을 진행하고 add하면 마지막에 담긴 값만 담기기 때문에 이곳에서 생성
				tvo.setM_seq(rs.getInt("m_seq"));
				tvo.setM_userid(rs.getString("m_userid"));
				tvo.setM_pwd(rs.getString("m_pwd"));
				tvo.setM_email(rs.getString("m_email"));
				tvo.setM_hp(rs.getString("m_hp"));
				tvo.setM_registdate(rs.getString("m_registdate"));
				tvo.setM_point(rs.getInt("m_point"));
				tvo.setM_yn(rs.getString("m_yn"));
				mList.add(tvo); // 1줄에 대한 값의 주소값을 mList에 담음
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				DBConnec1.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return mList;
	}

//	-- 로그인한 사용자 정보보기(내 정보보기, 특정사용자 검색 메뉴)
//	select * from tb_member where m_userid = ? and  m_yn = 'Y'; -- VO,DTO 클래스 이용
	public TB_MEMBER_VO selOne(String userid) {
		String sql = "select * from tb_member where m_userid = ? and  m_yn = 'Y'";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		TB_MEMBER_VO tvo = null;

		try {
			con = DBConnec1.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				tvo = new TB_MEMBER_VO();
				tvo.setM_userid(rs.getString(userid));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				DBConnec1.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return tvo;
	}

//	-- 회원가입
//	insert into tb_member (m_seq, m_userid, m_pwd, m_email, m_hp) values (seq_tb_member.nextval, ?, ?, ?, ?);
	public int join(String userid, String password, String email, String phoneNum) {
		String sql = "insert into tb_member (m_seq, m_userid, m_pwd, m_email, m_hp) values (seq_tb_member.nextval, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement ps = null;
		int rowCount = 0;

		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, phoneNum);
			rowCount = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return rowCount;
	}

//	-- 내정보 수정, 특정사용자 정보  수정
//	update tb_member set m_email = 'hhh@hi.com' where m_userid = ? and m_yn = 'Y';
	public void myUpdate() {
	}

//	-- 회원탈퇴
//	update tb_member set m_yn = 'N' where m_userid = ? and  m_pwd = ?; 
	public void notUser() {

	}
}
