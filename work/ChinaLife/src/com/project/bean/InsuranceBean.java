package com.project.bean;

import org.apache.ibatis.type.Alias;

@Alias("insuranceBean")
public class InsuranceBean {

	private Integer id;
	/** 险种名称 */
	private String insuName;
	/** 险种价格 */
	private Integer price;
	/** 险种保险的内容 */
	private String content;
	/** 险种类型,意外险或者其他等等 */
	private String genre;
	/** 该险种是否还有效,即是否已经是老产品 */
	private String validOrNot = "有效";
	
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
