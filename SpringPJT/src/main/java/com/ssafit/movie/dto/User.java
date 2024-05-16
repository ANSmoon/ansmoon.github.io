package com.ssafit.movie.dto;

public class User {
	private String id;
	private String password;
	private String nickname;
	private String email;
	
	public User() {
	
	}
	
	public User(String id, String password, String nickname, String email) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
