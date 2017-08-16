package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * 公告实体类
 * 
 * @author SherLock
 *
 */
@Alias("noticeBean")
public class NoticeBean {

	private Integer id;
	/** 公告类型 */
	private String genre;
	/** 公告标题 */
	private String title;
	/** 公告内容 */
	private String content;
	/** 公告时间 */
	private Date noticeTime = new Date(System.currentTimeMillis());
	/** 公告附件 */
	private String filePath;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}


	public NoticeBean() {
		super();
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public NoticeBean(String genre, String title, String content, String filePath) {
		super();
		this.genre = genre;
		this.title = title;
		this.content = content;
		this.filePath = filePath;
	}


}
