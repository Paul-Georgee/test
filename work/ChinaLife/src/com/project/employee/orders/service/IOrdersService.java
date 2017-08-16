package com.project.employee.orders.service;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;

/**
 *  ҵ��Ա����ǩ���ӿ�
 * @author SherLock
 *
 */
public interface IOrdersService {

	/**
	 *  ҵ��Ա������Ч����
	 * @param pageNo ҳ��
	 * @param followId ҵ��Ա��id
	 * @return ǩ����ҳ����
	 */
	public CutPageBean<GuranteeBean> gurantees(int pageNo,int followId);
	
	/**
	 *  �鿴ǩ������
	 * @param guranteeId ����id
	 * @return ��������
	 */
	public GuranteeBean guranteeInfo(int guranteeId);
}
