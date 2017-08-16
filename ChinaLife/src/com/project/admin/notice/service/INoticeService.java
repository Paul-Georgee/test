package com.project.admin.notice.service;

import java.util.List;

import com.project.bean.NoticeBean;

/**
 *  ����Ա�Ĺ���ģ��ӿ�
 * @author SherLock
 *
 */
public interface INoticeService {
	
	/**
	 *  ���漯��,���Ұ��շ���ʱ�併������
	 * @return ���漯��
	 */
	public List<NoticeBean> notices();
	
	/**
	 * �鿴����
	 * @param id �����id
	 * @return �������
	 */
	public NoticeBean notice(int id);
	
	/**
	 * ��ӹ���
	 * @param notice �������
	 */
	public void publish(NoticeBean notice);
	/**
	 * ɾ������
	 * @param id �����id
	 */
	public void del(int id);
}
