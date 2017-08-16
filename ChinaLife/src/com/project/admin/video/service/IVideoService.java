package com.project.admin.video.service;

import com.project.bean.CutPageBean;
import com.project.bean.VideoBean;

/**
 * 管理员管理视频模块
 * @author SherLock
 *
 */
public interface IVideoService {
	
	/**
	 *  查看视频分页列表
	 * @param pageNo 页码
	 * @param speaker 主讲人
	 * @param videoName 视频名称
	 * @param permission 权限名称(也就是员工的角色)
	 * @return 分页对象
	 */
	public CutPageBean<VideoBean> findByItem(int pageNo,String speaker,String videoName,
			String permission);
	
	/**
	 * 添加视频
	 * @param vbean
	 * @param permission 权限数组
	 */
	public void add(VideoBean vbean,String[] permission);
	
	/**
	 * 查看视频
	 * @param id 视频id
	 * @return 视频对象
	 */
	public VideoBean findById(int id);
	
	/**
	 * 修改视频可观看权限
	 * @param id 视频id
	 * @param permission 新的权限的数组
	 */
	public void update(int id,String[] permission);
	
	/**
	 * 删除视频
	 * @param id 视频id
	 */
	public void del(int id);
}
