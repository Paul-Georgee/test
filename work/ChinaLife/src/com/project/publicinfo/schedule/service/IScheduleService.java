package com.project.publicinfo.schedule.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.ScheduleBean;

public interface IScheduleService {

	/**
	 * �����û�id��ѯ�û�������ճ�
	 * @param userId
	 * @return
	 */
	public List<ScheduleBean> schedules(int userId);
	
	/**
	 * ����ճ�
	 * @param schedule �ճ̶���
	 * @param userId �û���id
	 */
	public void addSchedule(ScheduleBean schedule,int userId);
	
	/**
	 * ��̬������ѯ�ճ�
	 * @param pageNo ҳ��
	 * @param userId �û���id
	 * @param cotent �ճ�����
	 * @param beginTime �ճ̿�ʼʱ��
	 * @return �ճ̷�ҳ����
	 */
	public CutPageBean<ScheduleBean> allSchedule(int pageNo,int userId,
			String cotent,Date beginTime);
}
