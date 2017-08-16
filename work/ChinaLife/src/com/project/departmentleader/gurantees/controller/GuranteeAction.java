package com.project.departmentleader.gurantees.controller;

import java.io.IOException;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.bean.UserBean;
import com.project.departmentleader.gurantees.service.IGuranteeService;
import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;



/**
 * 部门保单维护表现层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/guratee")
public class GuranteeAction {
	
	@Resource
	private IGuranteeService service;
	
	/**
	 * 动态分页查询本部门保单对象
	 * @param pageNo 页码
	 * @param start 起始时间
	 * @param end 结束时间
	 * @param favoree 受益人
	 * @param signer 签单人
	 * @param number 保单编号
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,Date start,Date end,String favoree,String signer,
			String number,HttpServletRequest request,HttpServletResponse response)
					throws JsonGenerationException, JsonMappingException, IOException{
		//获取管理员对象 获取部门ID
		UserBean ubean=(UserBean)request.getSession().getAttribute("employee");
		//动态分页查询本部门中的保单
		CutPageBean<GuranteeBean> cutBean=service.gurantees(pageNo,ubean.getDepartId(), 
				start, end, favoree, signer, number);
//		System.out.println(cutBean);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
		
	}
	/**
	 * 查询保单详细信息
	 * @param id 保单ID
	 * @param request 
	 * @return 请求转化到信息显示页面
	 */
	@RequestMapping("/findGuranteeInfo")
	public String findGuranteeInfo(int id,HttpServletRequest request){
		GuranteeBean gbean=service.guranteeInfo(id);
//		System.out.println(gbean);
		request.getSession().setAttribute("gbInfo", gbean);
		return "/jsp/section/chitMsg.jsp";
	}
	
	@RequestMapping("/findGurantInfoUpdate")
	public String findGurantInfoUpdate(int id,HttpServletRequest request){
		GuranteeBean gbean=service.guranteeInfo(id);
//		System.out.println(gbean);
		request.getSession().setAttribute("upGbInfo", gbean);
		return "/jsp/section/apply.jsp";
	}
	
	/**
	 *保单理赔 先查询保单详情 然后填写理赔理由
	 * @param id 保单ID
	 * @param applyReason 理赔原因
	 * @return 重定向到保单维护页面
	 */
	@RequestMapping("/applyClaim")
	 public String applyClaim(int id,String applyReason){
		 service.applyClaim(id, applyReason);
		 return "redirect:/jsp/section/preserve.jsp";
		 
	 }
	
	/**
	 * 终止保单 修改保单啊状态为 终止失效
	 * @param id 保单ID
	 * @return 重定向到保单维护页面
	 * @throws IOException 
	 */
	@RequestMapping("/terminate")
	public String  terminate(int id) {
		service.terminate(id);
		return "redirect:/jsp/section/preserve.jsp";
	}
 
}
