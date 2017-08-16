package com.project.admin.department.service;

import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;

/**
 *部门管理接口
 * @author SherLock
 *
 */
public interface IDepartmentService {
	/**
	 * 添加部门
	 * @param dbean 部门对象
	 */
	public  void  add(DepartmentBean dbean);
	
	/**
	 * 修改部门信息,按id查询部门,如果该部门负责人不为空,将原部门负责人权限修改为普通员工,
	 * 同时将新的负责人的id的权限修改为部门负责人
	 * @param id 部门id
	 * @param employId 在职员工的id(新的部门负责人的id)
	 * @param departHeaderId 原负责人的id
	 */
	public void update(int id,int employId,int departHeaderId);
	
	/**
	 * 查看部门详情
	 * @param id 部门id
	 * @return
	 */
	public DepartmentBean  findById(int id);
	
	/**
	 * 删除部门,删除部门前先查询 是否还有员工
	 * @param id 部门id
	 */
	public int  del(int id);
	
	
	/**
	 * 管理员查看部门管理,连接查询部门负责人,如果没有负责人显示没有负责人
	 * @return 部门列表
	 */
	public List<DepartmentBean> departments();
	
	/**
	 * 根据名称分页查询所有用户
	 * @param pageNo    页码
	 * @param userName   用户名称
	 * @return   分页对象
	 */
	public CutPageBean<UserBean> findByItemForUser(int pageNo,String userName);
}
