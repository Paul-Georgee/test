package com.project.publicinfo.forum.service;

import java.util.List;

import com.project.bean.ForumBean;

/**
 *  论坛接口
 * @author SherLock
 *
 */
public interface IForumService {

	/**
	 *  公司论坛的板块集合,同时查询板块的帖子数
	 * @return
	 */
	public List<ForumBean> forums();
	
	
	/**
	 *  添加板块
	 * @param forum 板块对象
	 */
	public void forumAdd(ForumBean forum);

}
