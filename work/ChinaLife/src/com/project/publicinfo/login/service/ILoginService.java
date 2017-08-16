package com.project.publicinfo.login.service;


import com.project.bean.UserBean;

public interface ILoginService {

	/**
	 *  查询用户名和密码同时在职的员工,记录登录日志
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回用户对象,如果没有找到,就返回空
	 */
	public UserBean login(String username,String password);
	
	
}
