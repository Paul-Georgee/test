package com.project.system.employee.service;

import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * ϵͳ����Ա���û�����ӿ�
 * @author SherLock
 *
 */
public interface IEmpService {

	/**
	 *  ������ʵ����,��ְλ���в�ѯ��ְԱ�����ҷ�ҳ
	 * @param pageNo ҳ��
	 * @param trueName ��ʵ����
	 * @param duty ְλ
	 * @return ��ҳ����
	 */
	public CutPageBean<UserBean> emps(int pageNo,String trueName,
			String duty);
	/**
	 * ���ǰ�Ȳ�ѯ�����в���������id
	 * @return
	 */
	public List<DepartmentBean> findItem();
	
	/**
	 *  ����û�
	 * @param user Ա������
	 */
	public void empsAdd(UserBean user);
	
	/**
	 *  �޸��û�������
	 * @param userId �û���id
	 * @param duty �û���Ҫ�޸ĵ�ְλ
	 * @param tel �û��ĵ绰
	 * @param departId ���ŵ�id
	 * @param role �û���ϵͳ�еĽ�ɫ
	 */
	public void update(int userId,String duty,String tel,int departId,String role);
	
	/**
	 *  ɾ��Ա��֮ǰ�Ƿ�����Ч����,���û��,���޸�״̬Ϊ��ְ,
	 *  �����,�ͷ��ؼ�,���Ҳ�����ɾ��,
	 * @param userId
	 */
	public boolean del(int userId);
	/**
	 *�鿴�û�����
	 * @param id �û�ID
	 * @return
	 */
	public UserBean findById(int id);
	

}
