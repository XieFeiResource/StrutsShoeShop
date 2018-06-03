package com.oracle.model.dao;

import java.util.ArrayList;

import com.oracle.model.bean.Car;

public interface  BaseDAO {//鎻愬彇鐖舵帴鍙�(鐖剁被搴旇骞茬殑浜嬫儏锛屾妸涓�浜涘叕鍏辩殑璧勬簮澹版槑鍦ㄨ繖閲�)
	
	public String  dirverClass="com.mysql.jdbc.Driver";
	public String  url="jdbc:mysql://localhost:3306/mysql";
	public String username="root";
	public String password="123456";
	
	//娣诲�?
	public abstract  boolean add(Object o);
	
	public abstract boolean  delete(Object id);
	
	public abstract boolean update(Object  o);
	
	public abstract Object    list();

	
}
