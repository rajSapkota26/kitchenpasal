package com.kitchenpasal.main.model;

public class ForgotPassword {

	private long id;
	private String email;
	private String password;
	private String confromPassword;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfromPassword() {
		return confromPassword;
	}
	public void setConfromPassword(String confromPassword) {
		this.confromPassword = confromPassword;
	}
	
	
}
