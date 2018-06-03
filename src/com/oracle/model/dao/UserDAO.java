package com.oracle.model.dao;
import java.util.ArrayList;

import com.oracle.model.bean.Car;
import com.oracle.model.bean.User;

public interface UserDAO extends BaseDAO{
	
	//用户登陆调用的方法，返回成功或�?�失�?
	public User login(String username,String password);
	
    //根据传入用户的id返回�?个用户对�?
	public User getUserById(int userid);
	
	//根据用户传入用户名，判断用户是否存在
	public boolean getUserByUsername(String username);
	
	
	/**
	 * 这是根据传入的页面和每页几辆车查询出对应的User
	 * @param page
	 * @param count
	 * @return 
	 */
	public  abstract ArrayList<User>  listUsersByPage(int page, int count);
	
	
}