package com.project.leader.gurantees.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;

/**
 *  �쵼�鿴��˾���еı���
 * @author SherLock
 *
 */
public interface IGuranteeService {

	/**
	 *  �쵼�鿴��˾�����еı���
	 * @param pageNo ҳ��
	 * @param departmentId ����id
	 * @param clientName Ͷ���ˣ��ͻ����ƣ�
	 * @param insureName ��������
	 * @param signer ǩ����
	 * @param state ����״̬(������)
	 * @param start ��ʼ����
	 * @param end ��������
	 * @return ������ҳ����
	 */
	public CutPageBean<GuranteeBean> gurantees(int pageNo,Integer departmentId,
			String clientName,String insureName,String signer,String state,Date start,Date end);
	
	/**
	 *  �쵼��׼��˾�����������,ͬʱҪ�޸ı����е�״̬Ϊ����ʧЧ
	 * @param id ������id
	 * @param auditId ����id
	 * @param auditReason ��˵�ԭ��
	 */
	public void update(int id,String auditReason);
	
	/**
	 * �쵼���ز�����������Ᵽ��,ͬʱ���������ɾ����¼,�����Ļ���Ч״̬
	 * @param id
	 * @param auditId ����id
	 */
	public void update(int id);
	
	/**
	 * �鿴��������,�쵼���Բ鿴����ԭ��
	 * @param id ������id
	 * @return ��������
	 */
	public GuranteeBean findById(int id);
	
	/**
	 * �쵼�鿴��˾�����Ᵽ��
	 * @return ��ҳ����
	 */
	public List<GuranteeBean> gurantees();
}
