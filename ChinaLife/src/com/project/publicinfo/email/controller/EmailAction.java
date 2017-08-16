package com.project.publicinfo.email.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.ReceiveBean;
import com.project.bean.UserBean;
import com.project.publicinfo.email.service.IEmailReceiveService;
import com.project.util.FileDownUtil;

@Controller
@RequestMapping("/email")
public class EmailAction {
	@Resource
	private IEmailReceiveService service;
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,String title,String sender,
			HttpServletResponse response,HttpServletRequest request) throws Exception{
		UserBean user =  (UserBean)request.getSession().getAttribute("employee");
		CutPageBean cutBean = service.receives(pageNo, user.getId(), title, sender);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), cutBean);
	}
	@RequestMapping("/del")
	public String del(int id){
		service.toTrash(id);
		System.out.println("hello");
		return "/jsp/email/inbox.jsp";
	}
	@RequestMapping("/findById")
	public String findById(int id,HttpServletRequest request){
		ReceiveBean bean = service.email(id);
		request.setAttribute("email", bean);
		return "/jsp/email/showEmail.jsp";
	}
	@RequestMapping("/uploadAttach")
	public void uploadAttach(String fileName,HttpServletResponse response){
		try {
			String path="C:/apache-tomcat-7.0.52/webapps/ChinaLife/WEB-INF/upload/"+fileName;
			FileDownUtil.downLoad(path, response, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
