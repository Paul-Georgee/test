package com.project.publicinfo.forum.service;

import java.util.List;

import com.project.bean.ForumBean;

/**
 *  ��̳�ӿ�
 * @author SherLock
 *
 */
public interface IForumService {

	/**
	 *  ��˾��̳�İ�鼯��,ͬʱ��ѯ����������
	 * @return
	 */
	public List<ForumBean> forums();
	
	
	/**
	 *  ��Ӱ��
	 * @param forum ������
	 */
	public void forumAdd(ForumBean forum);

}
