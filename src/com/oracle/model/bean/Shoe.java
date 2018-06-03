package com.oracle.model.bean;

import java.util.ArrayList;

public class Shoe {
	private Integer shoeid;
	private String shoename;
	private String shoecolor;
	private Integer shoesize;
	private String shoetype;
	private double shoeprice;
	private Integer shoetuiguang;
	private Integer shoegender;
	private String shiherenqun;
	private String shoedes;
	private String shoevideo;
	private int tupianid;
	public Integer getShoeid() {
		return shoeid;
	}
	public void setShoeid(Integer shoeid) {
		this.shoeid = shoeid;
	}
	public String getShoename() {
		return shoename;
	}
	public void setShoename(String shoename) {
		this.shoename = shoename;
	}
	public String getShoecolor() {
		return shoecolor;
	}
	public void setShoecolor(String shoecolor) {
		this.shoecolor = shoecolor;
	}
	public Integer getShoesize() {
		return shoesize;
	}
	public void setShoesize(Integer shoesize) {
		this.shoesize = shoesize;
	}
	public String getShoetype() {
		return shoetype;
	}
	public void setShoetype(String shoetype) {
		this.shoetype = shoetype;
	}
	public double getShoeprice() {
		return shoeprice;
	}
	public void setShoeprice(double shoeprice) {
		this.shoeprice = shoeprice;
	}
	public Integer getShoetuiguang() {
		return shoetuiguang;
	}
	public void setShoetuiguang(Integer shoetuiguang) {
		this.shoetuiguang = shoetuiguang;
	}
	public Integer getShoegender() {
		return shoegender;
	}
	public void setShoegender(Integer shoegender) {
		this.shoegender = shoegender;
	}
	public String getShiherenqun() {
		return shiherenqun;
	}
	public void setShiherenqun(String shiherenqun) {
		this.shiherenqun = shiherenqun;
	}
	public String getShoedes() {
		return shoedes;
	}
	public void setShoedes(String shoedes) {
		this.shoedes = shoedes;
	}
	public String getShoevideo() {
		return shoevideo;
	}
	public void setShoevideo(String shoevideo) {
		this.shoevideo = shoevideo;
	}
	public Shoe() {
		super();
	}
	public Shoe(Integer shoeid, String shoename, String shoecolor, Integer shoesize, String shoetype, double shoeprice,
			Integer shoetuiguang, Integer shoegender, String shiherenqun, String shoedes, String shoevideo,
			int tupianid) {
		super();
		this.shoeid = shoeid;
		this.shoename = shoename;
		this.shoecolor = shoecolor;
		this.shoesize = shoesize;
		this.shoetype = shoetype;
		this.shoeprice = shoeprice;
		this.shoetuiguang = shoetuiguang;
		this.shoegender = shoegender;
		this.shiherenqun = shiherenqun;
		this.shoedes = shoedes;
		this.shoevideo = shoevideo;
		this.tupianid = tupianid;
	}
	@Override
	public String toString() {
		return "Shoe [shoeid=" + shoeid + ", shoename=" + shoename + ", shoecolor=" + shoecolor + ", shoesize="
				+ shoesize + ", shoetype=" + shoetype + ", shoeprice=" + shoeprice + ", shoetuiguang=" + shoetuiguang
				+ ", shoegender=" + shoegender + ", shiherenqun=" + shiherenqun + ", shoedes=" + shoedes
				+ ", shoevideo=" + shoevideo + ", tupianid=" + tupianid + "]";
	}
	
}
