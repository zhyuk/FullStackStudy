package vo;

import java.sql.Date;

public class BoardBean {

	private int BOARD_NUM;
	private String BOARD_ID = "admin";
	private String BOARD_NAME = "관리자";
	private String BOARD_SUBJECT;
	private String BOARD_CONTENT;
	private String BOARD_FILE;
	private int BOARD_READCOUNT;
	private Date BOARD_DATE;
	private int BOARD_NO;
	private String BOARD_MAIN;


	public int getBOARD_NUM() {
		return BOARD_NUM;
	}


	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}


	public String getBOARD_ID() {
		return BOARD_ID;
	}


	public void setBOARD_ID(String bOARD_ID) {
		BOARD_ID = bOARD_ID;
	}


	public String getBOARD_NAME() {
		return BOARD_NAME;
	}


	public void setBOARD_NAME(String bOARD_NAME) {
		BOARD_NAME = bOARD_NAME;
	}


	public String getBOARD_SUBJECT() {
		return BOARD_SUBJECT;
	}


	public void setBOARD_SUBJECT(String bOARD_SUBJECT) {
		BOARD_SUBJECT = bOARD_SUBJECT;
	}


	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}


	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}


	public String getBOARD_FILE() {
		return BOARD_FILE;
	}


	public void setBOARD_FILE(String bOARD_FILE) {
		BOARD_FILE = bOARD_FILE;
	}


	public int getBOARD_READCOUNT() {
		return BOARD_READCOUNT;
	}


	public void setBOARD_READCOUNT(int bOARD_READCOUNT) {
		BOARD_READCOUNT = bOARD_READCOUNT;
	}


	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}


	public void setBOARD_DATE(Date bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}


	public int getBOARD_NO() {
		return BOARD_NO;
	}


	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}


	public String getBOARD_MAIN() {
		return BOARD_MAIN;
	}


	public void setBOARD_MAIN(String bOARD_MAIN) {
		BOARD_MAIN = bOARD_MAIN;
	}


	@Override
	public String toString() {
		return "BoardBean [BOARD_NUM=" + BOARD_NUM + ", BOARD_NAME=" + BOARD_NAME + ", BOARD_SUBJECT=" + BOARD_SUBJECT
				+ ", BOARD_CONTENT=" + BOARD_CONTENT + ", BOARD_FILE=" + BOARD_FILE + ", BOARD_READCOUNT="
				+ BOARD_READCOUNT + ", BOARD_DATE=" + BOARD_DATE + ", BOARD_NO=" + BOARD_NO + ", BOARD_MAIN="
				+ BOARD_MAIN + "]";
	}

	
}