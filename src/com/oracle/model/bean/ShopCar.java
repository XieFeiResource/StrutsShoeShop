package com.oracle.model.bean;

public class ShopCar {
	
	int  userid;
	int  carid;
	int  carnum;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getCarnum() {
		return carnum;
	}
	public void setCarnum(int carnum) {
		this.carnum = carnum;
	}
	@Override
	public String toString() {
		return "ShopCar [userid=" + userid + ", carid=" + carid + ", carnum="
				+ carnum + "]";
	}
	public ShopCar(int userid, int carid, int carnum) {
		super();
		this.userid = userid;
		this.carid = carid;
		this.carnum = carnum;
	}
	public ShopCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
