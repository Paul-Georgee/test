package com.project.leader.meeting.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;

public interface IMeetingService {

	/**
	 * 领导查看公司会议记录
	 * @param pageNo 页码
	 * @param title 标题
	 * @param start 起始日期
	 * @param end 结束日期
	 * @return 会议的分页对象
	 */
	public CutPageBean<MeetingBean> findByitem(int pageNo,String title,Date start,
			Date end);
	
	/**
	 * 
	 * @param id 会议的id
	 * @return 会议对象
	 */
	public MeetingBean findById(int id);
	
	
}
