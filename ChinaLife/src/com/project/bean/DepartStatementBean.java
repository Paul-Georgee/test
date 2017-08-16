package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 * 部门报表实体类
 * 
 * @author SherLock
 *
 */
@Alias("departStatemenBean")
public class DepartStatementBean {

	/** 签单 */
	private Integer count;
	/** 签单的业务员 */
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
