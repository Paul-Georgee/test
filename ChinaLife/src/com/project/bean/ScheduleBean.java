package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
/**
 *  日程实体类
 * @author SherLock
 *
 */
@Alias("scheduleBean")
public class ScheduleBean {

	private Integer id;
	/**日程内容*/
	private String content;
	/**日程时间*/
	private Date scheduleTime;
	/**那个员工的日程*/
	private Integer userId;
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public ScheduleBean(String content, Date scheduleTime) {
		super();
		this.content = content;
		this.scheduleTime = scheduleTime;
	}

	public ScheduleBean() {
		super();
	}
	
	
}
