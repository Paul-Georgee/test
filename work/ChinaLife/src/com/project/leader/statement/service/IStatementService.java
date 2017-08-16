package com.project.leader.statement.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.CompanyStatementBean;

/**
 *  领导查看公司报表柱状图
 * @author SherLock
 *
 */
public interface IStatementService {
 
	/**
	 *  查看公司报表集合
	 * @param start 起始日期
	 * @param end 结束日期
	 * @return 公司报表集合
	 */
	public List<CompanyStatementBean> statements(Date start,Date end);
}
