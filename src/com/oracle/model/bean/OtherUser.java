package com.oracle.model.bean;

public class OtherUser {

	int ouserid;       //ID 自动增长
	String username;   //用户名，第三方登陆的唯一凭证
	String nickname;   //昵称
	String image;      //头像
	int logintype;//登录类型，qq 微博 微信�?
	String credential;//密码凭证
	public int getOuserid() {
		return ouserid;
	}
	public void setOuserid(int ouserid) {
		this.ouserid = ouserid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLogintype() {
		return logintype;
	}
	public void setLogintype(int logintype) {
		this.logintype = logintype;
	}
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	@Override
	public String toString() {
		return "OtherUser [ouserid=" + ouserid + ", username=" + username
				+ ", nickname=" + nickname + ", image=" + image
				+ ", logintype=" + logintype + ", credential=" + credential
				+ "]";
	}
	public OtherUser(int ouserid, String username, String nickname,
			String image, int logintype, String credential) {
		super();
		this.ouserid = ouserid;
		this.username = username;
		this.nickname = nickname;
		this.image = image;
		this.logintype = logintype;
		this.credential = credential;
	}
	public OtherUser() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	