package com.springbook.biz.user;

public class UserVO {
	private String id; //null -> "admin"
	private String password; //null -> "1111"
	private String name; //null
	private String role; //null

	public String getId() {
		return id;
	}

	public void setId(String id) { //"admin"
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) { //"1111"
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}

}
