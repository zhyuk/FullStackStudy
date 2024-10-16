package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.BoardBean;

public class BoardDAO {

	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글의 개수 구하기.
	public int selectListCount() {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;

	}
	
	//검색시 글 개수 구하기
	public int selectSearchListCount(String type, String keyword) throws Exception {
	    int listCount = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String[] typeArr = type.split(",");

	    try {
	        String sql = "";
	        sql += "SELECT COUNT(*) FROM board WHERE ";
	        if(typeArr.length <= 1) {
	        	 sql += type + " LIKE ?";
	        } else {
	        	for (int i = 0; i < typeArr.length; i++) {
					if (i == 0)
						sql += typeArr[i] + " LIKE ? "; // 검색 조건 추가
					else
						sql += " or  " + typeArr[i] + " LIKE ? "; // 검색 조건 추가
				}
	        }
	       System.out.println("sql : " + sql);
	        pstmt = con.prepareStatement(sql);

	        if (typeArr.length <= 1) {
	        pstmt.setString(1, "%" + keyword + "%");
	        } else { 
	        	int i = 1;
				for (; i <= typeArr.length; i++) {
					pstmt.setString(i, "%" + keyword + "%");
				}
	        }
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            listCount = rs.getInt(1);
	        }
	    } catch (SQLException ex) {
	        System.out.println("selectSearchListCount 에러 : " + ex);
	    } finally {
	        close(rs);
	        close(pstmt);
	    }

	    return listCount;
	}

	
	// 특정 게시글에 대한 댓글 수 가져오기
	public int getCommentCount(int board_no) {
	    int commentCount = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        String sql = "SELECT COUNT(*) FROM board_comment WHERE BOARD_NO = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, board_no);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            commentCount = rs.getInt(1);
	        }
	    } catch (SQLException ex) {
	        System.out.println("getCommentCount 에러: " + ex);
	    } finally {
	        close(rs);
	        close(pstmt);
	    }

	    return commentCount;
	}
	
	
	// 글 목록 보기.
	public ArrayList<BoardBean> selectArticleList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 공지사항을 가장 위에 두고, 나머지 게시글을 내림차순으로 정렬하는 SQL 쿼리
		String board_list_sql = "SELECT * FROM (" + "  SELECT * FROM (" + "    SELECT rownum rnum, A.* FROM ("
				+ "      SELECT * FROM board " + "      ORDER BY CASE WHEN BOARD_MAIN = 'M' THEN 0 ELSE 1 END, "
				+ "               BOARD_NO DESC " + "    ) A" + "  ) WHERE rownum <= ?" + ") WHERE rnum >= ?";

		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();

		int startrow = (page - 1) * limit + 1; // startNum에 해당되는 변수
		int endrow = page * limit; // endNum에 해당되는 변수

		try {
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, endrow);
			pstmt.setInt(2, startrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBean board = new BoardBean();
				board.setBOARD_NO(rs.getInt("BOARD_NO"));
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				articleList.add(board);
			}

		} catch (Exception ex) {
			System.out.println("getBoardList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	public ArrayList<BoardBean> searchArticleList(String type, String keyword, int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();

		int startrow = (page - 1) * limit + 1; // 시작 번호
		int endrow = page * limit; // 끝 번호
		String[] typeArr = type.split(",");

		String sql = "";
		sql += "SELECT * FROM (";
		sql += "  SELECT * FROM (";
		sql += "    SELECT rownum rnum, A.* FROM (";
		sql += "      SELECT * FROM board WHERE 1=1 ";
		if (typeArr.length <= 1) {
			sql += " and  " + type + " LIKE ? "; // 검색 조건 추가
		} else {
			for (int i = 0; i < typeArr.length; i++) {
				if (i == 0)
					sql += " and  ( " + typeArr[i] + " LIKE ? "; // 검색 조건 추가
				else if (i != typeArr.length - 1)
					sql += " or  " + typeArr[i] + " LIKE ? "; // 검색 조건 추가
				else
					sql += " or  " + typeArr[i] + " LIKE ?  )"; // 검색 조건 추가
			}
		}
		sql += "      ORDER BY CASE WHEN BOARD_MAIN = 'M' THEN 0 ELSE 1 END, ";
		sql += "               BOARD_NO DESC ";
		sql += "    ) A";
		sql += "  ) WHERE rownum <= ?";
		sql += ") WHERE rnum >= ?";
		try {

			pstmt = con.prepareStatement(sql);
			if (typeArr.length <= 1) {
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setInt(2, endrow);
				pstmt.setInt(3, startrow);
			} else {
				int i = 1;
				for (; i <= typeArr.length; i++) {
					pstmt.setString(i, "%" + keyword + "%");
				}

				pstmt.setInt(i, endrow);
				pstmt.setInt(++i, startrow);

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBean board = new BoardBean();
				board.setBOARD_NO(rs.getInt("BOARD_NO"));
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				articleList.add(board);
			}

		} catch (Exception ex) {
			System.out.println("searchArticleList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;
	}

	// 글 내용 보기.
	public BoardBean selectArticle(int board_no) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try {
			pstmt = con.prepareStatement("select * from board where BOARD_NO = ?");
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardBean = new BoardBean();
				boardBean.setBOARD_ID(rs.getString("BOARD_ID"));
				boardBean.setBOARD_NO(rs.getInt("BOARD_NO"));
				boardBean.setBOARD_NAME(rs.getString("BOARD_NAME"));
				boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardBean.setBOARD_MAIN(rs.getString("BOARD_MAIN"));
			}
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardBean;

	}

	// 글 등록.
	public int insertArticle(BoardBean article) {

		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		int num = 0;
		int no = 0;
		String sql = null;
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement("SELECT MAX(board_no) FROM board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				no = rs.getInt(1) + 1;
			} else {
				no = 1; // 게시글이 없을 경우 1부터 시작
			}

			if ("M".equals(article.getBOARD_MAIN())) {
				num = 0; // 공지사항일 경우 no를 0으로 설정
			} else {
				pstmt2 = con.prepareStatement("SELECT MAX(board_num) FROM board");
				rs2 = pstmt2.executeQuery();

				if (rs2.next()) {
					num = rs2.getInt(1) + 1;
				} else {
					num = 1; // 게시글이 없을 경우 1부터 시작
				}
			}

			// Insert query 작성
			sql = "INSERT INTO board (BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_READCOUNT, BOARD_DATE, BOARD_NO, BOARD_MAIN, BOARD_ID) "
					+ "VALUES (?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_SUBJECT());
			pstmt.setString(4, article.getBOARD_CONTENT());
			pstmt.setString(5, article.getBOARD_FILE());
			pstmt.setInt(6, 0);
			pstmt.setInt(7, no);
			pstmt.setString(8, article.getBOARD_MAIN());
			pstmt.setString(9, article.getBOARD_ID());

			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("boardInsert 에러 : " + ex);
		} finally {
			close(rs2);
			close(rs);
			close(pstmt2);
			close(pstmt);
		}

		return insertCount;
	}

	// 글 수정.
	public int updateArticle(BoardBean article) {
	    int updateCount = 0;
	    PreparedStatement pstmt = null;
	    PreparedStatement pstmt2 = null;
	    ResultSet rs2 = null;
	    String sql = null;
	    int num = 0;

	    if ("M".equals(article.getBOARD_MAIN())) {
	        sql = "UPDATE board SET BOARD_SUBJECT=?, BOARD_CONTENT=?, BOARD_NUM=?, BOARD_MAIN=? WHERE BOARD_NO=?";
	        try {
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, article.getBOARD_SUBJECT());
	            pstmt.setString(2, article.getBOARD_CONTENT());
	            pstmt.setInt(3, num);
	            pstmt.setString(4, article.getBOARD_MAIN());
	            pstmt.setInt(5, article.getBOARD_NO());
	            updateCount = pstmt.executeUpdate();
	        } catch (Exception ex) {
	            System.out.println("boardModify 에러 : " + ex);
	        } finally {
	            close(pstmt);
	        }

	    } else {
	        if (article.getBOARD_NUM() == 0) {
	            try {
	                pstmt2 = con.prepareStatement("SELECT MAX(board_num) FROM board");
	                rs2 = pstmt2.executeQuery();
	                if (rs2.next()) {
	                    num = rs2.getInt(1) + 1;
	                }

	                sql = "UPDATE board SET BOARD_SUBJECT=?, BOARD_CONTENT=?, BOARD_NUM=?, BOARD_MAIN=? WHERE BOARD_NO=?";
	                pstmt = con.prepareStatement(sql);
	                pstmt.setString(1, article.getBOARD_SUBJECT());
	                pstmt.setString(2, article.getBOARD_CONTENT());
	                pstmt.setInt(3, num); 
	                pstmt.setString(4, article.getBOARD_MAIN());
	                pstmt.setInt(5, article.getBOARD_NO()); 
	                updateCount = pstmt.executeUpdate();
	            } catch (Exception ex) {
	                System.out.println("boardModify 에러 : " + ex);
	            } finally {
	                close(rs2);
	                close(pstmt2);
	                close(pstmt);
	            }
	        } else {
	            sql = "UPDATE board SET BOARD_SUBJECT=?, BOARD_CONTENT=? WHERE BOARD_NO=?";
	            try {
	                pstmt = con.prepareStatement(sql);
	                pstmt.setString(1, article.getBOARD_SUBJECT());
	                pstmt.setString(2, article.getBOARD_CONTENT());
	                pstmt.setInt(3, article.getBOARD_NO());
	                updateCount = pstmt.executeUpdate();
	            } catch (Exception ex) {
	                System.out.println("boardModify 에러 : " + ex);
	            } finally {
	                close(pstmt);
	            }
	        }
	    }
	    return updateCount;
	}


	// 글 삭제.
	public int deleteArticle(int board_no) {

		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String board_delete_sql = "delete from board where BOARD_NO=?";
		String comment_delete_sql = "delete from board_comment where BOARD_NO=?";
		int deleteCount = 0;

		try {

			pstmt = con.prepareStatement(board_delete_sql);
			pstmt2 = con.prepareStatement(comment_delete_sql);
			System.out.println("DAO : " + board_no);

			pstmt.setInt(1, board_no);
			pstmt2.setInt(1, board_no);
			deleteCount = pstmt.executeUpdate();
			pstmt2.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardDelete 에러 : " + ex);
		} finally {
			close(pstmt2);
			close(pstmt);
		}

		return deleteCount;

	}

	// 조회수 업데이트.
	public int updateReadCount(int board_no) {

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update board set BOARD_READCOUNT = " + "BOARD_READCOUNT+1 where BOARD_NO = " + board_no;

		try {
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("setReadCountUpdate 에러 : " + ex);
		} finally {
			close(pstmt);

		}

		return updateCount;

	}

	// 글쓴이인지 확인.
	public boolean isArticleBoardWriter(int board_no, String session_id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql = "select * from board where BOARD_NO=?";
		boolean isWriter = false;

		try {
			pstmt = con.prepareStatement(board_sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			rs.next();

			if (session_id.equals("admin") || session_id.equals(rs.getString("BOARD_ID"))) {
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
