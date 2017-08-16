package com.project.leader.employees.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;
import com.project.leader.employees.service.IEmployeeService;

@Controller
@RequestMapping("/employees")
public class UserAction {
	@Resource
	private IEmployeeService service;
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,Integer departId,String trueName,String duty,
			HttpServletResponse response) throws JsonGenerationException, 
	JsonMappingException, IOException{
		
		CutPageBean cutBean = service.employees(pageNo, trueName, departId, duty);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);	
	}
	
	@RequestMapping("/findById")
	public void findById(int id,HttpServletResponse response) throws
	JsonGenerationException, JsonMappingException, IOException{
		
		UserBean bean = service.findById(id);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(),bean);
	}
	
	
}
