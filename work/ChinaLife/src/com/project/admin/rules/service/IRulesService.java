package com.project.admin.rules.service;

import java.util.List;

import com.project.bean.RulesBean;

/**
 * 管理员管理规章制度管理
 * @author SherLock
 *
 */
public interface IRulesService {

	/**
	 * 查询公司所有的规章制度
	 * @return
	 */
	public List<RulesBean> rules();
	/**
	 *  修改公司的规章制度的内容
	 * @param id 规章制度的id
	 * @param content 规章制度的内容
	 */
	public void update(int id,String content);
	
	/**
	 * 根据id查看规章制度
	 * @param id
	 * @return 规章制度对象
	 */
	public RulesBean findById(int id);
	
	/**
	 * 添加新的规章制度
	 * @param rule
	 */
	public void add(RulesBean rule);
}
