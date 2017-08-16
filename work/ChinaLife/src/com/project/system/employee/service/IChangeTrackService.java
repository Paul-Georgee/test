package com.project.system.employee.service;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.bean.UserBean;

public interface IChangeTrackService {
	/**
	 *  �鿴�û�����Ч����
	 * @param userId �û�id 
	 * @param pageNo ��ҳҳ��
	 * @return �û�������ҳ����
	 */
	public CutPageBean<GuranteeBean> gurantees(int userId,int pageNo);
	
	/**
	 * Ա����ְ��,Ա���Ŀͻ���������Ա��
	 * @param userId ��ָ�ɵĸ�����Ա����id
	 * @param gurantees ��Ҫ�����ı���id
	 */
	public void changeTrack(int userId,int[] gurantees);
	/**
	 * ��ѯ�û�ͬһ���ŵ���ְ��ҵ��Ա
	 * @param id ��ǰ�û�id
	 * @param pageNo ҳ��
	 * @param trueName ����
	 * @return ͬһ���ŵ�����ҵ��Ա
	 */
	public CutPageBean<UserBean> findUserInDepartment(int id,int pageNo,String trueName);
}
