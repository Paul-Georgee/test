package com.project.publicinfo.insurance.service;

import com.project.bean.CutPageBean;
import com.project.bean.InsuranceBean;

/**
 *  ��˾���ֽӿ�
 * @author SherLock
 *
 */
public interface IInsuranceService {
	/**
	 * �������Ʋ�ѯ��Ч����
	 * @param insuName ��������
	 * @return ���ֵķ�ҳ����
	 */
	public CutPageBean<InsuranceBean> insurances(int pageNo,String insuName);
	
	/**
	 * ����id�鿴��������
	 * @param id ���ֵ�id
	 * @return ���ֶ���
	 */
	public InsuranceBean findByid(int id);
}
