package com.oracle.model.dao;

import java.util.ArrayList;

import com.oracle.model.bean.ShopCar;


public interface ShopCarDAO extends BaseDAO{
	/**
	 * 根据userid查询对应的购物车商品�?有的内容
	 * @param userid
	 * @return
	 */
	public  abstract ArrayList<ShopCar>  searchAllByUserId(int userid);
	
	
	
	/**
	 * 根据用户userid carid查询要添加的车是否存在于某个用户名下,
	 * @param userid
	 * @return
	 */
	public  abstract ShopCar  searchShopCarByTid(int userid,int carid);
	
	
	
	
	/**
	 * 根据用户userid carid,删除数据库购物车某一条记�?
	 * @param userid
	 * @return ShopCar 对象
	 */
	public  abstract  boolean  deleteOne(int userid,int carid);
	
	
	/**
	 * 根据用户userid,清空购物�?
	 * @param userid
	 * @return ShopCar 对象
	 */
	public  abstract  boolean  deleteAll(int userid);
	
     
}
