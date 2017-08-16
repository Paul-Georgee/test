package com.project.admin.department.controller;

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

import com.project.admin.department.service.IDepartmentService;
import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;

@Controller
@RequestMapping("/department")
public class DepartmentAction {
	@Resource
	private IDepartmentService service;
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse response) throws Exception{
		List<DepartmentBean> list = service.departments();
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), list);
	}
	@RequestMapping("/add")
	public String add(DepartmentBean dbean){
		service.add(dbean);
		return "/jsp/admin/department.jsp";
	}
	@RequestMapping("/del")
	public void del(int departmentId,HttpServletResponse response) throws Exception{
		int departIsNull = service.del(departmentId);
//		request.setAttribute("yesOrNo", departIsNull);
		if(departIsNull == 1){
			response.getWriter().print(1);
		}else{
			response.getWriter().print(0);
		}
	}
	@RequestMapping("/findById")
	public String findById(int id,HttpServletRequest request){
		DepartmentBean bean = service.findById(id);
		request.setAttribute("department", bean);
		return "/jsp/admin/updateDepartment.jsp";
	}
	@RequestMapping("/findByItemForUser")
	public void findByItemForUser(int pageNo,String userName,HttpServletResponse response) throws Exception{
		CutPageBean<UserBean> cutBean = service.findByItemForUser(pageNo, userName);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	@RequestMapping("/update")
	public String update(int departHeaderId,int departId,int userId){
		service.update(departId, departHeaderId, userId);
		return "/jsp/admin/department.jsp";
	}
}
