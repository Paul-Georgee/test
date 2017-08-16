package com.project.system.employee.service;

import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 系统管理员的用户管理接口
 * @author SherLock
 *
 */
public interface IEmpService {

	/**
	 *  根据真实姓名,和职位进行查询在职员工并且分页
	 * @param pageNo 页码
	 * @param trueName 真实姓名
	 * @param duty 职位
	 * @return 分页对象
	 */
	public CutPageBean<UserBean> emps(int pageNo,String trueName,
			String duty);
	/**
	 * 添加前先查询出所有部们名称与id
	 * @return
	 */
	public List<DepartmentBean> findItem();
	
	/**
	 *  添加用户
	 * @param user 员工对象
	 */
	public void empsAdd(UserBean user);
	
	/**
	 *  修改用户的资料
	 * @param userId 用户的id
	 * @param duty 用户需要修改的职位
	 * @param tel 用户的电话
	 * @param departId 部门的id
	 * @param role 用户在系统中的角色
	 */
	public void update(int userId,String duty,String tel,int departId,String role);
	
	/**
	 *  删除员工之前是否还有有效保单,如果没有,就修改状态为离职,
	 *  如果有,就返回假,并且不允许删除,
	 * @param userId
	 */
	public boolean del(int userId);
	/**
	 *查看用户详情
	 * @param id 用户ID
	 * @return
	 */
	public UserBean findById(int id);
	

}
