package com.project.admin.notice.service.Impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.notice.service.INoticeService;
import com.project.bean.NoticeBean;
import com.project.commonservice.BaseService;


@Service("noticeService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class NoticeServiceImpl extends BaseService implements INoticeService{

	@Override
	public List<NoticeBean> notices() {
		 List<NoticeBean> list =this.session.selectList("notice.findAll");
		return list;
	}

	@Override
	public NoticeBean notice(int id) {
		NoticeBean bean = this.session.selectOne("notice.findById",id);
		return bean;
	}

	@Override
	public void publish(NoticeBean notice) {
		this.session.insert("notice.add",notice);
	}

	@Override
	public void del(int id) {
		this.session.delete("notice.del",id);
	}
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		INoticeService service = (INoticeService) context.getBean("noticeService");
//		System.out.println(service.notices());;
//		System.out.println(service.notice(1));
//		service.publish(new NoticeBean("开除","关于开除小陈的事宜",
//				"小陈上班时间拽瞌睡",""));
		service.del(6);
	}
}
