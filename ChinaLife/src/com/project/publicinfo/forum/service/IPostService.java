package com.project.publicinfo.forum.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.PostBean;

/**
 * ���ӵĽӿ�
 * @author SherLock
 *
 */
public interface IPostService {

	/**
	 * ��˾ָ���������ӷ�ҳ����,ͬʱ���ݷ����ѯ���ӵĻ�����
	 * @param forumId ����id
	 * @param pageNo ҳ��
	 * @param username ����
	 * @param title ����
	 * @param start ��ʼ����
	 * @param end ��������
	 * @return ��ҳ����
	 */
	public CutPageBean<PostBean> posts(int forumId,int pageNo,
			String username,String title,Date start,Date end);
	
	/**
	 * ����������
	 * @param post ���Ӷ���
	 */
	public void publish(PostBean post);
	
	
	/**
	 *  �鿴���ӵĶ���,ͬʱ��ѯ��������
	 * @param id ���ӵ�id
	 * @return ���Ӷ���
	 */
	public PostBean postInfo(int id);
	
	
	/**
	 *  ɾ������,ͬʱɾ���������е�����
	 * @param id ���ӵ�id
	 */
	public void del(int id);
	
}
