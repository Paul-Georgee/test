package com.project.leader.gurantees.service;

import java.util.List;

import com.project.bean.DepartmentBean;
import com.project.bean.InsuranceBean;

/**
 * �쵼���ݲ�������Ա���ӿ�
 * @author SherLock
 *
 */
public interface IDepartmentService {

	/**
	 *  �鿴��˾���еĲ���
	 * @return ���ż���
	 */
	public List<DepartmentBean> departments();
	/**
	 * ͳ�����в�����Ŀ
	 * @return ��������
	 */
	public int countDepart();
	/**
	 * �鿴��������
	 * @return ���ּ���
	 */
	public List<InsuranceBean> insurances();
	/**
	 * ͳ��������Ŀ
	 * @return ��������
	 */
	public int countInsurance();
	
}
