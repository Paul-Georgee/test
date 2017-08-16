package com.project.publicinfo.rules.service;

import java.util.List;

import com.project.bean.RulesBean;

/**
 * �����ƶȼ���
 * @author SherLock
 *
 */
public interface IRulesService {

	/**
	 *  ��˾���еĵĹ����ƶȼ���
	 * @return �����ƶȼ���
	 */
	public List<RulesBean> rules();
	
	
	/**
	 *  ��������ҳ��ʾ3����˾�����ƶ�
	 * @return list����
	 */
	public List<RulesBean> findTop3();
	

}
