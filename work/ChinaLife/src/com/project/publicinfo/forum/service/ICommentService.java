package com.project.publicinfo.forum.service;

import com.project.bean.CommentBean;

/**
 * 回帖接口
 * @author SherLock
 *
 */
public interface ICommentService {
	/**
	 *  给一个帖子回帖
	 * @param comment 回帖对象
	 */
	public void comment(CommentBean comment);
	
	/**
	 * 删除回帖
	 * @param id 回帖的id
	 */
	public void delComment(int id);
}
