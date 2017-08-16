package com.project.admin.meeting.service.Impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.meeting.service.IMeetingService;
import com.project.bean.CutPageBean;
import com.project.bean.MeetingBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;

@Service("meetingService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class MeetingServiceImpl extends BaseService implements IMeetingService{

	@Override
	public CutPageBean<MeetingBean> meetings(int pageNo, String title, Date start, Date end) {
		Map map = new HashMap<>();
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);
		CutPageBean<MeetingBean> bean = this.getCutPage(pageNo, "meeting.findByItem", "meeting.count", map);
		return bean;
	}

	@Override
	public MeetingBean findById(int id) {
		MeetingBean bean = this.session.selectOne("meeting.findById", id);
		return bean;
	}

	@Override
	public void update(int id, String content) {
		Map map = new HashMap<>();
		map.put("id", id);
		map.put("content", content);
		this.session.update("meeting.update",map);
	}

	@Override
	public void add(MeetingBean meeting, String[] conferee) {
		    StringBuffer strbuf = new StringBuffer();
		    for( int i = 0; i < conferee.length; i++ ) {
		        strbuf.append( "," ).append( conferee[i] );
		    }
		   String str = strbuf.deleteCharAt( 0 ).toString();
		   meeting.setConferee(str);
		this.session.insert("meeting.add",meeting);
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IMeetingService service =  (IMeetingService) context.getBean("meetingService");
		System.out.println(service.meetings(1, "任务", null, null).getObjects());
//		System.out.println(service.findById(3));
//		service.update(1, "每个部门必须比上年增加10%");
//		service.add(new MeetingBean("公司聚会","公司会议室","周五晚上我们去芭比伦搓一顿",
//				Date.valueOf("2017-07-25")) ,new String[]{"张三","李四","王五"});
	}

}
