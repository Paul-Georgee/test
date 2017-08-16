package com.project.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

/**
 *  客户实体类
 * @author SherLock
 *
 */
@Alias("clientBean")
public class ClientBean {

	private Integer id;
	/**客户姓名*/
	private String clientName;
	/**客户电话*/
	private String tel;
	/**客户性别*/
	private String gender;
	/**客户职业*/
	private String profession;
	/**客户家庭情况*/
	private String family;
	/**客户收入*/
	private Integer salary;
	/**客户生日*/
	private Date birthday;
	/**业务员的id*/
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
