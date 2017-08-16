package com.project.publicinfo.notice.service.Impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.NoticeBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.notice.service.INoticeService;

@Service("not")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class NoticeServiceImpl extends BaseService implements INoticeService {

	@Override
	public List<NoticeBean> notices() {
		List<NoticeBean> list=this.session.selectList("publicinfonot.findByAll");
		return list;
	}
	@Override
	public NoticeBean notice(int id) {
		NoticeBean bean=this.session.selectOne("publicinfonot.findById",id);
		return bean;
	}
public static void main(String[] args) {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("app-service.xml");
	INoticeService service=(INoticeService) context.getBean("not");
	System.out.println(service.notice(2));
//	System.out.println(service.notices());
	}
}
