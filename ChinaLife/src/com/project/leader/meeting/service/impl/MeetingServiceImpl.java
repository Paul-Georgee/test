package com.project.leader.meeting.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;
import com.project.commonservice.BaseService;
import com.project.leader.meeting.service.IMeetingService;

@Service("leaderMeetingService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class MeetingServiceImpl extends BaseService implements IMeetingService {

	@Override
	public CutPageBean<MeetingBean> findByitem(int pageNo, String title, Date start, Date end) {
		// TODO Auto-generated method stub
		
		Map map = new HashMap();
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);
		
		CutPageBean cutBean = this.getCutPage(pageNo, "leaderMeeting.listSql",
				"leaderMeeting.countSql", map);
		
		return cutBean;
	}

	@Override
	public MeetingBean findById(int id) {
		// TODO Auto-generated method stub
		MeetingBean bean = this.session.selectOne("leaderMeeting.findById",id);
		return bean;
	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
//		IMeetingService service = (IMeetingService) context.getBean("meetingService");
//		
//		MeetingBean bean = service.findById(2);
//		System.out.println(bean);
//		
////		CutPageBean cutBean = service.findByitem(1, "明年销售任务", Date.valueOf("1111-11-11"), Date.valueOf("2222-11-11"));
////		System.out.println(cutBean.getObjects());
//	}
	
}
