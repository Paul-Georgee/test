package com.project.bean;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * ����ʵ����
 * 
 * @author SherLock
 *
 */
@Alias("postBean")
public class PostBean {

	private Integer id;
	/** ���ӱ��� */
	private String title;
	/** �������� */
	private String content;
	/** ��������id */
	private Integer authorId;
	/** �������ߵ����� */
	private String authorName;

	private String authorAvatar;
	/*** ������������id */
	private Integer forumId;
	/** �������� */
	private String forumName;
	/** ����ʱ�� */
	private Date postTime = new Date(System.currentTimeMillis());
	/** �������� */
	private Integer count;

	private List<CommentBean> comments;

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

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorAvatar() {
		return authorAvatar;
	}

	public void setAuthorAvatar(String authorAvatar) {
		this.authorAvatar = authorAvatar;
	}

	public Integer getForumId() {
		return forumId;
	}

	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<CommentBean> getComments() {
		return comments;
	}

	public void setComments(List<CommentBean> comments) {
		this.comments = comments;
	}

	public PostBean(String title, String content, int authorId, int forumId) {
		super();
		this.title = title;
		this.content = content;
		this.authorId = authorId;
		this.forumId = forumId;
	}

	public PostBean() {
		super();
	}

	@Override
	public String toString() {
		return "PostBean [id=" + id + ", title=" + title + ", content=" + content + ", authorId=" + authorId
				+ ", authorName=" + authorName + ", authorAvatar=" + authorAvatar + ", forumId=" + forumId
				+ ", forumName=" + forumName + ", postTime=" + postTime + ", count=" + count + ", comments=" + comments
				+ "]";
	}



}
