package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("loginLogsBean")
public class LoginLogsBean {

	private Integer id;
	/**µÇÂ¼ÄÚÈÝ*/
	private String content;
	/** µÇÂ¼Ê±¼ä*/
	private Date loginTime = new Date(System.currentTimeMillis());

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

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public LoginLogsBean() {
		super();
	}

}
