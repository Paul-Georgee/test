package com.project.publicinfo.rules.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.RulesBean;
import com.project.publicinfo.rules.service.IRulesService;

@Controller
@RequestMapping("/publicRules")
public class RulesController {

	@Resource
	private IRulesService service;
//	显示所有规章制度
	@RequestMapping("/showAll")
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		
		List<RulesBean> list=service.rules();
		ObjectMapper om0=new ObjectMapper();
		om0.writeValue(response.getWriter(), list);
	}
	
	@RequestMapping("/find1")
	public void find1(HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		
		List<RulesBean> list=service.findTop3();
		ObjectMapper om0=new ObjectMapper();
		om0.writeValue(response.getWriter(), list);
		
		
	}
	
}
