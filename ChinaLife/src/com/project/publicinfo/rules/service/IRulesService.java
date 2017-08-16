package com.project.publicinfo.rules.service;

import java.util.List;

import com.project.bean.RulesBean;

/**
 * 规章制度集合
 * @author SherLock
 *
 */
public interface IRulesService {

	/**
	 *  公司所有的的规章制度集合
	 * @return 规章制度集合
	 */
	public List<RulesBean> rules();
	
	
	/**
	 *  用于在首页显示3条公司规章制度
	 * @return list集合
	 */
	public List<RulesBean> findTop3();
	

}
