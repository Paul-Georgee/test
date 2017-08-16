package com.project.leader.gurantees.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.leader.gurantees.service.IGuranteeService;

@Controller
@RequestMapping("/gurantee")
public class GuranteeController {
	@Resource
	private IGuranteeService service;
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,Integer departmentId,String clientName,
			String insureName,
			String signer, String state, Date start,Date end,
			HttpServletResponse response) throws JsonGenerationException,
	JsonMappingException, IOException{
		
		CutPageBean cutBean = service.gurantees(pageNo, departmentId, 
				clientName, insureName, signer, state, start, end);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	
	@RequestMapping("/findById")
	public void findById(int id ,HttpServletResponse response) throws 
	JsonGenerationException, JsonMappingException, IOException{
		
		GuranteeBean bean = service.findById(id);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), bean);
	}
	
	@RequestMapping("/findCheckBill")
	public void findCheckBill(HttpServletResponse response) throws 
	JsonGenerationException, JsonMappingException, IOException{
		
		List<GuranteeBean> list = service.gurantees();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(),list);
	}
	@RequestMapping("/update")
	public String checkBill(int id,String Radios,String auditReason){
		System.out.println(id);
		System.out.println(Radios);
		
		if(Radios.equals("yes")){
			service.update(id, auditReason);
			return "redirect:/jsp/leader/checkBill.jsp";
		}else{
			service.update(id);
			return "redirect:/jsp/leader/checkBill.jsp";	
		}
		
	}
}
