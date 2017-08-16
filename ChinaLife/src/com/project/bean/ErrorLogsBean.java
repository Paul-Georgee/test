package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("errorLogsBean")
public class ErrorLogsBean {

	private Integer id;
	/**������־����*/
	private String content;
	/**��������ʱ��*/
	private Date errorDate;
	
	public Date getErrorDate() {
		return errorDate;
	}

	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}

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
	
	
}
