package vo;

import java.sql.Date;

public class CommentBean {

	private int BOARD_NO;
	private String COMMENT_ID;
	private String COMMENT_NAME;
	private String COMMENT_CONTENT;
	private Date COMMENT_DATE;
	private int COMMENT_NO;

	public CommentBean() {
		this.COMMENT_ID = "admin"; // 기본값 설정
		this.COMMENT_NAME = "관리자"; // 기본값 설정
	}

	public int getBOARD_NO() {
		return BOARD_NO;
	}

	public void setBOARD_NO(int boardNo) {
		BOARD_NO = boardNo;
	}

	public String getCOMMENT_ID() {
		return COMMENT_ID;
	}

	public void setCOMMENT_ID(String commentId) {
		COMMENT_ID = commentId;
	}

	public String getCOMMENT_NAME() {
		return COMMENT_NAME;
	}

	public void setCOMMENT_NAME(String commentName) {
		COMMENT_NAME = commentName;
	}

	public String COMMENT_NO() {
		return COMMENT_CONTENT;
	}

	public String getCOMMENT_CONTENT() {
		return COMMENT_CONTENT;
	}

	public void setCOMMENT_CONTENT(String commentContent) {
		COMMENT_CONTENT = commentContent;
	}

	public Date getCOMMENT_DATE() {
		return COMMENT_DATE;
	}

	public void setCOMMENT_DATE(Date cOMMENT_DATE) {
		COMMENT_DATE = cOMMENT_DATE;
	}

	public int getCOMMENT_NO() {
		return COMMENT_NO;
	}

	public void setCOMMENT_NO(int commentNo) {
		COMMENT_NO = commentNo;
	}
}
