package com.project.system.logs.service;

import java.sql.Date;

import com.project.bean.CutPageBean;
import com.project.bean.LoginLogsBean;

/**
 * 日志接口
 * @author SherLock
 *
 */
public interface ILogsService {

	
	/**
	 * 
	 * @param pageNo 页码
	 * @param start 其实日期
	 * @param end 结束日期
	 * @return 对象
	 */
	public CutPageBean<LoginLogsBean> loginLogs(int pageNo,
			Date start,Date end);
	

}
