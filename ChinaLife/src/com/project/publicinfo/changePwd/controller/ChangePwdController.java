package com.project.publicinfo.changePwd.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.publicinfo.changePwd.service.IChangePwdService;
/**
 *  ÐÞ¸ÄÃÜÂëÄ£¿é
 * @author SherLock
 *
 */
@Controller
@RequestMapping("/employee")
public class ChangePwdController {

	@Resource
	private IChangePwdService service;
	
	@RequestMapping("/changePwd")
	public String changePwd(Integer userId,String password,String confirmPwd,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
			if (password.equals(confirmPwd)) {
				service.updatePwd(userId, password);
				return "redirect:/jsp/index.jsp";
			}else{
				return "/jsp/changePwd.jsp";
			}

		}
}
