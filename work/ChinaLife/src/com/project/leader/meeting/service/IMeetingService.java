package com.project.leader.meeting.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;

public interface IMeetingService {

	/**
	 * �쵼�鿴��˾�����¼
	 * @param pageNo ҳ��
	 * @param title ����
	 * @param start ��ʼ����
	 * @param end ��������
	 * @return ����ķ�ҳ����
	 */
	public CutPageBean<MeetingBean> findByitem(int pageNo,String title,Date start,
			Date end);
	
	/**
	 * 
	 * @param id �����id
	 * @return �������
	 */
	public MeetingBean findById(int id);
	
	
}
