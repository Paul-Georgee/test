package com.project.publicinfo.notice.controller;

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

import com.project.bean.NoticeBean;
import com.project.publicinfo.notice.service.INoticeService;

@Controller
@RequestMapping("/publicNotice")
public class NoticeAction {
	
	@Resource
	private INoticeService service;
	
//	显示所有公告
	@RequestMapping("/showAll")
	public void showAll(HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		
		List<NoticeBean> list=service.notices();
		ObjectMapper om0=new ObjectMapper();
		om0.writeValue(response.getWriter(), list);
	}
	
//	按ID查询公告详情
	@RequestMapping("/showById")
	public String findById(int id,HttpServletRequest request){
		NoticeBean bean= service.notice(id);
		request.setAttribute("NoticeBean",bean);
		return "/jsp/public/noticeInfo.jsp";
	}
	
}
