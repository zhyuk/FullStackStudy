package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.MemberBean;
import static db.JdbcUtil.*;

public class MemberDAO {
	public static MemberDAO instance; // null -> &300
	Connection con; // null -> &400 -> MemberJoinService의 24번 행에 의해 close
	PreparedStatement pstmt; // null
	ResultSet rs; // null
	DataSource ds; // null

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO(); // &300. MemberDAO 클래스 복제본
		}
		return instance;
	}

	public void setConnection(Connection con) { // &400
		this.con = con;
	}

	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql = "SELECT MEMBER_ID FROM MEMBER1 WHERE MEMBER_ID=? AND MEMBER_PW=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMEMBER_ID());
			pstmt.setString(2, member.getMEMBER_PW());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginId = rs.getString("MEMBER_ID");
			}
		} catch (Exception ex) {
			System.out.println(" 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginId;
	}

	public int insertMember(MemberBean member) { // &100
		String sql = "INSERT INTO MEMBER1 VALUES (?,?,?,?,?,?)";
		int insertCount = 0;

		try {
//			INSERT INTO MEMBER1 VALUES ('admin','1111','관리자',55,'남','admin@hi.com')
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMEMBER_ID()); // admin
			pstmt.setString(2, member.getMEMBER_PW()); // 1111
			pstmt.setString(3, member.getMEMBER_NAME()); // 관리자
			pstmt.setInt(4, member.getMEMBER_AGE()); // 55
			pstmt.setString(5, member.getMEMBER_GENDER()); // 남
			pstmt.setString(6, member.getMEMBER_EMAIL()); // admin@hi.com
			insertCount = pstmt.executeUpdate(); // 처리되면 1 반환함.

		} catch (Exception ex) {
			System.out.println("joinMember 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount; // 1 반환
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql = "SELECT * FROM MEMBER1";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean mb = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					mb = new MemberBean();
					mb.setMEMBER_ID(rs.getString("MEMBER_ID"));
					mb.setMEMBER_PW(rs.getString("MEMBER_PW"));
					mb.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
					mb.setMEMBER_AGE(rs.getInt("MEMBER_AGE"));
					mb.setMEMBER_GENDER(rs.getString("MEMBER_GENDER"));
					mb.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
					memberList.add(mb);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public MemberBean selectMember(String id) {
		String sql = "SELECT * FROM MEMBER1 WHERE MEMBER_ID=?";
		MemberBean mb = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new MemberBean();
				mb.setMEMBER_ID(rs.getString("MEMBER_ID"));
				mb.setMEMBER_PW(rs.getString("MEMBER_PW"));
				mb.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
				mb.setMEMBER_AGE(rs.getInt("MEMBER_AGE"));
				mb.setMEMBER_GENDER(rs.getString("MEMBER_GENDER"));
				mb.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return mb;
	}

	public int deleteMember(String id) {
		String sql = "DELETE MEMBER1 WHERE MEMBER_ID=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("deleteMember 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}
}