package com.project.admin.meeting.controller;

import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.admin.meeting.service.IMeetingService;
import com.project.admin.train.service.IEmployeeService;
import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;
import com.project.util.JacksonUtil;

/**
 * 会议Action
 * 
 * @author Edison
 *
 */
@Controller
@RequestMapping("/meeting")
public class meetingAction {
	@Resource
	private IMeetingService service;
	@Resource
	private IEmployeeService Eservice;
	/**
	 * 会议管理界面,数据显示以及模糊查询
	 * 
	 * @param pageNo
	 *            页码
	 * @param title
	 *            会议主题
	 * @param start
	 *            起始时间
	 * @param end
	 *            结束时间
	 * @param response
	 *            发给ajax
	 */
	@RequestMapping("/findByItem")
	public void findByItem(int pageNo, String title, Date start, Date end, HttpServletResponse response) {
		CutPageBean<MeetingBean> cutBean = service.meetings(pageNo, title, start, end);
		JacksonUtil.outJson(response, cutBean, "meetingJson", "");
	}

	/**
	 * 根据ID查找会议,并设置成session,转到显示页面
	 * 
	 * @param id
	 *            会议ID
	 * @param request
	 *            请求
	 * @return 显示页面
	 */
	@RequestMapping("/show")
	public String show(int id, HttpServletRequest request) {
		MeetingBean meetingBean = service.findById(id);
		request.getSession().setAttribute("meeting", meetingBean);
		return "/jsp/admin/meetingInfo.jsp";
	}

	/**
	 * 根据ID查找会议,并转到修改页面
	 * 
	 * @param id
	 *            会议ID
	 * @param request
	 *            请求
	 * @return 修改页面
	 */
	@RequestMapping("/findById")
	public String findById(int id, HttpServletRequest request) {
		MeetingBean meetingBean = service.findById(id);
		request.getSession().setAttribute("meeting", meetingBean);
		return "/jsp/admin/updateMeeting.jsp";
	}

	/**
	 * 修改会议结果,并把会议状态修改成已结束
	 * 
	 * @param id
	 *            会议ID
	 * @param content
	 *            会议结果
	 * @return 会议界面
	 */
	@RequestMapping("/update")
	public String update(int id, String content) {
		service.update(id, content);
		return "redirect:/jsp/admin/meeting.jsp";
	}
	
	@RequestMapping("/add")
	public String add(MeetingBean meeting,String[]conferee){
		service.add(meeting, conferee);
		return "redirect:/jsp/admin/meeting.jsp";
	}
}
