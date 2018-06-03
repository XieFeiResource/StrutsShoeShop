package com.oracle.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.oracle.Util.MD5;
import com.oracle.Util.ResponserByajax;
import com.oracle.model.bean.User;
import com.oracle.model.dao.UserDAO;
import com.oracle.model.dao.UserDAOImp;


public class UserAction {
	private User u;
	private UserDAO dao;
	private String page;
	private String rows;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	
	public UserAction() {	
		super();
		dao=new UserDAOImp();
	}
	
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}

	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}





	/**
	 * 通用的方法集合将JSON数据传送出去
	 * @param jsonO
	 */
	public void outJSONTo(JSONArray jsonO){
		 HttpServletResponse response = ServletActionContext.getResponse();
		 response.setContentType("text/json;charset=UTF-8");
		 try {
			PrintWriter out = response.getWriter();
			out.write(jsonO.toString());
			out.flush();
			out.close();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
	/**
	 * 通用的方法，将User对象集合封装成json集合格式
	 * @param jsonO
	 */
	public JSONArray writeToJSON(ArrayList<User> allUsers){
		JSONArray allUsersJSON=new JSONArray();//存所有用户的json对象
		for(User user:allUsers){
			JSONObject userJSON=new JSONObject();
			userJSON.put("username", user.getUsername());
			userJSON.put("userid",user.getUserid());
			userJSON.put("nickname",user.getNickname());
			userJSON.put("image","<img src='"+user.getImage()+"' style='width:20px;height:20px' />");
			userJSON.put("age",user.getAge());
			userJSON.put("sex",(user.getSex()==1?"男":"女"));
			userJSON.put("jialing",user.getJialing());
			userJSON.put("email",user.getEmail());
			userJSON.put("jianjie",user.getJianjie());
			userJSON.put("job",user.getJob());
			userJSON.put("tel",user.getTel());	
			allUsersJSON.put(userJSON);
		}
		return allUsersJSON;
	}
	
	
	
	
	
	/**
	 * 这是处理用户登陆的方法
	 * @return
	 */
	public String login(){   	
		System.out.println(u.getUsername()+"\t"+u.getPassword());		
		User loginUser=dao.login(u.getUsername(), MD5.MD5(u.getPassword()));
		if(loginUser!=null){
		    ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
		    return "success";
		}
		else{
		    HttpServletRequest request=ServletActionContext.getRequest();
		    request.setAttribute("Message", "loginFail");
			return "fail";
		   }	
	}
	
	
	
	/**
	 * 这是显示所有用户信息的方法
	 */
	public void showAllUsers(){
		System.out.println("进入到显示所有用户的方法");
		ArrayList<User> allusers=new ArrayList<User>();		
		allusers=dao.listUsersByPage(Integer.parseInt(page),Integer.parseInt(rows));
		
		JSONArray allUsersJSON=writeToJSON(allusers);//封装好的将用户集合变成JSON集合
		//outJSONTo(allUsersJSON);//通过输出流将JSON对象返回给请求的页面
		try {
			ResponserByajax.responseToJson(response, request, allUsersJSON.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
}
	

