package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 *  规章制度实体类
 * @author SherLock
 *
 */
@Alias("rulesBean")
public class RulesBean {

	private Integer id;
	/**规章制度的名称*/
	private String ruleName;
	/**规章制度的内容*/
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public RulesBean(String ruleName, String content) {
		super();
		this.ruleName = ruleName;
		this.content = content;
	}

	public RulesBean() {
		super();
	}
	
	
}
