package com.project.publicinfo.insurance.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.InsuranceBean;
import com.project.publicinfo.insurance.service.IInsuranceService;

@Controller
@RequestMapping("/public")
public class InsuranceController {

	@Resource
	private IInsuranceService service;
	
	@RequestMapping("insurances")
	public void getInsurances(HttpServletResponse response,int pageNo,
			String insuName) throws JsonGenerationException,
	JsonMappingException, IOException{
		
		CutPageBean<InsuranceBean> insurances = service.insurances(pageNo, insuName);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), insurances);
		
	}
	
	@RequestMapping("/insurances/{insuId}")
	public String InsuranceInfo(@PathVariable("insuId")int id,HttpServletRequest request){
		InsuranceBean insurance = service.findByid(id);
		request.setAttribute("insurance", insurance);
		return "/jsp/admin/updateInsuranse.jsp";
	}
	
	
}
