package dbc7;

public class BoardVO {

	private int id;
	private String writer;
	private String passwd;
	private String subject;
	private String email;

	public BoardVO(int id, String writer, String passwd, String subject, String email) {
		this.id = id;
		this.writer = writer;
		this.passwd = passwd;
		this.subject = subject;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	// 객체를 실행하면 toString() 메소드가 자동으로 출력된다. -> 따라서 아래의 toString() 오버라이딩 처리되지 않으면 주소값만 출력되게 된다.
	public String toString() {
		return "BoardVO [id=" + id + ", writer=" + writer + ", passwd=" + passwd + ", subject=" + subject + ", email="
				+ email + "]";
	}

}
