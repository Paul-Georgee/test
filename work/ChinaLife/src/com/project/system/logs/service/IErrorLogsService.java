package com.project.system.logs.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.ErrorLogsBean;

/**
 * ������־�ӿ�
 * @author SherLock
 *
 */
public interface IErrorLogsService {

	/**
	 * ������־����ʱ��η�ҳ��ѯ
	 * @param pageNo ҳ��
	 * @param start ��ʵ����
	 * @param end ��������
	 * @return ��ҳ����
	 */
	public CutPageBean<ErrorLogsBean> errorLogs(int pageNo,
			Date start,Date end);
}
