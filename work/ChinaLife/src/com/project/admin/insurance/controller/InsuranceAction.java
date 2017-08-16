package com.project.admin.insurance.controller;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.admin.insurance.service.IIsuranceService;
import com.project.bean.CutPageBean;
import com.project.bean.InsuranceBean;

@Controller
@RequestMapping("/insurance")
public class InsuranceAction {
	@Resource
	private IIsuranceService service;
	
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,String insuName, String state,HttpServletResponse response) throws Exception{
		CutPageBean cutBean = service.insurances(pageNo, insuName, state);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	@RequestMapping("/findById")
	public String findById(int id,HttpServletRequest request){
		InsuranceBean bean = service.findById(id);
		request.setAttribute("insurance", bean);
		return "/jsp/admin/updateInsuranse.jsp";
	}
	@RequestMapping("/update")
	public String update(int id){
		service.inValid(id);
		return "/jsp/admin/Insurance.jsp";
	}
	@RequestMapping("/add")
	public String add(InsuranceBean insurance){
		service.add(insurance);
		return "/jsp/admin/Insurance.jsp";
	}
	
	@RequestMapping("/publicIn")
	public void publicInsurance(int pageNo,String insuName,HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException{
		CutPageBean cutBean = service.insurances(pageNo, insuName);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	
	
}
