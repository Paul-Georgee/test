package com.project.departmentleader.statement.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.DepartStatementBean;

/**
 * ���Ÿ����˲鿴�����ŵĶ�������
 * @author SherLock
 *
 */
public interface IStatementService {

	/**
	 * ���Ը���ʱ�������ѯ����ҵ�񱨱�
	 * @param id ���ŵ�id
	 * @param start ��ʼ����
	 * @param end ��������
	 * @return ������󼯺�
	 */
	public List<DepartStatementBean> statements(int id,Date start,Date end);
}
