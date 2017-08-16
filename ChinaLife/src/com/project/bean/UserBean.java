package com.project.bean;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
/**
 *  �û�ʵ����
 * @author SherLock
 *
 */
@Alias("userBean")
public class UserBean {

	private Integer id;
	/** �û��� */
	private String username;
	/**�û���ʵ����*/
	private String trueName;
	/** ����:Ĭ��888 */
	private String password = "888";
	/** �����ַ */
	private String email;
	/** �绰���� */
	private String tel;
	/** �Ա� */
	private String gender;
	/** ���� */
	private Date birthday;
	/** ͷ�� */
	private String avatar;
	/** ְλ */
	private String duty;
	/** ѧ�� */
	private String education;
	/** ״̬(��ְ,��ְ) */
	private String state = "��ְ";
	/** ϵͳ��ɫ:Ĭ����Ա�� */
	private String role;
	/** ����id */
	private Integer departId;
	/**��������*/
	private String department;
	/**Ա������ѵ����*/
	private List<UserTrainBean> trains;
	
	
	public List<UserTrainBean> getTrains() {
		return trains;
	}

	public void setTrains(List<UserTrainBean> trains) {
		this.trains = trains;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public UserBean() {
		super();
	}

	public UserBean(String username, String trueName, String password, String email, String tel, String gender,
			Date birthday, String avatar, String duty, String education, String role, Integer departId, String department) {
		super();
		this.username = username;
		this.trueName = trueName;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.gender = gender;
		this.birthday = birthday;
		this.avatar = avatar;
		this.duty = duty;
		this.education = education;
		this.role = role;
		this.departId = departId;
		this.department = department;
	}

	public UserBean(String username, String trueName, String password, String email, String tel, String gender,
			Date birthday, String avatar, String duty, String education, Integer departId) {
		super();
		this.username = username;
		this.trueName = trueName;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.gender = gender;
		this.birthday = birthday;
		this.avatar = avatar;
		this.duty = duty;
		this.education = education;
		this.departId = departId;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", trueName=" + trueName + ", password=" + password
				+ ", email=" + email + ", tel=" + tel + ", gender=" + gender + ", birthday=" + birthday + ", avatar="
				+ avatar + ", duty=" + duty + ", education=" + education + ", state=" + state + ", role=" + role
				+ ", departId=" + departId + ", department=" + department + ", trains=" + trains + "]";
	}

}
