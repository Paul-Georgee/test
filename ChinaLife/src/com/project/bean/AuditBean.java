package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * ������
 * @author SherLock
 *
 */
@Alias("auditBean")
public class AuditBean {
	private Integer id;
	/**����ʱ��*/
	private Date applyTime = new Date(System.currentTimeMillis());
	/**����ԭ��*/
	private String applyReason;
	/**��׼���߲���ʱ��*/
	private Date auditTime;
	/**��׼���߲���ԭ��*/
	private String auditReason;
	/**������id*/
	private Integer policyId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getAuditReason() {
		return auditReason;
	}

	public void setAuditReason(String auditReason) {
		this.auditReason = auditReason;
	}

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public AuditBean(Date applyTime, String applyReason, Integer policyId) {
		super();
		this.applyTime = applyTime;
		this.applyReason = applyReason;
		this.policyId = policyId;
	}

	public AuditBean(Integer id,Date auditTime, String auditReason, Integer policyId) {
		super();
		this.auditTime = auditTime;
		this.auditReason = auditReason;
		this.policyId = policyId;
	}

	public AuditBean() {
		super();
	}
	
	
}
