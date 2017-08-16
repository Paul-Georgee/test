package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
/**
 *  用户培训实体类
 *  这个实体类的使用是为了方便部门负责人和员工自己查询自己的培训成绩,
 *  培训的id,这个是为了方便从第三张中间表查询到分数
		private int trainId;
	培训的员工的id
		private int userId;
 * @author SherLock
 *
 */
@Alias("userTrainBean")
public class UserTrainBean {

	private int id;
	/** 培训开始时间*/
	private Date trainTime = new Date(System.currentTimeMillis());
	/** 培训结束时间*/
	private Date endTime;
	/**培训员工的姓名*/
	private String username;
	/**培训员工的电话*/
	private String tel;
	/**培训员工的部门*/
	private String department;
	/**培训员工的职位*/
	private String duty;
	/** 培训内容*/
	private String content;
	/** 培训地点*/
	private String location;
	/** 培训分数*/
	private Integer point;
	/**培训的id*/
	private Integer trainId;
	/**培训的员工的id*/
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
