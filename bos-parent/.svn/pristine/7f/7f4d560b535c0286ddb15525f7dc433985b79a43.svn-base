package com.itheima.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;

import cn.itcast.bos.utils.MD5Utils;
@Service
@Transactional

public class UserServiceImpl implements IUserService{
  /**
   * 用户登陆的方法
   */
	
	
	
	@Autowired
	private  IUserDao userDao;
	
	public User login(User user) {
		//使用md5加密
		String password = MD5Utils.md5(user.getPassword());
	   User u=	userDao.findUserByUsernameAndPassword(user.getUsername(), password);
		return u;
	}

	
	/**
	 * 根据用户id修改密码
	 */
	public void editPassword(String id, String password) {
		password =	 MD5Utils.md5(password); //使用MD5加密
	
		userDao.executeUpdate("user.editpassword", password,id);
	}

}
