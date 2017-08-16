package com.project.admin.forum.service;

import com.project.bean.ForumBean;
/**
 * 管理员论坛维护
 * @author SherLock
 *
 */
public interface IForumService {
	/**
	 *  删除帖子
	 * @param id 帖子的id
	 */
	public void del(int id);
	
	/**
	 *  添加板块
	 * @param forum 板块对象
	 */
	public void forumAdd(ForumBean forum);
}
