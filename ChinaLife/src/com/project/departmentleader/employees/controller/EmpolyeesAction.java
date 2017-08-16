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
 * 部门管理员查看本部门的员工
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/employee")
public class EmpolyeesAction {
		
	@Resource
	private IEmployeeService service;
	
	//动态条件查询分页对象
	@RequestMapping("/findByItem")
	public void  findByItem(int pageNo,String trueName,String duty,HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		//获取当前登录对象,以便回去对象对应的部门ID
		UserBean ubean=(UserBean)request.getSession().getAttribute("employee");
		//本部门员工分页对象
		
		CutPageBean<UserBean> cutBean=service.employees(pageNo,ubean.getDepartId(), trueName, duty);
		System.out.println(cutBean);
		//使用jkson将数据封装到页面
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	
	/**
	 * 查看部门员详情
	 * @param id 员工id
	 * @param request 
	 * @return 请求转发到详情显示页面
	 */
	@RequestMapping("/findById")
	public String findById(int id,HttpServletRequest request){
		
		UserBean ubean=service.employeeInfo(id);
		
		request.getSession().setAttribute("ubInfo", ubean);
		
		return "/jsp/section/staffMsg.jsp";
	}
	
}
