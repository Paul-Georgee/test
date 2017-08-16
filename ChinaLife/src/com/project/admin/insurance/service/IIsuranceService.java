package com.project.admin.insurance.service;

import com.project.bean.CutPageBean;
import com.project.bean.InsuranceBean;

/**
 *  管理员的险种维护的模块接口
 * @author SherLock
 *
 */
public interface IIsuranceService {

	/**
	 *  添加险种
	 * @param insurance 险种对象
	 */
	public void add(InsuranceBean insurance);
	
	/**
	 * 将险种设置为失效
	 * @param id 险种的id
	 */
	public void inValid(int id);
	
	/**
	 * 按照名称查询险种,
	 * @param insuName 险种名称
	 * @param state 险种的状态
	 * @return 险种的分页对象
	 */
	public CutPageBean<InsuranceBean> insurances(int pageNo,String insuName,
			String state);
	
	/**
	 * 根据id查看险种详情
	 * @param id 险种id
	 * @return 险种对象
	 */
	public InsuranceBean findById(int id);
}
