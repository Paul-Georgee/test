package com.project.departmentleader.statement.service;

import java.sql.Date;
import java.util.List;

import com.project.bean.DepartStatementBean;

/**
 * 部门负责人查看本部门的订单报表
 * @author SherLock
 *
 */
public interface IStatementService {

	/**
	 * 可以根据时间段来查询部门业务报表
	 * @param id 部门的id
	 * @param start 起始日期
	 * @param end 结束日期
	 * @return 报表对象集合
	 */
	public List<DepartStatementBean> statements(int id,Date start,Date end);
}
