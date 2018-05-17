package com.itheima.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.bos.domain.User;

/**
 * BOS项目的工具类
 * @author Administrator
 *
 */
public class BOSUtils {
    //获取session对象
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
		
	}
	//获取登陆用户对象
	public static User getLoginUser(){
	 return	(User) getSession().getAttribute("loginUser");
		
	}
}
