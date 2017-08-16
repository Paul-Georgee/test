package com.project.publicinfo.login.controller;

import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.UserBean;
import com.project.publicinfo.login.service.ILoginService;
import com.project.util.makeCertPic;

@Controller
@RequestMapping("/public")
public class LoginAction {
	
	@Resource
	private ILoginService service;
//	登录
	@RequestMapping("/login")
	public String login(String username,String password,
			HttpServletRequest request,HttpServletResponse response,String userCheck){
		
		String str=request.getSession().getAttribute("chcode").toString();
		if (str.equalsIgnoreCase(userCheck)==false) {
			request.setAttribute("checkCode", "验证码错误");
			return "/jsp/login.jsp";
		} 
		UserBean bean=service.login(username, password);
		if(bean==null){
			request.setAttribute("loginError", "用户名或密码错误");
			return "/jsp/login.jsp";
		}else {
			request.getSession().setAttribute("employee", bean);
			return "redirect:/jsp/index.jsp";
		}
	}
	
//	验证码
	@RequestMapping("/check")
	public void checkCode(HttpServletRequest request,
			HttpServletResponse response,OutputStream os){
		
		makeCertPic makeCertPic=new makeCertPic();
		String string = makeCertPic.getCertPic(60, 30, os);
		request.getSession().setAttribute("chcode", string);
	}
	
	
	@RequestMapping("/error")
	public String error(){
		return "redirect:/jsp/public/404.html";
	}
}
