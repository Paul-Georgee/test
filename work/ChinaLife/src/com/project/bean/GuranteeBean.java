package com.project.bean;


import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 * ����ʵ����
 * 
 * @author SherLock
 *
 */
@Alias("guranteeBean")
public class GuranteeBean {

	private Integer id;
	/** Ͷ��ʱ�� */
	private Date insureTime;
	/** ������ */
	private String favoree;
	/** ǩ���� */
	private String signer;
	/** ������� */
	private String number;
	/** ����״̬,�Ƿ���Ч,�����������Ч,���û����������Ч */
	private String state = "��Ч";
	/** ������ҵ��Ա,ǩ���˸�ҵ��ԱҲ�����һ����,Ҳ�᲻��,���Ա����ְ,����Ա�������ͻ� */
	private Integer followerId;
	/*** �����˵����� */
	private String followerName;
	/**���������Ǹ�����;���ŵ�id*/
	private Integer departmentId;
	/**����ʱ��*/
	private Integer duration;
	/** �ͻ������������ */
	private InsuranceBean insurance;
	/** �ñ����Ŀͻ� */
	private ClientBean client;
	/** �ñ���������ʵ����� */
	private AuditBean audit;



	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public ClientBean getClient() {
		return client;
	}

	public void setClient(ClientBean client) {
		this.client = client;
	}

	public AuditBean getAudit() {
		return audit;
	}

	public void setAudit(AuditBean audit) {
		this.audit = audit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInsureTime() {
		return insureTime;
	}

	public void setInsureTime(Date insureTime) {
		this.insureTime = insureTime;
	}

	public String getFavoree() {
		return favoree;
	}

	public void setFavoree(String favoree) {
		this.favoree = favoree;
	}

	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getFollowerId() {
		return followerId;
	}

	public void setFollowerId(Integer followerId) {
		this.followerId = followerId;
	}

	public String getFollowerName() {
		return followerName;
	}

	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}

	public InsuranceBean getInsurance() {
		return insurance;
	}

	public void setInsurance(InsuranceBean insurance) {
		this.insurance = insurance;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public GuranteeBean() {
		super();
	}

	public GuranteeBean(Date insureTime, String favoree, String signer,
			String number, Integer followerId, Integer duration) {
		super();
		this.insureTime = insureTime;
		this.favoree = favoree;
		this.signer = signer;
		this.number = number;
		this.followerId = followerId;
		this.duration = duration;
	}


	public GuranteeBean(Date insureTime, String favoree, String signer, String number,
			Integer followerId, Integer departmentId, Integer duration, 
			InsuranceBean insurance, ClientBean client) {
		super();
		this.insureTime = insureTime;
		this.favoree = favoree;
		this.signer = signer;
		this.number = number;
		this.followerId = followerId;
		this.departmentId = departmentId;
		this.duration = duration;
		this.insurance = insurance;
		this.client = client;
	}

	@Override
	public String toString() {
		return "GuranteeBean [insureTime=" + insureTime + ", favoree=" + favoree + ", signer=" + signer + ", number="
				+ number + ", followerId=" + followerId + ", duration=" + duration + "]";
	}


}
