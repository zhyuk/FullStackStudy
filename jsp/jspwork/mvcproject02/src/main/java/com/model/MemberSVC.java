package com.model;

public class MemberSVC {
	private MemberDAO dao = new MemberDAO();
	
	// DAO 클래스에 public MemberVO login(String id, String pw) {}와 동일한 이름으로 작성하는 것이 좋음.
	public MemberVO login(String id, String pw) {
		return dao.login(id, pw);
	}
}
