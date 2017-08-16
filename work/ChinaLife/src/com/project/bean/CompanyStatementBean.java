package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 * 公司报表实体类
 * 返回一个list集合
 * @author SherLock
 *
 */
@Alias("companyStatementBean")
public class CompanyStatementBean {

	/** 销售数量 */
	private Integer count;
	/** 部门名称 */
	private String department;
	/** 险种名称 */
	private String insurance;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

}
