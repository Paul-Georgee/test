package com.project.bean;

import org.apache.ibatis.type.Alias;

@Alias("insuranceBean")
public class InsuranceBean {

	private Integer id;
	/** �������� */
	private String insuName;
	/** ���ּ۸� */
	private Integer price;
	/** ���ֱ��յ����� */
	private String content;
	/** ��������,�����ջ��������ȵ� */
	private String genre;
	/** �������Ƿ���Ч,���Ƿ��Ѿ����ϲ�Ʒ */
	private String validOrNot = "��Ч";
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInsuName() {
		return insuName;
	}

	public void setInsuName(String insuName) {
		this.insuName = insuName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getValidOrNot() {
		return validOrNot;
	}

	public void setValidOrNot(String validOrNot) {
		this.validOrNot = validOrNot;
	}

	public InsuranceBean() {
		super();
	}

	public InsuranceBean(String insuName, Integer price, String content, String genre) {
		super();
		this.insuName = insuName;
		this.price = price;
		this.content = content;
		this.genre = genre;
	}

	public InsuranceBean(Integer id) {
		super();
		this.id = id;
	}


}
