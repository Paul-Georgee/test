package com.project.admin.gurantee.service;

import java.util.List;

import com.project.bean.GuranteeBean;

/**
 * ����Ա�ϴ������ӿ�
 * @author SherLock
 *
 */
public interface IGuranteeService {

	/**
	 * ����Ա�ϴ�����
	 * @param gurantees �������󼯺�
	 */
	public void upload(List<GuranteeBean> gurantees);
}
