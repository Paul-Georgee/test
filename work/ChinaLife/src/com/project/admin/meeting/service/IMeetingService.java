package com.project.admin.meeting.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;
import com.project.bean.UserBean;

/**
 * 管理员的会议管理模块接口
 * @author SherLock
 *
 */
public interface IMeetingService {

	/**
	 * 根据字段动态搜索会议
	 * @param pageNo 会议的页码
	 * @param title 会议标题
	 * @param start 起始日期
	 * @param end 结束日期
	 * @return 会议的分页对象
	 */
	public CutPageBean<MeetingBean> meetings(int pageNo,String title,
			Date start,Date end);
	
	/**
	 * 查看会议详情
	 * @param id 会议的id
	 * @return 会议对象
	 */
	public MeetingBean findById(int id);
	
	/**
	 *  修改会议结果,同时将会议状态改为结束
	 * @param id 会议的id
	 * @param content 结果
	 */
	public void update(int id,String content);

	
	/**
	 *  添加会议
	 * @param meeting 会议对象
	 * @param conferee 参会人员的数组(调用工具类将,数组中的字符串拼接成一个长字符)
	 */
	public void add(MeetingBean meeting,String[] conferee);
}
