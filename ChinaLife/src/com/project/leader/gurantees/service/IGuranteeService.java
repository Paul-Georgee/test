package com.project.leader.gurantees.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;

/**
 *  领导查看公司所有的保单
 * @author SherLock
 *
 */
public interface IGuranteeService {

	/**
	 *  领导查看公司的所有的保单
	 * @param pageNo 页码
	 * @param departmentId 部门id
	 * @param clientName 投保人（客户名称）
	 * @param insureName 险种名称
	 * @param signer 签单人
	 * @param state 保单状态(下拉框)
	 * @param start 起始日期
	 * @param end 结束日期
	 * @return 保单分页对象
	 */
	public CutPageBean<GuranteeBean> gurantees(int pageNo,Integer departmentId,
			String clientName,String insureName,String signer,String state,Date start,Date end);
	
	/**
	 *  领导批准公司的申请理赔表单,同时要修改保单中的状态为理赔失效
	 * @param id 保单的id
	 * @param auditId 理赔id
	 * @param auditReason 审核的原因
	 */
	public void update(int id,String auditReason);
	
	/**
	 * 领导驳回部门申请的理赔保单,同时从理赔表中删除记录,保单改回有效状态
	 * @param id
	 * @param auditId 理赔id
	 */
	public void update(int id);
	
	/**
	 * 查看保单详情,领导可以查看理赔原因
	 * @param id 保单的id
	 * @return 保单对象
	 */
	public GuranteeBean findById(int id);
	
	/**
	 * 领导查看公司的理赔保单
	 * @return 分页对象
	 */
	public List<GuranteeBean> gurantees();
}
