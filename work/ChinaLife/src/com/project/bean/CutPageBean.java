package com.project.bean;

import java.util.List;
/**
 *  分页实体类
 * @author SherLock
 *
 * 
 */
public class CutPageBean<E> {
	/**总记录数*/
	private Integer count;
	/**总页数*/
	private Integer pages;
	/**对象集合*/
	private List<E> objects;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public List<E> getObjects() {
		return objects;
	}

	public void setObjects(List<E> objects) {
		this.objects = objects;
	}

	@Override
	public String toString() {
		return "CutPageBean [count=" + count + ", pages=" + pages + ", objects=" + objects + "]";
	}
	
	
}
