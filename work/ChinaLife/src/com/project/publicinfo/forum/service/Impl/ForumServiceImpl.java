package com.project.publicinfo.forum.service.Impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.ForumBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.forum.service.IForumService;

@Service("forumService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class ForumServiceImpl extends BaseService implements IForumService {

	@Override
	public List<ForumBean> forums() {
		
		return this.session.selectList("publicinfoforum.getForums");
	}

	@Override
	public void forumAdd(ForumBean forum) {
		this.session.insert("publicinfoforum.add", forum);
	}
	
	public static void main(String[] args) {	
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IForumService service = (IForumService)context.getBean("forumService");
		System.out.println(service.forums());
//		service.forumAdd(new ForumBean("公司险种","李四"));
	}

}
