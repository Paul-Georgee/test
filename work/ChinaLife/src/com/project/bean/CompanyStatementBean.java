package com.project.bean;

import org.apache.ibatis.type.Alias;

/**
 * ��˾����ʵ����
 * ����һ��list����
 * @author SherLock
 *
 */
@Alias("companyStatementBean")
public class CompanyStatementBean {

	/** �������� */
	private Integer count;
	/** �������� */
	private String department;
	/** �������� */
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
