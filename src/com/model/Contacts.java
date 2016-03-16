package com.model;

public class Contacts {
	private int userid;
	private String name;
	private String phone;
	private String email;
	private String memo;
	
	public Contacts(int userid, String name, String phone, String email, String memo) {
		super();
		this.userid = userid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.memo = memo;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
