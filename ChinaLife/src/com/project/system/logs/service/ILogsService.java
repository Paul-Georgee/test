package com.project.system.logs.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.LoginLogsBean;

/**
 * ��־�ӿ�
 * @author SherLock
 *
 */
public interface ILogsService {

	
	/**
	 * 
	 * @param pageNo ҳ��
	 * @param start ��ʵ����
	 * @param end ��������
	 * @return ����
	 */
	public CutPageBean<LoginLogsBean> loginLogs(int pageNo,
			Date start,Date end);
	

}
