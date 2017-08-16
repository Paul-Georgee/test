package com.project.admin.meeting.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;
import com.project.bean.UserBean;

/**
 * ����Ա�Ļ������ģ��ӿ�
 * @author SherLock
 *
 */
public interface IMeetingService {

	/**
	 * �����ֶζ�̬��������
	 * @param pageNo �����ҳ��
	 * @param title �������
	 * @param start ��ʼ����
	 * @param end ��������
	 * @return ����ķ�ҳ����
	 */
	public CutPageBean<MeetingBean> meetings(int pageNo,String title,
			Date start,Date end);
	
	/**
	 * �鿴��������
	 * @param id �����id
	 * @return �������
	 */
	public MeetingBean findById(int id);
	
	/**
	 *  �޸Ļ�����,ͬʱ������״̬��Ϊ����
	 * @param id �����id
	 * @param content ���
	 */
	public void update(int id,String content);

	
	/**
	 *  ��ӻ���
	 * @param meeting �������
	 * @param conferee �λ���Ա������(���ù����ཫ,�����е��ַ���ƴ�ӳ�һ�����ַ�)
	 */
	public void add(MeetingBean meeting,String[] conferee);
}
