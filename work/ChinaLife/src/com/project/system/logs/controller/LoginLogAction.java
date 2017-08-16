package com.project.system.logs.controller;

import java.io.IOException;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.LoginLogsBean;
import com.project.system.logs.service.ILogsService;

@Controller
@RequestMapping("/loginlogs")
public class LoginLogAction {
	
	@Resource
	private ILogsService service;
	
//	登录日志分页查询
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse response,int pageNo,Date start,Date end) throws JsonGenerationException, JsonMappingException, IOException{
		
		CutPageBean<LoginLogsBean> bean=service.loginLogs(pageNo, start, end);
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(response.getWriter(), bean);
		
	}
}
