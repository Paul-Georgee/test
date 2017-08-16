package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 *  ��̳���ʵ��bean
 * @author SherLock
 *
 */
@Alias("forumBean")
public class ForumBean {

	private int id;
	/**�������*/
	private String forumName;
	/**����*/
	private String moderator;
	/**��������*/
	private Integer articles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getModerator() {
		return moderator;
	}

	public void setModerator(String moderator) {
		this.moderator = moderator;
	}

	public ForumBean(String forumName, String moderator) {
		super();
		this.forumName = forumName;
		this.moderator = moderator;
	}

	public ForumBean() {
		super();
	}

	public int getArticles() {
		return articles;
	}

	public void setArticles(int articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "ForumBean [id=" + id + ", forumName=" + forumName + ", moderator=" + moderator + ", articles="
				+ articles + "]";
	}
	
}
