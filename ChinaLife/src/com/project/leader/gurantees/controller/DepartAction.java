package com.project.leader.gurantees.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.DepartmentBean;
import com.project.leader.gurantees.service.IDepartmentService;

@Controller
@RequestMapping("/departList")
public class DepartAction {
	@Resource
	private IDepartmentService service;
	@RequestMapping("/getDepart")
	public void getDepart(HttpServletResponse response) throws JsonGenerationException, 
	JsonMappingException, IOException{
		List<DepartmentBean> list = service.departments();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), list);
	}
}
