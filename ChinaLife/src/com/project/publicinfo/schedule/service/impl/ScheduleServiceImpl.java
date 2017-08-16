package com.project.publicinfo.schedule.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.ScheduleBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.schedule.service.IScheduleService;

@Service("scheduleService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class ScheduleServiceImpl extends BaseService implements IScheduleService {

	@Override
	public List<ScheduleBean> schedules(int userId) {
		
		return this.session.selectList("", userId);
	}

	@Override
	public void addSchedule(ScheduleBean schedule, int userId) {
		schedule.setUserId(userId);
		this.session.insert("publicinfoSchedule.add", schedule);

	}

	@Override
	public CutPageBean<ScheduleBean> allSchedule(int pageNo, int userId,
			String content, Date beginTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("content", content);
		map.put("beginTime", beginTime);
		return this.getCutPage(pageNo, "publicinfoSchedule.getSchedules",
				"publicinfoSchedule.getCount", map);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IScheduleService service = (IScheduleService)context.getBean("scheduleService");
		System.out.println(service.allSchedule(1, 7, null, null));
	
	}
}
