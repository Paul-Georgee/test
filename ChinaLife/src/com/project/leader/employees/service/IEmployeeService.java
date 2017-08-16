package com.project.leader.employees.service;


import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

/**
 * �쵼�鿴����Ա��������Ϣ�ӿ�
 * @author SherLock
 *
 */
public interface IEmployeeService {

	/**
	 * ����ID��ѯԱ������
	 * @return Ա������
	 */
	public UserBean findById(int id);
	/**
	 * �쵼�鿴����˾Ա���б�
	 * @param pageNo ҳ��
	 * @param trueName Ա����ʵ����
	 * @param departmentId ���ŵ�id
	 * @param duty Ա����ְ��
	 * @return Ա�����϶���
	 */
	public CutPageBean<UserBean> employees(int pageNo,String trueName,
			Integer departId,String duty);
	
}
