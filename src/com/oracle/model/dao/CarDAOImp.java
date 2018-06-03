package com.oracle.model.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.oracle.model.bean.Car;
import com.oracle.model.bean.CarImage;

public class CarDAOImp extends BaseDAOImp  implements CarDao {
	public static void main(String[] args) {
		CarDAOImp dao=new CarDAOImp();
		ArrayList<String> xil=dao.listCarsXiLie("豪华");
		System.out.println(xil.size());
		for(String x:xil){
			System.out.println(x);
		}
	}

	@Override
	public boolean add(Object o) {
		return false;
	}

	@Override
	public boolean delete(Object id) {
		return false;
	}

	@Override
	public boolean update(Object o) {
		return false;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据传入的数量查询出�?近的指定数量的二手车信息
	 */
	public ArrayList<Car> listRecentCarsByCount(int count) {
		ArrayList<Car> cars = new ArrayList<Car>();// 定义�?个集合存储查询出来的�?有车辆信�?
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car order by  carid desc  limit " + count);
			while (rs.next()) {
				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return cars;
	}

	@Override
	public ArrayList<Car> getAllCarByTuiguang() {
		ArrayList<Car> cars = new ArrayList<Car>();// 定义�?个集合存储查询出来的�?有车辆信�?
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car   where  shifoutuiguang=1");
			while (rs.next()) {

				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return cars;
	}

	
	/*
	 * 通过id查车信息
	 */
	@Override
	public Car getCarInfoByCarId(int carId) {
		Car c = null;
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car  where carid=" + carId);
			if (rs.next()) {
				c = parsetResultToCar(rs);
				//System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return c;
	}

	//根据搜索条件查询车辆
	@Override
	public ArrayList<Car> searchCarsByCondition(String pinpai, String minPrice, String maxPrice, String minMile,
			String maxMile,String biansuxiang,String cheliangleixing,int page,int count) {
		/**
		 * 条件有很多种不同，那么sql语句就应该有对应的变�?
		 */
		String SQL = "select *  from  car  where  1=1";
		if (pinpai != null && !pinpai.equals("")) {
			SQL += "   and  pinpaiming='" + pinpai + "'";
		}
		if (minPrice != null && !minPrice.equals("")) {
			SQL += "   and  shoujia>=" + minPrice;
		}
		if (maxPrice != null && !maxPrice.equals("")) {
			SQL += "   and  shoujia<=" + maxPrice;
		}
		if (minMile != null && !minMile.equals("")) {
			SQL += "   and  gonglishu>=" + Integer.parseInt(minMile) * 10000;
		}
		if (maxMile != null && !maxMile.equals("")) {
			SQL += "  and  gonglishu<=" + Integer.parseInt(maxMile) * 10000;
		}
		if (biansuxiang != null && !biansuxiang.equals("")) {
			SQL += "   and  biansuxiang  like '%"+biansuxiang+"%'";
		}
		if (cheliangleixing != null && !cheliangleixing.equals("")) {
			SQL += "  and  cheliangleixing like '%"+cheliangleixing+"%'";
		}
        SQL=SQL+" limit "+(page-1)*count+","+count;
        System.out.println(SQL);
		ArrayList<Car> cars = new ArrayList<Car>();// 定义�?个集合存储查询出来的�?有车辆信�?
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery(SQL);
			while (rs.next()) {
				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return cars;
	}

	@Override
	public ArrayList<Car> searchCarsByCondition(String pinpai, String minPrice,String maxPrice, String minMile, String maxMile,String biansuxiang, String cheliangleixing) {
		/**
		 * 条件有很多种不同，那么sql语句就应该有对应的变�?
		 */
		String SQL = "select *  from  car  where  1=1";
		if (pinpai != null && !pinpai.equals("")) {
			SQL += "   and  pinpaiming='" + pinpai + "'";
		}
		if (minPrice != null && !minPrice.equals("")) {
			SQL += "   and  shoujia>=" + minPrice;
		}
		if (maxPrice != null && !maxPrice.equals("")) {
			SQL += "   and  shoujia<=" + maxPrice;
		}
		if (minMile != null && !minMile.equals("")) {
			SQL += "   and  gonglishu>=" + Integer.parseInt(minMile) * 10000;
		}
		if (maxMile != null && !maxMile.equals("")) {
			SQL += "  and  gonglishu<=" + Integer.parseInt(maxMile) * 10000;
		}
		if (biansuxiang != null && !biansuxiang.equals("")) {
			SQL += "   and  biansuxiang  like '%"+biansuxiang+"%'";
		}
		if (cheliangleixing != null && !cheliangleixing.equals("")) {
			SQL += "  and  cheliangleixing like '%"+cheliangleixing+"%'";
		}

		ArrayList<Car> cars = new ArrayList<Car>();// 定义�?个集合存储查询出来的�?有车辆信�?
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery(SQL);
			while (rs.next()) {
				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return cars;
	}
		
	
	
	//将数据库查询到的car信息封装成一个car对象
	public Car parsetResultToCar(ResultSet rs) {
		Car c = null;
		try {
			c = new Car();
			c.setCarId(rs.getInt("carid"));
			c.setPinpaiming(rs.getString("pinpaiming"));
			c.setXilie(rs.getString("xilie"));
			c.setGonglishu(rs.getFloat("gonglishu"));
			c.setGoumaishijian(rs.getString("goumaishijian"));
			c.setShoujia(rs.getFloat("shoujia"));
			c.setPailiang(rs.getString("pailiang"));
			c.setMiaoshu(rs.getString("miaoshu"));
			c.setZhuangtai(rs.getInt("zhuangtai"));
			c.setQicheshoutu(rs.getString("qicheshoutu"));
			c.setBiansuxiang(rs.getString("biansuxiang"));
			c.setRanliaoleixing(rs.getString("ranliaoleixing"));
			c.setCheliangleixing(rs.getString("cheliangleixing"));
			c.setDijishou(rs.getInt("dijishou"));
			c.setShipin(rs.getString("shipin"));
			c.setShifoutuiguang(rs.getInt("shifoutuiguang"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	

	//通过主键carid在外键表中存在，在车图表中，查询出对应的车子图片（多条）封装成CarImage对象
	@Override
	public Set<CarImage> getCarImagesByCarId(int carId) {
		Set<CarImage>  imgs=new HashSet<>();
		try {
			Statement  sta=getSta();
			ResultSet  rs=sta.executeQuery("select *  from carImage where carid="+carId);
			while(rs.next())
			{
				CarImage  img=new CarImage();
				img.setCarid(rs.getInt("carid"));
				img.setImageid(rs.getInt("imageid"));
				img.setImagepath(rs.getString("imagepath"));
				imgs.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgs;
	}

	//通过关键字查询出符合的所有的车辆信息
	@Override
	public ArrayList<Car> searchAllByKey(String key) {
		String[] keys=key.split("\\s+");
		ArrayList<Car> cars = new ArrayList<Car>();// 定义�?个集合存储查询出来的�?有车辆信�?
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car  limit 1");
			ResultSetMetaData  data=rs.getMetaData();
			String sql="select * from car  where 1=0  or";
			String[] columnName=new String[data.getColumnCount()];
			for(int n=1;n<=data.getColumnCount();n++)
			{
				columnName[n-1]=data.getColumnLabel(n);
			}
			for(String k:keys) {
				sql+="  (  1=0";
				for(String column:columnName)
				{
					sql+="  or  "+column+" like  '%"+k+"%'";
				}
				sql+=" ) and";
			}
			sql=sql.substring(0, sql.length()-3);
			rs=getSta().executeQuery(sql);
			while(rs.next()) {
				Car c=parsetResultToCar(rs);
				cars.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return cars;
	}
	
	//获取车视频的方法
	public void updateCarVideo() {
		try {
			ResultSet rs=getSta().executeQuery("select carid from car");
			int n=1;
			while(rs.next()) {
				int result=getSta().executeUpdate("update  car   set  shipin='videos/"+n+".mp4' where carid="+rs.getInt(1));
				System.out.println(result);
				n++;
				if(n==23)n=1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	//分页查询出每页的车辆并显示到carList.jsp
	@Override
	public ArrayList<Car> listCarsByPage(int page, int count) {
		
		ArrayList<Car> cars = new ArrayList<Car>();// 定义�?个集合存储查询出来的�?有车辆信�?
		ResultSet rs = null;
		String SQL="select * from  car  limit "+(page-1)*count+","+count;
		try {
			rs = getSta().executeQuery(SQL);
			while (rs.next()) {
				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return cars;
	}

	
	//查询车辆总条�?
	@Override
	public int allCarsCount() {
		int n=0;
		ResultSet rs=null;
		String SQL="select count(carid)  from car";
		try {
			rs = getSta().executeQuery(SQL);
			rs.next();
			n=rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return n;
		
	}

	
	/**
	 * 这是通过车系列名  模糊匹配的方法，返回查找到的�?有符合的系列�?
	 * @param 车的系列
	 * @return 符合的系列名集合
	 */
	@Override
	public ArrayList<String> listCarsXiLie(String xilieM) {
		System.out.println("进入模糊查找 车系�? 的方�?");
		ArrayList<String> xilieArr=new ArrayList<String>();
		ResultSet rs=null;
		Boolean result=false;
		try {
	    	  rs=getSta().executeQuery("select xilie from car where xilie like '%"+xilieM+"%' limit 6");
	    	  while (rs.next()) {
					xilieArr.add(rs.getString(1));
			  }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
	    return xilieArr;
	}

	
	@Override
	public ArrayList<Car> listCarsByXiLie(String xilie) {
		ArrayList<Car> xilieArr=new ArrayList<Car>();
		ResultSet rs=null;
		Boolean result=false;
		try {
	    	  rs=getSta().executeQuery("select * from car where xilie='"+xilie+"'");
	    	  while (rs.next()) {
					xilieArr.add(parsetResultToCar(rs));
			  }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
	    return xilieArr;
	}
}

