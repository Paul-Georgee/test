package com.project.system.logs.service.Impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bean.CutPageBean;
import com.project.bean.ErrorLogsBean;
import com.project.commonservice.BaseService;
import com.project.system.logs.service.IErrorLogsService;


@Service("error")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class ErrorLogsServiceImpl extends BaseService implements IErrorLogsService {

	@Override
	public CutPageBean<ErrorLogsBean> errorLogs(int pageNo, Date start, Date end) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		
		CutPageBean<ErrorLogsBean> cutPageBean=this.getCutPage(pageNo, 
				"systemError.listSql", "systemError.countSql", map);
		return cutPageBean;
	}
}
