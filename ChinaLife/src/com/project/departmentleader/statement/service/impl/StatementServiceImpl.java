package com.project.departmentleader.statement.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.DepartStatementBean;
import com.project.commonservice.BaseService;
import com.project.departmentleader.statement.service.IStatementService;

/**
 * 部门负责人 查看部门业绩图表接口实现类
 * @author Administrator
 *
 */
@Service("uusb")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class StatementServiceImpl extends BaseService implements IStatementService {

	@Override
	public List<DepartStatementBean> statements(int id, Date start, Date end) {
		Map map=new HashMap<>();
		map.put("id", id);
		map.put("start", start);
		map.put("end", end);
		List<DepartStatementBean> list=session.selectList("Statement.findByItem", map);
		return list;
	}

//	public static void main(String[] args) {
//		ApplicationContext aContext=new ClassPathXmlApplicationContext("app-service.xml");
//		IStatementService service=(IStatementService)aContext.getBean("uusb");
//		System.out.println(service.statements(4, Date.valueOf("2017-07-22"), null));
//	}
}
