package com.project.publicinfo.forum.service;

import com.project.bean.CommentBean;

/**
 * �����ӿ�
 * @author SherLock
 *
 */
public interface ICommentService {
	/**
	 *  ��һ�����ӻ���
	 * @param comment ��������
	 */
	public void comment(CommentBean comment);
	
	/**
	 * ɾ������
	 * @param id ������id
	 */
	public void delComment(int id);
}
