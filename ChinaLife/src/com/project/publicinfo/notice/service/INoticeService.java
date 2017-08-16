package com.project.publicinfo.notice.service;

import java.util.List;

import com.project.bean.NoticeBean;

/**
 *  公告接口
 * @author SherLock
 *
 */
public interface INoticeService {

	/**
	 *  公告集合,并且按照发布时间降序排列
	 * @return 公告集合
	 */
	public List<NoticeBean> notices();
	
	
	/**
	 * 查看公告
	 * @param id 公告的id
	 * @return 公告对象
	 */
	public NoticeBean notice(int id);

}
