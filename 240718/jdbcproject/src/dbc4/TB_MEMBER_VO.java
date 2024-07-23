package dbc4;

// DTO(=VO) 클래스 : 데이터를 담거나 전송하는 객체
public class TB_MEMBER_VO {
	// 멤버필드 = 속성 = attribute = property = (데이터베이스 테이블)컬럼
	private int m_seq;
	private String m_userid;
	private String m_pwd;
	private String m_email;
	private String m_hp;
	private String m_registdate; // Date 자료형 대신 핸들링하기 쉬운 String 자료형으로 하는 것이 좋다.
	private int m_point;
	private String m_yn;

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}

	public String getM_userid() {
		return m_userid;
	}

	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_hp() {
		return m_hp;
	}

	public void setM_hp(String m_hp) {
		this.m_hp = m_hp;
	}

	public String getM_registdate() {
		return m_registdate;
	}

	public void setM_registdate(String m_registdate) {
		this.m_registdate = m_registdate;
	}

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}

	public String getM_yn() {
		return m_yn;
	}

	public void setM_yn(String m_yn) {
		this.m_yn = m_yn;
	}

}
