package com.project.employee.orders.service;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;

/**
 *  业务员个人签单接口
 * @author SherLock
 *
 */
public interface IOrdersService {

	/**
	 *  业务员个人有效保单
	 * @param pageNo 页码
	 * @param followId 业务员的id
	 * @return 签单分页对象
	 */
	public CutPageBean<GuranteeBean> gurantees(int pageNo,int followId);
	
	/**
	 *  查看签单详情
	 * @param guranteeId 保单id
	 * @return 保单对象
	 */
	public GuranteeBean guranteeInfo(int guranteeId);
}
