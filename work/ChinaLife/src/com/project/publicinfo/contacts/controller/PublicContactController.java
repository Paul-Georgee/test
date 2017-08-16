package com.project.publicinfo.contacts.controller;

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
import com.project.publicinfo.contacts.service.IContactsService;

/**
 * ÁªÏµÈËcontroller
 * @author SherLock
 *
 */
@Controller
@RequestMapping("/public")
public class PublicContactController {

	@Resource
	private IContactsService service;
	
	@RequestMapping("/contacts")
	public void getContacts(int pageNo,String trueName,String duty,
			String departmentId,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		Integer departId = 0;
		if ("0".equals(departmentId)) {
			departId = null;
		}else if(departmentId==null){
			departId=null;
		}else{
			departId = Integer.parseInt(departmentId);
		}
		CutPageBean<UserBean> contacts = service.contacts(pageNo, trueName, duty,
				departId);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), contacts);
	}
	
}
