package com.project.publicinfo.forum.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.PostBean;

/**
 * 帖子的接口
 * @author SherLock
 *
 */
public interface IPostService {

	/**
	 * 公司指定板块的帖子分页对象,同时根据分组查询帖子的回帖数
	 * @param forumId 板块的id
	 * @param pageNo 页码
	 * @param username 作者
	 * @param title 标题
	 * @param start 起始日期
	 * @param end 结束日期
	 * @return 分页对象
	 */
	public CutPageBean<PostBean> posts(int forumId,int pageNo,
			String username,String title,Date start,Date end);
	
	/**
	 * 发表新帖子
	 * @param post 帖子对象
	 */
	public void publish(PostBean post);
	
	
	/**
	 *  查看帖子的对象,同时查询回帖集合
	 * @param id 帖子的id
	 * @return 帖子对象
	 */
	public PostBean postInfo(int id);
	
	
	/**
	 *  删除帖子,同时删除回帖表中的数据
	 * @param id 帖子的id
	 */
	public void del(int id);
	
}
