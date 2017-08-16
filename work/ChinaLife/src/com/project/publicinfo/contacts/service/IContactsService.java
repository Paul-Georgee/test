package com.project.publicinfo.contacts.service;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

/**
 *  ��˾Ա��ͨѶ¼�Ľӿ�
 * @author SherLock
 *
 */
public interface IContactsService {

	/**
	 *  ��˾Ա��ͨѶ¼����ְԱ���ļ���
	 * @param pageNo ҳ��
	 * @param trueName Ա����ʵ����
	 * @param duty ְλ
	 * @param departmentId ���ŵ�id
	 * @return ��˾ͨѶ¼�ķ�ҳ����
	 */
	public CutPageBean<UserBean> contacts(int pageNo,String trueName,
			String duty,Integer departmentId);
	
}
