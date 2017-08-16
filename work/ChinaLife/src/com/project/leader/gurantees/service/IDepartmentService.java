package com.project.leader.gurantees.service;

import java.util.List;

import com.project.bean.DepartmentBean;
import com.project.bean.InsuranceBean;

/**
 * 领导根据部门搜索员工接口
 * @author SherLock
 *
 */
public interface IDepartmentService {

	/**
	 *  查看公司所有的部门
	 * @return 部门集合
	 */
	public List<DepartmentBean> departments();
	/**
	 * 统计所有部门数目
	 * @return 部门总数
	 */
	public int countDepart();
	/**
	 * 查看所有险种
	 * @return 险种集合
	 */
	public List<InsuranceBean> insurances();
	/**
	 * 统计险种数目
	 * @return 险种总数
	 */
	public int countInsurance();
	
}
