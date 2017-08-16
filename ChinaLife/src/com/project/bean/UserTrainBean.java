package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
/**
 *  �û���ѵʵ����
 *  ���ʵ�����ʹ����Ϊ�˷��㲿�Ÿ����˺�Ա���Լ���ѯ�Լ�����ѵ�ɼ�,
 *  ��ѵ��id,�����Ϊ�˷���ӵ������м���ѯ������
		private int trainId;
	��ѵ��Ա����id
		private int userId;
 * @author SherLock
 *
 */
@Alias("userTrainBean")
public class UserTrainBean {

	private int id;
	/** ��ѵ��ʼʱ��*/
	private Date trainTime = new Date(System.currentTimeMillis());
	/** ��ѵ����ʱ��*/
	private Date endTime;
	/**��ѵԱ��������*/
	private String username;
	/**��ѵԱ���ĵ绰*/
	private String tel;
	/**��ѵԱ���Ĳ���*/
	private String department;
	/**��ѵԱ����ְλ*/
	private String duty;
	/** ��ѵ����*/
	private String content;
	/** ��ѵ�ص�*/
	private String location;
	/** ��ѵ����*/
	private Integer point;
	/**��ѵ��id*/
	private Integer trainId;
	/**��ѵ��Ա����id*/
	private Integer userId;
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(Date trainTime) {
		this.trainTime = trainTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public UserTrainBean() {
		super();
	}

	@Override
	public String toString() {
		return "UserTrainBean [id=" + id + ", trainTime=" + trainTime + ", endTime=" + endTime + ", username="
				+ username + ", tel=" + tel + ", department=" + department + ", duty=" + duty + ", content=" + content
				+ ", location=" + location + ", point=" + point + ", trainId=" + trainId + ", userId=" + userId + "]";
	}
	
	
}
