package com.project.admin.rules.service;

import java.util.List;

import com.project.bean.RulesBean;

/**
 * ����Ա��������ƶȹ���
 * @author SherLock
 *
 */
public interface IRulesService {

	/**
	 * ��ѯ��˾���еĹ����ƶ�
	 * @return
	 */
	public List<RulesBean> rules();
	/**
	 *  �޸Ĺ�˾�Ĺ����ƶȵ�����
	 * @param id �����ƶȵ�id
	 * @param content �����ƶȵ�����
	 */
	public void update(int id,String content);
	
	/**
	 * ����id�鿴�����ƶ�
	 * @param id
	 * @return �����ƶȶ���
	 */
	public RulesBean findById(int id);
	
	/**
	 * ����µĹ����ƶ�
	 * @param rule
	 */
	public void add(RulesBean rule);
}
