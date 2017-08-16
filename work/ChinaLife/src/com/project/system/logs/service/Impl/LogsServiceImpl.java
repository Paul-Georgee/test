package com.project.system.logs.service.Impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.LoginLogsBean;
import com.project.commonservice.BaseService;
import com.project.system.logs.service.ILogsService;
@Service("login")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class LogsServiceImpl extends BaseService implements ILogsService {

	@Override
	public CutPageBean<LoginLogsBean> loginLogs(int pageNo, Date start, Date end) {
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		
		CutPageBean<LoginLogsBean> cutPageBean= this.getCutPage(pageNo,
				"systemLoginLog.listSql", "systemLoginLog.countSql", map);
		
		return cutPageBean;
		
	}

}
