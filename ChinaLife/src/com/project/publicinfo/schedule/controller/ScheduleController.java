package com.project.publicinfo.schedule.controller;

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
import com.project.bean.ScheduleBean;
import com.project.publicinfo.schedule.service.IScheduleService;

@Controller
@RequestMapping("/public")
public class ScheduleController {

	@Resource
	private IScheduleService service;
	
	@RequestMapping("/schedules")
	public void getSchedules(HttpServletResponse response,int pageNo,
			int userId,String content, Date beginTime) throws JsonGenerationException,
	JsonMappingException, IOException{
		
		CutPageBean<ScheduleBean> schedules = 
				service.allSchedule(pageNo, userId, content, beginTime);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), schedules);
		
	} 
	
	@RequestMapping("/schedules/add")
	public String addSchedule(ScheduleBean schedule, int userId){
		service.addSchedule(schedule, userId);
		return "redirect:/jsp/schedule.jsp";
	}
	
}
