package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
/**
 *  发件箱实体类
 * @author SherLock
 *
 */
@Alias("emailBean")
public class EmailBean {

	private Integer id;
	/** 标题 */
	private String title;
	/** 邮件内容 */
	private String content;
	/** 邮件附件 */
	private String attachment;
	/** 邮件是否丢到垃圾箱 */
	private String trash = "否";
	/** 邮件发送时间 */
	private Date emailTime = new Date(System.currentTimeMillis());
	/** 邮件发件人 */
	private Integer senderId;
	/** 发件人名称 */
	private String senderName;
	/**收件人列表*/
	private String receivers;
	
	
	public String getReceivers() {
		return receivers;
	}

	public void setReceivers(String receivers) {
		this.receivers = receivers;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getTrash() {
		return trash;
	}

	public void setTrash(String trash) {
		this.trash = trash;
	}

	public Date getEmailTime() {
		return emailTime;
	}

	public void setEmailTime(Date emailTime) {
		this.emailTime = emailTime;
	}

	public EmailBean() {
		super();
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public EmailBean(String title, String content, String attachment, Integer senderId) {
		super();
		this.title = title;
		this.content = content;
		this.attachment = attachment;
		this.senderId = senderId;
	}

	
	
	public EmailBean(String title, String content, Integer senderId) {
		super();
		this.title = title;
		this.content = content;
		this.senderId = senderId;
	}

	@Override
	public String toString() {
		return "EmailBean [id=" + id + ", title=" + title + ", content=" + content + ", attachment=" + attachment
				+ ", trash=" + trash + ", emailTime=" + emailTime + ", senderName=" + senderName + ", receivers="
				+ receivers + "]";
	}

}
