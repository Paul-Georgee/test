package com.project.bean;

import java.util.List;
/**
 *  ��ҳʵ����
 * @author SherLock
 *
 * 
 */
public class CutPageBean<E> {
	/**�ܼ�¼��*/
	private Integer count;
	/**��ҳ��*/
	private Integer pages;
	/**���󼯺�*/
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
