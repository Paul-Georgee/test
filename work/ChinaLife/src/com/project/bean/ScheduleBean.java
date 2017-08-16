package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
/**
 *  �ճ�ʵ����
 * @author SherLock
 *
 */
@Alias("scheduleBean")
public class ScheduleBean {

	private Integer id;
	/**�ճ�����*/
	private String content;
	/**�ճ�ʱ��*/
	private Date scheduleTime;
	/**�Ǹ�Ա�����ճ�*/
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
