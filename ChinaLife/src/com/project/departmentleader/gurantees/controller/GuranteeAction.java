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
 * ���ű���ά�����ֲ�
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/guratee")
public class GuranteeAction {
	
	@Resource
	private IGuranteeService service;
	
	/**
	 * ��̬��ҳ��ѯ�����ű�������
	 * @param pageNo ҳ��
	 * @param start ��ʼʱ��
	 * @param end ����ʱ��
	 * @param favoree ������
	 * @param signer ǩ����
	 * @param number �������
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,Date start,Date end,String favoree,String signer,
			String number,HttpServletRequest request,HttpServletResponse response)
					throws JsonGenerationException, JsonMappingException, IOException{
		//��ȡ����Ա���� ��ȡ����ID
		UserBean ubean=(UserBean)request.getSession().getAttribute("employee");
		//��̬��ҳ��ѯ�������еı���
		CutPageBean<GuranteeBean> cutBean=service.gurantees(pageNo,ubean.getDepartId(), 
				start, end, favoree, signer, number);
//		System.out.println(cutBean);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
		
	}
	/**
	 * ��ѯ������ϸ��Ϣ
	 * @param id ����ID
	 * @param request 
	 * @return ����ת������Ϣ��ʾҳ��
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
	 *�������� �Ȳ�ѯ�������� Ȼ����д��������
	 * @param id ����ID
	 * @param applyReason ����ԭ��
	 * @return �ض��򵽱���ά��ҳ��
	 */
	@RequestMapping("/applyClaim")
	 public String applyClaim(int id,String applyReason){
		 service.applyClaim(id, applyReason);
		 return "redirect:/jsp/section/preserve.jsp";
		 
	 }
	
	/**
	 * ��ֹ���� �޸ı�����״̬Ϊ ��ֹʧЧ
	 * @param id ����ID
	 * @return �ض��򵽱���ά��ҳ��
	 * @throws IOException 
	 */
	@RequestMapping("/terminate")
	public String  terminate(int id) {
		service.terminate(id);
		return "redirect:/jsp/section/preserve.jsp";
	}
 
}
