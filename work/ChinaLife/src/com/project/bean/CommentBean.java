package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * 评论实体类
 * 
 * @author SherLock
 *
 */
@Alias("commentBean")
public class CommentBean {

	private Integer id;
	/** 评论内容 */
	private String content;
	/** 评论时间默认系统时间 */
	private Date commentTime = new Date(System.currentTimeMillis());
	/** 评论的用户id */
	private Integer commenterId;
	/** 帖子的id */
	private Integer postId;
	/** 评论人名称 */
	private String commenter;
	/** 评论人的头像 */
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
