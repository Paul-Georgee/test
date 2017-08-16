package com.project.departmentleader.statement.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.DepartStatementBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;
import com.project.departmentleader.statement.service.IStatementService;

/**
 * 部门报表表现层实体类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/statement")
public class StatementAction {

	@Resource
	private IStatementService service;
	
	//根据部门ID 动态分页查询
	@RequestMapping("/findByItem")
	public void findByItem(Date start,Date end,HttpServletResponse response,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		UserBean ubean=(UserBean)request.getSession().getAttribute("employee");
		List<DepartStatementBean> list= service.statements(ubean.getDepartId(), start, end);

		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getWriter(), list);
	}
}
