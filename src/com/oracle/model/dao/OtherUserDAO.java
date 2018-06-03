package com.oracle.model.dao;

import com.oracle.model.bean.OtherUser;

public interface OtherUserDAO extends BaseDAO{
	
	//这个方法用来判断第三方登录调用的方法，返回一个OtherUser对象
    public OtherUser login(String username,int logintype);
    
    
}
