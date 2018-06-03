package com.oracle.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oracle.model.bean.ShopCar;

public class ShopCarDAOImp extends BaseDAOImp implements ShopCarDAO{

	
	/**
	 * 添加时不存在于某个用户的名下，根据用户名  车id 车数�?1（封装成ShopCar），添加到数据库
	 * @param userid 添加到哪个用户下
	 * @param carid 车辆id
	 * @param carnum 数量
	 * @return Boolean
	 */
	@Override
	public boolean add(Object o) {
		System.out.println("进入添加shopcar方法");
		ShopCar cs=(ShopCar)o;
		System.out.println(cs);
		
		Statement sta=null;
		boolean result=false;
	    try {
	    	sta=getSta();
	    	int count=sta.executeUpdate("insert into  shopcar(shopid,userid,carid,carnum)   values(null,"+cs.getUserid()+","+cs.getCarid()+","+cs.getCarnum()+")");
			result=(count>0)?true:false;
			System.out.println(result);
			
		} catch (SQLException e) {
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

	
	/**
	 * 如果添加时，数据库存在某个用户的某个商品，则将其(封装成ShopCar)(数量+1)更新到数据库
	 * @param userid 添加到哪个用户下
	 * @param carid 车辆id
	 * @param carnum 数量
	 * @return Boolean
	 */
	@Override
	public boolean update(Object o) {
		System.out.println("进入更新shopcar方法");
		ShopCar cs=(ShopCar)o;
		System.out.println(cs);
		
		PreparedStatement  preSta=null;
		int count;
		boolean result=false;
	    try {
	    	  preSta=getPreSta("update shopcar set carnum=? where userid=? and carid=?");
			  preSta.setLong(1, cs.getCarnum());
			  preSta.setLong(2, cs.getUserid());
			  preSta.setLong(3, cs.getCarid());
			  count=preSta.executeUpdate();
			  result=(count>0)?true:false;
			  System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    disposeResource(preSta, getCon());
	    return result;
	}

	
	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	/**
	 * 根据用户id查询某个用户的购物车�?有商品，显示时�?�用�?
	 * @param userid
	 * @return
	 */
	@Override
	public ArrayList<ShopCar> searchAllByUserId(int userid) {
		System.out.println("进入查询�?个用户所有商品的方法");
		
		ArrayList<ShopCar> allshopCar=new ArrayList<ShopCar>();
		ResultSet rs = null;
		try {
			rs=getSta().executeQuery("select *  from  shopcar where userid="+userid);
			while(rs.next()){
				ShopCar sc=new ShopCar();
				sc.setUserid(rs.getInt("userid"));
				sc.setCarid(rs.getInt("carid"));
				sc.setCarnum(rs.getInt("carnum"));
				allshopCar.add(sc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return allshopCar;
	}


	
	/**
	 * /**
	 * 根据用户userid carid查询要添加的车是否存在于某个用户名下,返回
	 * @param userid
	 * @return ShopCar
	 */
	@Override
	public ShopCar searchShopCarByTid(int userid, int carid) {
		//System.out.println("进入查询Shopcar对象是否存在方法");
		ResultSet rs = null;
		ShopCar sc=null;
		try {
			rs=getSta().executeQuery("select *  from  shopcar where userid="+userid+" and carid="+carid);
			while(rs.next()){
				sc=new ShopCar();
				sc.setUserid(rs.getInt("userid"));
				sc.setCarid(rs.getInt("carid"));
				sc.setCarnum(rs.getInt("carnum"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return sc;
	}



	/**
	 * 根据用户userid carid,删除数据库购物车某一条记�?
	 * @param userid
	 * @return boolean 对象
	 */
	@Override
	public boolean deleteOne(int userid, int carid) {
		System.out.println("进入删除�?条记录shopcar方法");

		PreparedStatement  preSta=null;
		int count;
		boolean result=false;
	    try {
	    	  preSta=getPreSta("delete from shopcar where  userid=? and carid=?");
			  preSta.setLong(1, userid);
			  preSta.setLong(2, carid);
			
			  count=preSta.executeUpdate();
			  result=(count>0)?true:false;
			  System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    disposeResource(preSta, getCon());
	    return result;
	}

	/**
	 * 根据用户userid 清空购物�?
	 * @param userid
	 * @return boolean 对象
	 */
	@Override
	public boolean deleteAll(int userid) {
		System.out.println("进入�?个用户删除所有shopcar方法");

		PreparedStatement  preSta=null;
		int count;
		boolean result=false;
	    try {
	    	  preSta=getPreSta("delete from shopcar where  userid=?");
			  preSta.setLong(1, userid);
			
			  count=preSta.executeUpdate();
			  result=(count>0)?true:false;
			  System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    disposeResource(preSta, getCon());
	    return result;
	}
	
	
}
