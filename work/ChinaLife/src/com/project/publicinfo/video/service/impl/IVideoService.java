package com.project.publicinfo.video.service.impl;

import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.VideoBean;

public interface IVideoService {

	/**
	 * 根据权限在首页显示两条视频
	 * @param permission 权限的模糊字符串
	 * @return 两条视频
	 */
	public List<VideoBean> findVideoTop2(String permission);
	
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
	 *  根据id查看视频
	 * @param id 视频的id
	 * @return 视频对象 
	 */
	public VideoBean findById(int id);
}
