package com.project.leader.employees.service;


import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

/**
 * 领导查看所有员工基本信息接口
 * @author SherLock
 *
 */
public interface IEmployeeService {

	/**
	 * 按照ID查询员工对象
	 * @return 员工对象
	 */
	public UserBean findById(int id);
	/**
	 * 领导查看本公司员工列表
	 * @param pageNo 页码
	 * @param trueName 员工真实姓名
	 * @param departmentId 部门的id
	 * @param duty 员工的职务
	 * @return 员工集合对象
	 */
	public CutPageBean<UserBean> employees(int pageNo,String trueName,
			Integer departId,String duty);
	
}
