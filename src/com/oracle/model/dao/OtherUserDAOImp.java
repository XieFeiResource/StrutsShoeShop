package com.oracle.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oracle.model.bean.OtherUser;
import com.oracle.model.bean.ShopCar;

public class OtherUserDAOImp  extends BaseDAOImp implements OtherUserDAO {

	/**
	 * 这个是用来注册第三方登录用户的方法，第三方授权登录后，在本网站给用户注册�?个第三方账号记载�?
	 * @param OtherUser对象
	 */
	@Override
	public boolean add(Object o) {
		System.out.println("进入添加Other方法");
		OtherUser ou=(OtherUser)o;
		System.out.println(ou);
		
		Statement sta=null;
		boolean result=false;
	    try {
	    	sta=getSta();
	    	int count=sta.executeUpdate("insert into  otheruser(id,username,nickname,logintype,image)   values(null,'"+ou.getUsername()+"','"+ou.getNickname()+"',"+ou.getLogintype()+",'"+ou.getImage()+"')");
			result=(count>0)?true:false;
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    disposeResource(sta, getCon());
	    return result;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 这是用来判断第三方用户登陆的的方法，即给第三方用户专门注册一个账号，存储在第三方登录信息表中
	 * @param 第三方账号用户名
	 * @param 第三方账号登录类�?
	 * 通过这两个可唯一确定�?个第三方账号是否登录�?
	 */
	@Override
	public OtherUser login(String username, int logintype) {
		System.out.println("第三方登录注册到本地数据�?");
		ResultSet rs = null;
		OtherUser ou=null;
		try {
			rs=getSta().executeQuery("select *  from  otheruser where username='"+username+"'  and logintype="+logintype);
			while(rs.next()){
				ou=new OtherUser();
				ou.setUsername(rs.getString("username"));
				ou.setLogintype(rs.getInt("logintype"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return ou;
	}

}
