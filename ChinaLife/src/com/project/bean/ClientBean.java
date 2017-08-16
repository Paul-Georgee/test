package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 *  �ͻ�ʵ����
 * @author SherLock
 *
 */
@Alias("clientBean")
public class ClientBean {

	private Integer id;
	/**�ͻ�����*/
	private String clientName;
	/**�ͻ��绰*/
	private String tel;
	/**�ͻ��Ա�*/
	private String gender;
	/**�ͻ�ְҵ*/
	private String profession;
	/**�ͻ���ͥ���*/
	private String family;
	/**�ͻ�����*/
	private Integer salary;
	/**�ͻ�����*/
	private Date birthday;
	/**ҵ��Ա��id*/
	private Integer user_id;
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ClientBean() {
		super();
	}

	@Override
	public String toString() {
		return "ClientBean [id=" + id + ", clientName=" + clientName + ", tel=" + tel + ", gender=" + gender
				+ ", profession=" + profession + ", family=" + family + ", salary=" + salary + ", birthday=" + birthday
				+ "]";
	}

	public ClientBean(String clientName, String tel, String gender, String profession, String family, int salary,
			Date birthday, Integer user_id) {
		super();
		this.clientName = clientName;
		this.tel = tel;
		this.gender = gender;
		this.profession = profession;
		this.family = family;
		this.salary = salary;
		this.birthday = birthday;
		this.user_id = user_id;
	}

	public ClientBean(Integer id) {
		super();
		this.id = id;
	}

}
