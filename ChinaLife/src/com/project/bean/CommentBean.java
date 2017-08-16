package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * ����ʵ����
 * 
 * @author SherLock
 *
 */
@Alias("commentBean")
public class CommentBean {

	private Integer id;
	/** �������� */
	private String content;
	/** ����ʱ��Ĭ��ϵͳʱ�� */
	private Date commentTime = new Date(System.currentTimeMillis());
	/** ���۵��û�id */
	private Integer commenterId;
	/** ���ӵ�id */
	private Integer postId;
	/** ���������� */
	private String commenter;
	/** �����˵�ͷ�� */
	private String avatar;
	
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

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getCommenterId() {
		return commenterId;
	}

	public void setCommenterId(Integer commenterId) {
		this.commenterId = commenterId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public CommentBean() {
		super();
	}

	public CommentBean(String content, Integer commenterId, Integer postId) {
		super();
		this.content = content;
		this.commenterId = commenterId;
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "CommentBean [id=" + id + ", content=" + content + ", commentTime=" + commentTime + ", commenter="
				+ commenter + ", avatar=" + avatar + "]";
	}

}
