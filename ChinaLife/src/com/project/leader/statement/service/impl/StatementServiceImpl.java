package com.project.leader.statement.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CompanyStatementBean;
import com.project.commonservice.BaseService;
import com.project.leader.statement.service.IStatementService;

@Service("leadDataService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class StatementServiceImpl extends BaseService implements IStatementService {

	@Override
	public List<CompanyStatementBean> statements(Date start, Date end) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<CompanyStatementBean> list = this.session.selectList("data.Numbers",map);
		return list;
	}

//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
//		IStatementService service = (IStatementService) context.getBean("leadDataService"); 
//		
//		List<CompanyStatementBean> list = service.statements(Date.valueOf("1111-11-11"),
//				Date.valueOf("2222-11-11"));
//		System.out.println(list);
//
//		
//	}
}
