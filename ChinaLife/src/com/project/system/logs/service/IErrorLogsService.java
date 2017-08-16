package com.project.system.logs.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.ErrorLogsBean;

/**
 * 错误日志接口
 * @author SherLock
 *
 */
public interface IErrorLogsService {

	/**
	 * 错误日志按照时间段分页查询
	 * @param pageNo 页码
	 * @param start 其实日期
	 * @param end 结束日期
	 * @return 分页对象
	 */
	public CutPageBean<ErrorLogsBean> errorLogs(int pageNo,
			Date start,Date end);
}
