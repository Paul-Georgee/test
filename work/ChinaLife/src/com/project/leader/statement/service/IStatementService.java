package com.project.leader.statement.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.CompanyStatementBean;

/**
 *  �쵼�鿴��˾������״ͼ
 * @author SherLock
 *
 */
public interface IStatementService {
 
	/**
	 *  �鿴��˾������
	 * @param start ��ʼ����
	 * @param end ��������
	 * @return ��˾������
	 */
	public List<CompanyStatementBean> statements(Date start,Date end);
}
