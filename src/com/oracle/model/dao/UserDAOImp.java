package com.oracle.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;






import java.util.ArrayList;

import com.oracle.model.bean.Car;
import com.oracle.model.bean.OtherUser;
import com.oracle.model.bean.User;

public class UserDAOImp extends BaseDAOImp implements UserDAO{
	public static void main(String[] args) {
		UserDAOImp dao=new UserDAOImp();
		boolean result=dao.getUserByUsername("2015117145");
		System.out.println(result);
	}

	//这里是�?�用的方�?
	
	/**
	 *这个add方法相当于用户注册，返回注册成功或�?�失�?
	 *@param 封装成的User对象写入数据�?
	 */
	@Override
	public boolean add(Object o) {
		User user=(User)o;
		System.out.println(user);
		Statement sta=null;
		boolean result=false;
		//String Sql="insert into  users(userid,username,password)  values(null,'"+user.getUsername()+"','"+user.getPassword()+"')";
	    try {
	    	sta=getSta();
	    	int count=sta.executeUpdate("insert into  users(userid,username,password,nickname)   values(null,'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getNickname()+"')");
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
		return false;
	}

	
	
	/**
	 *这个方法相当于用户修改信息，返回修改成功或�?�失�?
	 *@param 修改后封装成的User对象写入数据�?
	 */
	@Override
	public boolean update(Object o){
		System.out.println("进入更新User方法");
		User user=(User)o;
		System.out.println(user);
		
		Statement sta=null;
		PreparedStatement  preSta=null;
		int count;
		Boolean result=false;
		//String Sql="insert into  user(userid,username,password)  values(null,'"+user.getUsername()+"','"+user.getPassword()+"')";
	    try {
	    	  preSta=getPreSta("update users set username=? ,nickname=?,sex=?,age=?,image=?,job=?,jialing=?,email=?,tel=?,jianjie=? where userid=?");
			  preSta.setString(1, user.getUsername());
			  preSta.setString(2, user.getNickname());
			  preSta.setInt(3, user.getSex());;
			  preSta.setInt(4, user.getAge());;
			  preSta.setString(5, user.getImage());
			  preSta.setString(6, user.getJob());
			  preSta.setInt(7, user.getJialing());
			  preSta.setString(8, user.getEmail());
			  preSta.setString(9, user.getTel());
			  preSta.setString(10, user.getJianjie());
			  preSta.setInt(11, user.getUserid());
			  count=preSta.executeUpdate();
			  result=(count>0)?true:false;
			  System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    disposeResource(sta, getCon());
	    return result;
	}

	@Override
	public Object list() {
		return null;
	}

	
	
	
	/**
	 * 这里是实现用户登陆的方法,传入用户名和密码，数据库查询出对应的信息并封装成User对象
	 * @param  username
	 * @param  password
	 */
	@Override
	public User login(String username, String password) {
		User  user=null;
		ResultSet rs=null;
		
		String Sql="select * from users where username='"+username+"' and  password='"+password+"'";	
		try {			
			rs=getSta().executeQuery(Sql);
			if (rs.next()) {
				user = parsetResultToUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return user;
	}


	
	//将数据库查询到的user信息封装成一个user对象
			public User parsetResultToUser(ResultSet rs) {
				User  user = null;
				try {
						user=new User();
						user.setUserid(rs.getInt("userid"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						if(rs.getString("image")!=null)
						{
						user.setAge(rs.getInt("age"));
						user.setImage(rs.getString("image"));
						user.setNickname(rs.getString("nickname"));
						//user.setSex(rs.getInt("sex"));
						user.setSex(rs.getInt("sex"));
						user.setJob(rs.getString("job"));
						user.setJialing(rs.getInt("jialing"));
						user.setEmail(rs.getString("email"));
						user.setTel(rs.getString("tel"));
						user.setJianjie(rs.getString("jianjie"));
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return user;
			}
		
	/**
	 * 通过用户id返回�?个完整的用户对象
	 */
	@Override
	public User getUserById(int userid) {
		User user = null;
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  users  where userid=" + userid);
			if (rs.next()) {
				user = parsetResultToUser(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return user;
	}

	
	
    /**
     * 根据用户传入用户名，判断用户是否存在
     */
	@Override
	public boolean getUserByUsername(String username) {
		System.out.println("进入判断用户是否存在方法");

		ResultSet rs=null;
		int id=-1;
		Boolean result=false;
		try {
	    	  rs=getSta().executeQuery("select userid from users where username='"+username+"'");
	    	  if (rs.next()) {
					id=rs.getInt(1);
				}
	    	  result=(id!=-1)?true:false;
			  System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
	    return result;
	}

	
	
	//将数据库查询到的User信息封装成一个uSER对象
		public User parsetResultToUser1(ResultSet rs) {
			User user= null;
			try {
				user= new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setAge(rs.getInt("age"));
				user.setImage(rs.getString("image"));				
				user.setSex(rs.getInt("sex"));
				user.setTel(rs.getString("tel"));			
				user.setJianjie(rs.getString("jianjie"));
				user.setJialing(rs.getInt("jialing"));				
				user.setEmail(rs.getString("email"));
				user.setJob(rs.getString("job"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}
	
	
	/**
	 * 这是根据传入的页面和每页几辆车查询出对应的User
	 * @param page
	 * @param count
	 * @return 
	 */
	@Override
	public ArrayList<User> listUsersByPage(int page, int count) {
		ArrayList<User> allUsers = new ArrayList<User>();// 定义�?个集合存储查询出来的�?有车辆信�?
		ResultSet rs = null;
		String SQL="select * from  users  limit "+(page-1)*count+","+count;
		try {
			rs = getSta().executeQuery(SQL);
			while (rs.next()) {
				allUsers.add(parsetResultToUser1(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return allUsers;
	}
}
