package com.project.publicinfo.contacts.service;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

/**
 *  公司员工通讯录的接口
 * @author SherLock
 *
 */
public interface IContactsService {

	/**
	 *  公司员工通讯录的在职员工的集合
	 * @param pageNo 页码
	 * @param trueName 员工真实姓名
	 * @param duty 职位
	 * @param departmentId 部门的id
	 * @return 公司通讯录的分页对象
	 */
	public CutPageBean<UserBean> contacts(int pageNo,String trueName,
			String duty,Integer departmentId);
	
}
