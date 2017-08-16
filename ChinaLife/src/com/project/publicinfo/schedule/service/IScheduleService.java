package com.project.publicinfo.schedule.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.ScheduleBean;

public interface IScheduleService {

	/**
	 * 根据用户id查询用户当天的日程
	 * @param userId
	 * @return
	 */
	public List<ScheduleBean> schedules(int userId);
	
	/**
	 * 添加日程
	 * @param schedule 日程对象
	 * @param userId 用户的id
	 */
	public void addSchedule(ScheduleBean schedule,int userId);
	
	/**
	 * 动态条件查询日程
	 * @param pageNo 页码
	 * @param userId 用户的id
	 * @param cotent 日程内容
	 * @param beginTime 日程开始时间
	 * @return 日程分页对象
	 */
	public CutPageBean<ScheduleBean> allSchedule(int pageNo,int userId,
			String cotent,Date beginTime);
}
