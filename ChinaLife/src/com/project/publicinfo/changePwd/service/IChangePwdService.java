package com.project.publicinfo.changePwd.service;

/**
 * 用户修改密码模块
 * @author SherLock
 *
 */
public interface IChangePwdService {
	/**
	 *  用户修改密码
	 * @param id 用户的id
	 * @param password 新的密码
	 */
	public void updatePwd(int id,String password);
}
