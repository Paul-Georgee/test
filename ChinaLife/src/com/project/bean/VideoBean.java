package com.project.bean;


import java.sql.Date;

import org.apache.ibatis.type.Alias;
/**
 *  视频管理实体bean
 * @author SherLock
 *
 */
@Alias("videoBean")
public class VideoBean {

	private Integer id;
	/**视频名称*/
	private String videoName;
	/**视频缩略图*/
	private String videoAvatar;
	/**视频地址*/
	private String filePath;
	/**视频权限*/
	private String permission;
	/**视频主讲人*/
	private String speaker;
	/**视频标题*/
	private String title;
	/**视频发布时间*/
	private Date publishTime = new Date(System.currentTimeMillis());

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoAvatar() {
		return videoAvatar;
	}

	public void setVideoAvatar(String videoAvatar) {
		this.videoAvatar = videoAvatar;
	}


	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public VideoBean() {
		super();
	}

	public VideoBean(String videoName, String videoAvatar, String filePath, String permission, String speaker,
			String title) {
		super();
		this.videoName = videoName;
		this.videoAvatar = videoAvatar;
		this.filePath = filePath;
		this.permission = permission;
		this.speaker = speaker;
		this.title = title;
	}
	
}
