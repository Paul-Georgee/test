package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 * ���ű���ʵ����
 * 
 * @author SherLock
 *
 */
@Alias("departStatemenBean")
public class DepartStatementBean {

	/** ǩ�� */
	private Integer count;
	/** ǩ����ҵ��Ա */
	private String username;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public DepartStatementBean() {
		super();
	}

}
