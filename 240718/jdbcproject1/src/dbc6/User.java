package dbc6;

public class User {

	private String id;
	private String passwd;
	private String name;
	private int age;
	private String addr;
	private String email;

	// 기타생성자 : source - Generate Constructor using field... -> 멤버필드 모두 체크 후 하단 Omit ~ super 체크 후 Generate 버튼
	public User(String id, String passwd, String name, int age, String addr, String email) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.email = email;
	}
	
	// getter and setter 생성 : soucre - Generate Getters and Setters -> 멤버필드 모드 체크 후 Generate 버튼
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString() 메소드 생성 : 우클릭 -> source -> Generate toString() -> 멤버필드 모두 선택 -> Generate 버튼
	@Override
	public String toString() {
		return "User [아이디=" + id + ", 비밀번호=" + passwd + ", 이름=" + name + ", 나이=" + age + ", 주소=" + addr
				+ ", 이메일=" + email + "]";
	}

}
