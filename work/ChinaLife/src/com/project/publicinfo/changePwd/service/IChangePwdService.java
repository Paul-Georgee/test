package com.project.publicinfo.changePwd.service;

/**
 * �û��޸�����ģ��
 * @author SherLock
 *
 */
public interface IChangePwdService {
	/**
	 *  �û��޸�����
	 * @param id �û���id
	 * @param password �µ�����
	 */
	public void updatePwd(int id,String password);
}
