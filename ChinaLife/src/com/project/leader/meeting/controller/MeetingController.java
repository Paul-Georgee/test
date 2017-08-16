package com.project.leader.meeting.controller;

import java.io.IOException;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;
import com.project.leader.meeting.service.IMeetingService;

@Controller
@RequestMapping("/leadMeeting")
public class MeetingController {
	@Resource
	private IMeetingService service;
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo,String title,Date start,Date end,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		
		CutPageBean cutBean = service.findByitem(pageNo, title, start, end);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(),cutBean);
	}
	
	@RequestMapping("/findById")
	public void findById(int id,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		
		MeetingBean bean = service.findById(id);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(),bean);
	}
	
	
}
