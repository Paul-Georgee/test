package com.project.departmentleader.employees.service;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;

/**
 *  部门负责人查看本部门员工接口
 * @author SherLock
 *
 */
public interface IEmployeeService {

	/**
	 * 部门负责人查看本部门员工
	 * @param pageNo 页码
	 * @param departId 部门的id
	 * @param trueName 员工的真实姓名
	 * @param duty 员工的职位
	 * @return 员工分页对象
	 */
	public CutPageBean<UserBean> employees(int pageNo,int departId,
			String trueName,String duty);
	
	/**
	 * 
	 * 本部门员工的详细情况,包括员工培训的成绩
	 * @param userId 员工的id
	 * @return 员工对象
	 */
	public UserBean employeeInfo(int userId);
	
}
