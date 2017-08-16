package com.project.employee.orders.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.bean.UserBean;
import com.project.employee.orders.service.IOrdersService;
import com.project.util.JacksonUtil;

/**
 * 个人签单Action
 * 
 * @author Edison
 *
 */
@Controller
@RequestMapping("/orders")
public class ordersAction {
	@Resource
	private IOrdersService service;

	/**
	 * 显示登陆员工的所有保单
	 * 
	 * @param pageNo
	 *            页码
	 * @param response
	 *            请求
	 */
	@RequestMapping("/findAll")
	public void findAll(int pageNo, HttpServletResponse response,HttpServletRequest request) {
		UserBean ubean=(UserBean)request.getSession().getAttribute("employee");
		CutPageBean<GuranteeBean> bean = service.gurantees(pageNo, ubean.getId());
		JacksonUtil.outJson(response, bean, "guranteeJson", "insurance,client,insureTime");
	}

	/**
	 * 根据ID查看保单,并转到展示页面
	 * 
	 * @param id
	 *            保单ID
	 * @param request
	 *            请求
	 * @return 转到展示页面
	 */
	@RequestMapping("/findById")
	public String findById(int id, HttpServletRequest request) {
		GuranteeBean guranteeBean = service.guranteeInfo(id);
		request.setAttribute("GB", guranteeBean);
		return "/jsp/employee/personage/showPersonage.jsp";
	}
}
