package com.oracle.model.dao;

import java.util.ArrayList;
import java.util.Set;

import com.oracle.model.bean.Car;
import com.oracle.model.bean.CarImage;

public interface  CarDao  extends BaseDAO{
	/*
	 * 设计�?个可以根据用户传入的数量查询显示出最近发布的二手车信�?
	 */
	public abstract ArrayList<Car>  listRecentCarsByCount(int count);
	
	
	/**
	 * 定义�?个查询需要推广显示到滚动区域二手车信息的方法
	 */
	public  abstract  ArrayList<Car>  getAllCarByTuiguang();
	
	/**
	 * 
	 * @param carId 要查询的车辆ID
	 * @return  �?个查询并封装好的Car对象
	 */
	public  abstract Car  getCarInfoByCarId(int carId);

	/**
	 * 根据传入的条件，搜索对应的车辆信息的方法
	 * @param pinpai
	 * @param minPrice
	 * @param maxPrice
	 * @param minMile
	 * @param maxMile
	 * @param biansuxiang
	 * @param cheliangleixing
	 * @return
	 */
	public   abstract   ArrayList<Car>  searchCarsByCondition(String pinpai,String minPrice,String maxPrice,String minMile,String maxMile,String biansuxiang,String cheliangleixing,int page,int count);

	public   abstract   ArrayList<Car>  searchCarsByCondition(String pinpai,String minPrice,String maxPrice,String minMile,String maxMile,String biansuxiang,String cheliangleixing);

	
	/**
	 * 根据车辆编号查询车辆对应的图片的方法
	 * @param carId
	 * @return
	 */
	public   abstract  Set<CarImage>  getCarImagesByCarId(int carId);
	
	/**
	 * 根据模糊关键字查询所有的内容
	 * @param key
	 * @return
	 */
	public  abstract ArrayList<Car>  searchAllByKey(String key);
	
	
	
	/**
	 * 这是根据传入的页面和�?页几辆车查询出对应的车集�?
	 * @param page
	 * @param count
	 * @return 
	 */
	public  abstract ArrayList<Car>  listCarsByPage(int page, int count);
	
	
	
	/**
	 * 这是查询车辆总条数的方法，用于分页的时�?�调�?
	 * @return
	 */
	public  abstract int  allCarsCount();
	
	
	
	/**
	 * 这是通过车系列名  模糊匹配的方法，返回查找到的�?有符合的系列�?
	 * @param page
	 * @param count
	 * @return
	 */
	public  abstract ArrayList<String>  listCarsXiLie(String xilie);
	
	
	
	
	/**
	 * 这是通过车系列名  模糊匹配的方法，返回查找到的�?有cars
	 * @param page
	 * @param count
	 * @return
	 */
	public  abstract ArrayList<Car>  listCarsByXiLie(String xilie);
	
	
	
}
