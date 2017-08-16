package com.project.departmentleader.employees.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;
import com.project.departmentleader.employees.service.IEmployeeService;



/**
 * ���Ź���Ա�鿴�����ŵ�Ա��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/employee")
public class EmpolyeesAction {
		
	@Resource
	private IEmployeeService service;
	
	//��̬������ѯ��ҳ����
	@RequestMapping("/findByItem")
	public void  findByItem(int pageNo,String trueName,String duty,HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		//��ȡ��ǰ��¼����,�Ա��ȥ�����Ӧ�Ĳ���ID
		UserBean ubean=(UserBean)request.getSession().getAttribute("employee");
		//������Ա����ҳ����
		
		CutPageBean<UserBean> cutBean=service.employees(pageNo,ubean.getDepartId(), trueName, duty);
		System.out.println(cutBean);
		//ʹ��jkson�����ݷ�װ��ҳ��
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	
	/**
	 * �鿴����Ա����
	 * @param id Ա��id
	 * @param request 
	 * @return ����ת����������ʾҳ��
	 */
	@RequestMapping("/findById")
	public String findById(int id,HttpServletRequest request){
		
		UserBean ubean=service.employeeInfo(id);
		
		request.getSession().setAttribute("ubInfo", ubean);
		
		return "/jsp/section/staffMsg.jsp";
	}
	
}
