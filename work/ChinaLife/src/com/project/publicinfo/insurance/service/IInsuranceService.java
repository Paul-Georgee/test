package com.project.publicinfo.insurance.service;

import com.project.bean.CutPageBean;
import com.project.bean.InsuranceBean;

/**
 *  公司险种接口
 * @author SherLock
 *
 */
public interface IInsuranceService {
	/**
	 * 按照名称查询有效险种
	 * @param insuName 险种名称
	 * @return 险种的分页对象
	 */
	public CutPageBean<InsuranceBean> insurances(int pageNo,String insuName);
	
	/**
	 * 根据id查看险种详情
	 * @param id 险种的id
	 * @return 险种对象
	 */
	public InsuranceBean findByid(int id);
}
