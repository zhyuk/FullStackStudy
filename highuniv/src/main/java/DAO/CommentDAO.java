package dao;

import static db.JdbcUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.CommentBean;

public class CommentDAO {

    DataSource ds;
    Connection con;
    private static CommentDAO commentDAO;

    private CommentDAO() {
    }

    public static CommentDAO getInstance() {
        if (commentDAO == null) {
            commentDAO = new CommentDAO();
        }
        return commentDAO;
    }

    public void setConnection(Connection con) {
        this.con = con;
    }

    // 댓글 등록
    public int insertComment(CommentBean comment) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int no = 0;
        String sql = null;
        int insertCount = 0;
        
        try {
			pstmt = con.prepareStatement("SELECT MAX(COMMENT_NO) FROM board_comment");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				no = rs.getInt(1) + 1;
			} else {
				no = 1; // 댓글이 없을 경우 1부터 시작
			}
			
			sql = "INSERT INTO board_comment (BOARD_NO, COMMENT_ID, COMMENT_NAME, COMMENT_CONTENT, COMMENT_DATE, COMMENT_NO)"
					+ "VALUES (?, ?, ?, ?, SYSDATE, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, comment.getBOARD_NO());
			pstmt.setString(2, comment.getCOMMENT_ID());
			pstmt.setString(3, comment.getCOMMENT_NAME());
			pstmt.setString(4, comment.getCOMMENT_CONTENT());
			pstmt.setInt(5, no);
            
            insertCount = pstmt.executeUpdate();
            
        } catch (Exception ex) {
			System.out.println("boardInsert 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}

    // 댓글 목록 조회
    public ArrayList<CommentBean> selectCommentList(int board_no) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<CommentBean> commentList = new ArrayList<>();

        try {
            pstmt = con.prepareStatement("SELECT BOARD_NO, COMMENT_ID, COMMENT_NAME, COMMENT_CONTENT, COMMENT_NO, COMMENT_DATE FROM board_comment WHERE BOARD_NO = ? ORDER BY COMMENT_DATE DESC");
            pstmt.setInt(1, board_no);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CommentBean comment = new CommentBean();
                comment.setBOARD_NO(rs.getInt("BOARD_NO"));
                comment.setCOMMENT_ID(rs.getString("COMMENT_ID"));
                comment.setCOMMENT_NAME(rs.getString("COMMENT_NAME"));
                comment.setCOMMENT_CONTENT(rs.getString("COMMENT_CONTENT"));
                comment.setCOMMENT_NO(rs.getInt("COMMENT_NO"));
                comment.setCOMMENT_DATE(rs.getDate("COMMENT_DATE"));
                commentList.add(comment);
            }
        } catch (Exception ex) {
            System.out.println("selectCommentList 에러 : " + ex);
        } finally {
            close(rs);
            close(pstmt);
        }

        return commentList;
    }

    // 댓글 개수 조회
    public int getCommentCount(int board_no) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM board_comment WHERE BOARD_NO = ?");
            pstmt.setInt(1, board_no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.println("getCommentCount 에러 : " + ex);
        } finally {
            close(rs);
            close(pstmt);
        }

        return count;
    }

    // 댓글 삭제
    public int deleteComment(int comment_No) {
        PreparedStatement pstmt = null;
        int deleteCount = 0;

        try {
            pstmt = con.prepareStatement("DELETE FROM board_comment WHERE COMMENT_NO = ?");
            pstmt.setInt(1, comment_No);
            deleteCount = pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("deleteComment 에러 : " + ex);
        } finally {
            close(pstmt);
        }

        return deleteCount;
    }
    
 // 글쓴이인지 확인.
    public boolean isCommentWriter(int comment_no, String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String comment_sql = "select * from board_comment where COMMENT_NO=?";
		boolean isWriter = false;

		try {
			pstmt = con.prepareStatement(comment_sql);
			pstmt.setInt(1, comment_no);
			rs = pstmt.executeQuery();
			rs.next();

			if (id.equals("admin") || id.equals(rs.getString("BOARD_ID"))) {
				isWriter = true;
			}
		} catch (SQLException ex) {
			System.out.println("isBoardWriter 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return isWriter;

	}
}
