package com.project.admin.train.service;


import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

public interface IEmployeeService {

	/**
	 * ����Ա�����ѵ��ʱ����Ҫ��ȡ����Ҫ��ѵ����Ա�б�
	 * @param pageNo ��ҳҳ��
	 * @param trueName ��Ҫģ����ѯ��Ա����ʵ����
	 * @return Ա����ҳ����
	 */
	public CutPageBean<UserBean> trainers(int pageNo, String trueName);
}
