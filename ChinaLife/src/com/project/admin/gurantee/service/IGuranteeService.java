package com.project.admin.gurantee.service;

import java.util.List;

import com.project.bean.GuranteeBean;

/**
 * 管理员上传保单接口
 * @author SherLock
 *
 */
public interface IGuranteeService {

	/**
	 * 管理员上传保单
	 * @param gurantees 保单对象集合
	 */
	public void upload(List<GuranteeBean> gurantees);
}
