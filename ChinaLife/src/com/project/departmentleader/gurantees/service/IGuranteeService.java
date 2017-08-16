package com.project.departmentleader.gurantees.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;

/**
 *  ���Ÿ����˲鿴�����ŵı����Լ�����
 * @author SherLock
 *
 */
public interface IGuranteeService {

	/**
	 *  ���Ÿ����˲鿴�����ŵ���Ч����
	 * @param pageNo ҳ��
	 * @param departId ���ŵ�id
	 * @param start ��ʼ����
	 * @param end ��������
	 * @param favoree ������
	 * @param signer ǩ����
	 * @param number �������
	 * @return ������ҳ����
	 */
	public CutPageBean<GuranteeBean> gurantees(int pageNo,int departId
			,Date start,Date end,String favoree,String signer,
			String number);
	
	/**
	 *  �鿴��������
	 * @param id
	 * @return ��������
	 */
	public GuranteeBean guranteeInfo(int id);
	
	/**
	 * ��������¼,ͬʱ�޸ı���״̬
	 *  ��������(���������,�޸ı�����״̬Ϊ������;)
	 * @param id ����id
	 * @param applyReason ���������ԭ��
	 */
	public void applyClaim(int id,String applyReason);
	
	
	/**
	 *  ��ֹ������������״̬��Ϊ��ֹʧЧ
	 * @param id ������id
	 */
	public void terminate(int id);
	
}
