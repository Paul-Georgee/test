package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 * �ռ���ʵ����
 * 
 * @author SherLock
 *
 */
@Alias("receiveBean")
public class ReceiveBean {

	private Integer id;
	/** �յ����ʼ���״̬�Ѷ�����δ�� */
	private String state;
	/** �ʼ����� */
	private String title;
	/** �ʼ��Ƿ񶪵������� */
	private String trash;
	/** �ʼ�ʵ�������id */
	private Integer emailId;
	/** �ʼ����ռ���ID */
	private Integer receiverId;
	/** �ʼ����� */
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
