package com.project.publicinfo.email.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.bean.CutPageBean;
import com.project.bean.EmailBean;
import com.project.bean.UserBean;
import com.project.publicinfo.email.service.IEmailSendService;
import com.project.util.FileDownUtil;
import com.project.util.StrToArrayUtil;
import com.project.util.UploadUtil;

@Controller
@RequestMapping("/sendEmail")
public class SendEmailAction {
	@Resource
	private IEmailSendService service;
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,String title,HttpServletResponse response,
			HttpServletRequest request) throws Exception{
		UserBean user = (UserBean)request.getSession().getAttribute("employee");
		CutPageBean cutBean = service.emails(pageNo, user.getId(), title);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	@RequestMapping("/del")
	public String del(int id){
		service.ToTrash(id);
		return "/jsp/email/outbox.jsp";
	}
	@RequestMapping("/findById")
	public String findById(int id, HttpServletRequest request){
		EmailBean bean = service.email(id);
		request.setAttribute("sendEmail", bean);
		return "/jsp/email/showOutbox.jsp";
	}
	@RequestMapping("/findByItemForUsers")
	public void findByItemForUsers(int pageNo,String userName,HttpServletResponse response) throws Exception{
		CutPageBean cutBean = service.sendEmailFindUser(pageNo, userName);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	
	
	@RequestMapping("/sendAddEmail")
	public String sendAddEmail(EmailBean email,String array,String nameArray,
			HttpServletRequest request,
			@RequestParam(name="eamilAttachment") CommonsMultipartFile mfile){
		
		UserBean user = (UserBean)request.getSession().getAttribute("employee");
		
		int[] receiverId = StrToArrayUtil.toArray(array);
		
		String fileName = UploadUtil.upload(mfile, request, "/WEB-INF/upload");
		
		email.setAttachment(fileName);
		email.setSenderId(user.getId());
		service.send(email, receiverId, nameArray);
		return "redirect:/jsp/email/outbox.jsp";
	}
	
	
	@RequestMapping("/wtiteAttach")
	public void wtiteAttach(String fileName,HttpServletResponse response){
		try {
			String path="C:/apache-tomcat-7.0.68/wtpwebapps/ChinaLife/WEB-INF/upload/"+fileName;
			FileDownUtil.downLoad(path, response, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
