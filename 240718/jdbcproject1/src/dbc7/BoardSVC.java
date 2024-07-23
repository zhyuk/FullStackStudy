package dbc7;

// static 키워드를 통해 import 했기 때문에 클래스명.메소드명이 아닌 메소드명으로 바로 접근할 수 있다.
import static dbc7.db.JdbcUtil.close;
import static dbc7.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BoardSVC {
	Connection con;

	public BoardVO getBoardVO(Scanner sc) {
		System.out.println("=== 게시물 등록 ===");
		System.out.println("작성자 : "); 
		String writer = sc.next(); // 홍길동
		System.out.println("비밀번호 : ");
		String passwd = sc.next(); // 1111
		
		System.out.println("제목 : ");
		sc.nextLine();
		String subject = sc.nextLine(); // 테스트 글입니다.
		System.out.println("이메일 : ");
		String email = sc.next(); // hgd@a.b
										// 0 , "홍길동", "1111", "테스트 글입니다.", "hgd@a.b"
//		System.out.println(writer + "/" + passwd + "/" + subject + "/" + email );
		BoardVO boardVO = new BoardVO(0, writer, passwd, subject, email);
		return boardVO;
	}

	public void writeArticle(Scanner sc) {
		BoardVO boardVO = getBoardVO(sc);
		con = getConnection();
		PreparedStatement ps = null;

		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, boardVO.getWriter());
			ps.setString(2, boardVO.getPasswd());
			ps.setString(3, boardVO.getSubject());
			ps.setString(4, boardVO.getEmail());

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("글 등록 완료");
			} else {
				System.out.println("글 등록 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}
	}

	public void showArticleList() {
		con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from board";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("\t 아이디 \t 작성자 \t 제목 \t 이메일");
			while (rs.next()) {
				System.out.println("\t" + rs.getInt("id") + "\t" + rs.getString("writer") + "\t"
						+ rs.getString("subject") + "\t" + rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(con);
		}
	}

	public void showArticle(Scanner sc) {
		System.out.println("검색할 글 번호를 입력하세요.");
		System.out.println("글 번호 : ");
		int id = sc.nextInt();
		BoardVO boardVO = getArticle(id);
		System.out.println(boardVO);
	}

	private BoardVO getArticle(int id) {
		BoardVO boardVO = null;
		con = getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board where id = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				int dbId = rs.getInt("id");
				String writer = rs.getString("writer");
				String passwd = rs.getString("passwd");
				String subject = rs.getString("subject");
				String email = rs.getString("email");

				boardVO = new BoardVO(dbId, writer, passwd, subject, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(con);
		}
		return boardVO;
	}

	public void deleteArticle(Scanner sc) {
		System.out.println("삭제할 글 번호를 입력하세요.");
		System.out.println("글 번호 : ");
		int id = sc.nextInt();

		int count = deleteArticle(id);
		if (count > 0)
			System.out.println("글 삭제 완료");
		else
			System.out.println("글 삭제 실패");
	}

	private int deleteArticle(int id) {
		int deleteCount = 0;
		con = getConnection();
		PreparedStatement ps = null;

		String sql = "delete board where id = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			deleteCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}
		return deleteCount;
	}

	public void updateArticle(Scanner sc) {
		System.out.println("수정할 글 번호를 입력하세요.");
		System.out.println("글 번호 : ");
		int id = sc.nextInt();

		BoardVO boardVO = getArticle(id);
		System.out.println("수정할 데이터를 입력하세요.");
		System.out.println("원래 작성자 : " + boardVO.getWriter());
		System.out.println("수정할 작성자 : ");
		String writer = sc.next();

		System.out.println("원래 비밀번호 : " + boardVO.getPasswd());
		System.out.println("수정할 비밀번호 : ");
		String passwd = sc.next();

		System.out.println("원래 제목 : " + boardVO.getSubject());
		System.out.println("수정할 제목 : ");
		String subject = sc.next();

		System.out.println("원래 이메일 : " + boardVO.getEmail());
		System.out.println("수정할 이메일 : ");
		String email = sc.next();

		boardVO.setWriter(writer);
		boardVO.setPasswd(passwd);
		boardVO.setSubject(subject);
		boardVO.setEmail(email);

		int count = updateArticle(boardVO);
		if (count > 0)
			System.out.println("글 수정 완료");
		else
			System.out.println("글 수정 실패");
	}

	private int updateArticle(BoardVO boardVO) {
		int updateCount = 0;
		con = getConnection();
		PreparedStatement ps = null;

		String sql = "update board set writer = ?, passwd = ?, subject = ?, email= ? where id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, boardVO.getWriter());
			ps.setString(2, boardVO.getPasswd());
			ps.setString(3, boardVO.getSubject());
			ps.setString(4, boardVO.getEmail());
			ps.setInt(5, boardVO.getId());
			updateCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}
		return updateCount;
	}
}
