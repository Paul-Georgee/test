package com.project.admin.forum.service;

import com.project.bean.ForumBean;
/**
 * ����Ա��̳ά��
 * @author SherLock
 *
 */
public interface IForumService {
	/**
	 *  ɾ������
	 * @param id ���ӵ�id
	 */
	public void del(int id);
	
	/**
	 *  ��Ӱ��
	 * @param forum ������
	 */
	public void forumAdd(ForumBean forum);
}
