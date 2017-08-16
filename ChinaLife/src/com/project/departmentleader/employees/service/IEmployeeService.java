package com.project.departmentleader.employees.service;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;

/**
 *  ���Ÿ����˲鿴������Ա���ӿ�
 * @author SherLock
 *
 */
public interface IEmployeeService {

	/**
	 * ���Ÿ����˲鿴������Ա��
	 * @param pageNo ҳ��
	 * @param departId ���ŵ�id
	 * @param trueName Ա������ʵ����
	 * @param duty Ա����ְλ
	 * @return Ա����ҳ����
	 */
	public CutPageBean<UserBean> employees(int pageNo,int departId,
			String trueName,String duty);
	
	/**
	 * 
	 * ������Ա������ϸ���,����Ա����ѵ�ĳɼ�
	 * @param userId Ա����id
	 * @return Ա������
	 */
	public UserBean employeeInfo(int userId);
	
}
