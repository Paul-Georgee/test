package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * 会议实体类
 * 
 * @author SherLock
 *
 */
@Alias("meetingBean")
public class MeetingBean {

	private Integer id;
	/** 会议主题 */
	private String title;
	/** 会议状态 */
	private String state = "未开会";
	/** 会议地址 */
	private String location;
	/** 会议的内容 */
	private String content;
	/** 会议时间 */
	private Date huiyiTime;
	/** 与会人员 */
	private String conferee;



	public String getConferee() {
		return conferee;
	}

	public void setConferee(String conferee) {
		this.conferee = conferee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getHuiyiTime() {
		return huiyiTime;
	}

	public void setHuiyiTime(Date huiyiTime) {
		this.huiyiTime = huiyiTime;
	}

	public MeetingBean() {
		super();
	}

	public MeetingBean(String title, String location, String content, Date huiyiTime, String conferee) {
		super();
		this.title = title;
		this.location = location;
		this.content = content;
		this.huiyiTime = huiyiTime;
		this.conferee = conferee;
	}


}
