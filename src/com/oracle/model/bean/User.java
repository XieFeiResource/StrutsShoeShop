package com.oracle.model.bean;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer sex;
	private String userphone;
	private String useraddress;
	private String tuxiang;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public String getTuxiang() {
		return tuxiang;
	}
	public void setTuxiang(String tuxiang) {
		this.tuxiang = tuxiang;
	}
	public User() {
		super();
	}
	public User(Integer id, String username, String password, Integer sex, String userphone, String useraddress,
			String tuxiang) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.userphone = userphone;
		this.useraddress = useraddress;
		this.tuxiang = tuxiang;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", userphone="
				+ userphone + ", useraddress=" + useraddress + ", tuxiang=" + tuxiang + "]";
	}
	
	
}
