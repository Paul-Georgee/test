package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 * 收件箱实体类
 * 
 * @author SherLock
 *
 */
@Alias("receiveBean")
public class ReceiveBean {

	private Integer id;
	/** 收到的邮件的状态已读或者未读 */
	private String state;
	/** 邮件主题 */
	private String title;
	/** 邮件是否丢到垃圾箱 */
	private String trash;
	/** 邮件实体类对象id */
	private Integer emailId;
	/** 邮件的收件人ID */
	private Integer receiverId;
	/** 邮件对象 */
	private EmailBean email;

	public EmailBean getEmail() {
		return email;
	}

	public void setEmail(EmailBean email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTrash() {
		return trash;
	}

	public void setTrash(String trash) {
		this.trash = trash;
	}

	public Integer getEmailId() {
		return emailId;
	}

	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}

	public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ReceiveBean() {
		super();
	}

	@Override
	public String toString() {
		return "ReceiveBean [id=" + id + ", state=" + state + ", title=" + title + ", trash=" + trash + ", emailId="
				+ emailId + ", receiverId=" + receiverId + ", email=" + email + "]";
	}

}
