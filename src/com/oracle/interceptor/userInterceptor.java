package com.oracle.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.oracle.model.bean.User;

public class userInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		 //进入到拦截器拦截
		HttpServletRequest request=ServletActionContext.getRequest();
		 
		 String url=request.getRequestURL().toString();
		
		 if(url.contains("showAllUsers")){
			 if(request.getSession().getAttribute("loginUser")==null){
				 return "checkSessionLogin";
			 }
			 else{
				 arg0.invoke();//放行
				 return null;
			 }
		 }
		 else{
			 arg0.invoke();//放行
			 return null;
		 }
		 
		 
	    
	}

}
