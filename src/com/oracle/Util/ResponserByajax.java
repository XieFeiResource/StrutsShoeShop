package com.oracle.Util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 封装好的独立输出json格式数据的帮助类
 * @author tengsir
 *
 */
public class ResponserByajax {
	
	public  static  void   responseToJson(HttpServletResponse response,HttpServletRequest request,String jsonText) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write(jsonText);
		out.flush();
		out.close();	
	}
	
	public  static  void responseToText(HttpServletRequest request,HttpServletResponse response,String text){
		response.setContentType("text;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(text);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
