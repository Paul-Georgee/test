package com.project.publicinfo.login.service;


import com.project.bean.UserBean;

public interface ILoginService {

	/**
	 *  ��ѯ�û���������ͬʱ��ְ��Ա��,��¼��¼��־
	 * @param username �û���
	 * @param password ����
	 * @return �����û�����,���û���ҵ�,�ͷ��ؿ�
	 */
	public UserBean login(String username,String password);
	
	
}
