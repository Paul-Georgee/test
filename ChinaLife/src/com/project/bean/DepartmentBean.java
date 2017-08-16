package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 * 部门实体类
 * @author SherLock
 *
 */
@Alias("departmentBean")
public class DepartmentBean {

	private Integer id;
	/**部门名称*/
	private String departName;
	/**部门描述*/
	private String departDescription;
	/**负责人id*/
	private Integer userId;
	/**负责人名称*/
	private String leader = "没有负责人";
	/**部门的总人数*/
	private Integer count;
	
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartDescription() {
		return departDescription;
	}

	public void setDepartDescription(String departDescription) {
		this.departDescription = departDescription;
	}

	public DepartmentBean(String departName, String departDescription, Integer userId) {
		super();
		this.departName = departName;
		this.departDescription = departDescription;
		this.userId = userId;
	}

	public DepartmentBean(String departName, String departDescription) {
		super();
		this.departName = departName;
		this.departDescription = departDescription;
	}

	public DepartmentBean() {
		super();
	}

	@Override
	public String toString() {
		return "DepartmentBean [id=" + id + ", departName=" + departName + ", departDescription=" + departDescription
				+ ", userId=" + userId + ", leader=" + leader + ", count=" + count + "]";
	}

}
