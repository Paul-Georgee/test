package com.project.admin.department.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.admin.department.service.IDepartmentService;
import com.project.bean.DepartmentBean;

@Controller
@RequestMapping("/public")
public class AdepartmentController {

	@Resource
	private IDepartmentService service;
	
	@RequestMapping("/departments")
	public void getDeparts(HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		List<DepartmentBean> departments = service.departments();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), departments);
	}
}
