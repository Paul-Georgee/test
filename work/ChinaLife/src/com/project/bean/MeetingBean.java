package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * ����ʵ����
 * 
 * @author SherLock
 *
 */
@Alias("meetingBean")
public class MeetingBean {

	private Integer id;
	/** �������� */
	private String title;
	/** ����״̬ */
	private String state = "δ����";
	/** �����ַ */
	private String location;
	/** ��������� */
	private String content;
	/** ����ʱ�� */
	private Date huiyiTime;
	/** �����Ա */
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
