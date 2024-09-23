package vo;

public class Subject {
    // 필드 정의
    private String SUBJECT_ID;
    private String SUBJECT_NAME;
    private String SUBJECT_SEMESTER;
    private int SUBJECT_CREDIT;
    private String SUBJECT_STARTTIME;
    private String SUBJECT_ENDTIME;
    private String SUBJECT_DAY;
    private String PROFESSOR_ID;
    private String PROFESSOR_NAME; // 교수 이름 필드
    private String SUBJECT_ROOM;
    private String SUBJECT_CONTENT;
    private String IMAGE_NAME ;

    // Getter 및 Setter 메서드
    public String getSUBJECT_ID() { return SUBJECT_ID; }
    public void setSUBJECT_ID(String SUBJECT_ID) { this.SUBJECT_ID = SUBJECT_ID; }

    public String getSUBJECT_NAME() { return SUBJECT_NAME; }
    public void setSUBJECT_NAME(String SUBJECT_NAME) { this.SUBJECT_NAME = SUBJECT_NAME; }

    public String getSUBJECT_SEMESTER() { return SUBJECT_SEMESTER; }
    public void setSUBJECT_SEMESTER(String SUBJECT_SEMESTER) { this.SUBJECT_SEMESTER = SUBJECT_SEMESTER; }

    public int getSUBJECT_CREDIT() { return SUBJECT_CREDIT; }
    public void setSUBJECT_CREDIT(int SUBJECT_CREDIT) { this.SUBJECT_CREDIT = SUBJECT_CREDIT; }

    public String getSUBJECT_STARTTIME() { return SUBJECT_STARTTIME; }
    public void setSUBJECT_STARTTIME(String SUBJECT_STARTTIME) { this.SUBJECT_STARTTIME = SUBJECT_STARTTIME; }

    public String getSUBJECT_ENDTIME() { return SUBJECT_ENDTIME; }
    public void setSUBJECT_ENDTIME(String SUBJECT_ENDTIME) { this.SUBJECT_ENDTIME = SUBJECT_ENDTIME; }

    public String getSUBJECT_DAY() { return SUBJECT_DAY; }
    public void setSUBJECT_DAY(String SUBJECT_DAY) { this.SUBJECT_DAY = SUBJECT_DAY; }

    public String getPROFESSOR_ID() { return PROFESSOR_ID; }
    public void setPROFESSOR_ID(String PROFESSOR_ID) { this.PROFESSOR_ID = PROFESSOR_ID; }

    public String getPROFESSOR_NAME() { return PROFESSOR_NAME; } // 올바른 Getter
    public void setPROFESSOR_NAME(String PROFESSOR_NAME) { this.PROFESSOR_NAME = PROFESSOR_NAME; } // 올바른 Setter

    public String getSUBJECT_ROOM() { return SUBJECT_ROOM; }
    public void setSUBJECT_ROOM(String SUBJECT_ROOM) { this.SUBJECT_ROOM = SUBJECT_ROOM; }

    public String getSUBJECT_CONTENT() { return SUBJECT_CONTENT; }
    public void setSUBJECT_CONTENT(String SUBJECT_CONTENT) { this.SUBJECT_CONTENT = SUBJECT_CONTENT; }
    
    public String getIMAGE_NAME() { return IMAGE_NAME; }
	public void setIMAGE_NAME(String IMAGE_NAME) {
		this.IMAGE_NAME = IMAGE_NAME;
	}
	
	@Override
	public String toString() {
		return "Subject [SUBJECT_ID=" + SUBJECT_ID + ", SUBJECT_NAME=" + SUBJECT_NAME + ", SUBJECT_SEMESTER="
				+ SUBJECT_SEMESTER + ", SUBJECT_CREDIT=" + SUBJECT_CREDIT + ", SUBJECT_STARTTIME=" + SUBJECT_STARTTIME
				+ ", SUBJECT_ENDTIME=" + SUBJECT_ENDTIME + ", SUBJECT_DAY=" + SUBJECT_DAY + ", PROFESSOR_ID="
				+ PROFESSOR_ID + ", PROFESSOR_NAME=" + PROFESSOR_NAME + ", SUBJECT_ROOM=" + SUBJECT_ROOM
				+ ", SUBJECT_CONTENT=" + SUBJECT_CONTENT + ", IMAGE_NAME=" + IMAGE_NAME + "]";
	}
	
}
