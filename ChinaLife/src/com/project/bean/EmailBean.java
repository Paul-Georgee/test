package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
/**
 *  ������ʵ����
 * @author SherLock
 *
 */
@Alias("emailBean")
public class EmailBean {

	private Integer id;
	/** ���� */
	private String title;
	/** �ʼ����� */
	private String content;
	/** �ʼ����� */
	private String attachment;
	/** �ʼ��Ƿ񶪵������� */
	private String trash = "��";
	/** �ʼ�����ʱ�� */
	private Date emailTime = new Date(System.currentTimeMillis());
	/** �ʼ������� */
	private Integer senderId;
	/** ���������� */
	private String senderName;
	/**�ռ����б�*/
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
