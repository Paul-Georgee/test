package com.project.admin.train.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.admin.train.service.IEmployeeService;
import com.project.admin.train.service.ITrainService;
import com.project.bean.CutPageBean;
import com.project.bean.TrainBean;
import com.project.bean.UserBean;
import com.project.util.StrToArrayUtil;

/**
 * 
 * @author SherLock
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminTrainController {

	@Resource
	private ITrainService service;
	
	@Resource
	private IEmployeeService empService;
	
	@RequestMapping("/endTrain")
	public String endTrain(int id){
		service.endTrain(id);
		return "redirect:/jsp/admin/train.jsp";
	}
	
	@RequestMapping("/getTrains")
	public void getTrains(int pageNo,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		CutPageBean<TrainBean> trains = service.trains(pageNo);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), trains);
	}
	
	@RequestMapping("/setPoint")
	public void setPoint(int trainId,int point,HttpServletResponse response) throws IOException{
		service.insertPoint(trainId, point);
		response.getWriter().print(1);
	}
	
	@RequestMapping("/addTrain")
	public String addTrain(TrainBean train, String arrayUsersId){
		System.out.println(arrayUsersId);
		service.add(train, StrToArrayUtil.toArray(arrayUsersId));
		return "redirect:/jsp/admin/train.jsp";
	}
	
	@RequestMapping("/train/{trainId}")
	public String getTrainInfo(@PathVariable("trainId")int id,HttpServletRequest request){
		TrainBean train = service.findById(id);
		request.setAttribute("train", train);
		return "/jsp/admin/trainInfo.jsp";
	}
	
	@RequestMapping("/getEmps")
	public void getEmps(int pageNo,String trueName,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		CutPageBean<UserBean> emps = empService.trainers(pageNo, trueName);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getWriter(), emps);
	}
	
}
