package com.project.departmentleader.gurantees.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;

/**
 *  部门负责人查看本部门的保单以及详情
 * @author SherLock
 *
 */
public interface IGuranteeService {

	/**
	 *  部门负责人查看本部门的有效保单
	 * @param pageNo 页码
	 * @param departId 部门的id
	 * @param start 起始日期
	 * @param end 结束日期
	 * @param favoree 受益人
	 * @param signer 签单人
	 * @param number 保单编号
	 * @return 保单分页对象
	 */
	public CutPageBean<GuranteeBean> gurantees(int pageNo,int departId
			,Date start,Date end,String favoree,String signer,
			String number);
	
	/**
	 *  查看保单详情
	 * @param id
	 * @return 保单对象
	 */
	public GuranteeBean guranteeInfo(int id);
	
	/**
	 * 添加理赔记录,同时修改保单状态
	 *  申请理赔(申请理赔后,修改保单的状态为理赔中;)
	 * @param id 保单id
	 * @param applyReason 申请理赔的原因
	 */
	public void applyClaim(int id,String applyReason);
	
	
	/**
	 *  终止保单将保单的状态改为终止失效
	 * @param id 保单的id
	 */
	public void terminate(int id);
	
}
