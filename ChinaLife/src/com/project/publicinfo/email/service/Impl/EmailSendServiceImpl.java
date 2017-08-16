package com.project.publicinfo.email.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.EmailBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.email.service.IEmailSendService;


@Service("sendEmailService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class EmailSendServiceImpl extends BaseService implements IEmailSendService {

	@Override
	public EmailBean email(int id) {
		return this.session.selectOne("publicinfoSendEmail.findById",id);
	}

	@Override
	public CutPageBean<EmailBean> emails(int pageNo, int userId, String title) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("title", title);
		CutPageBean cutBean = this.getCutPage(pageNo, "publicinfoSendEmail.listSql", "publicinfoSendEmail.countSql", map);
		return cutBean;
	}

	@Override
	public void ToTrash(int id) {
		this.session.update("publicinfoSendEmail.update",id);
	}

	@Override
	public void send(EmailBean email, int[] receiverId, String receivers) {
		email.setReceivers(receivers);
		this.session.insert("publicinfoSendEmail.addSend",email);
		Map map = new HashMap();
		map.put("id", email.getId());
		map.put("receiverId", receiverId);
		this.session.insert("publicinfoSendEmail.addReceivers", map);
	}
	
	@Override
	public CutPageBean<UserBean> sendEmailFindUser(int pageNo, String userName) {
		Map map = new HashMap();
		map.put("userName", userName);
		CutPageBean cutBean = this.getCutPage(pageNo, "publicinfoSendEmail.sendEmailListSql", "publicinfoSendEmail.sendEmailCountSql", map);
		return cutBean;
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IEmailSendService service = (IEmailSendService)context.getBean("sendEmailService");
//		System.out.println(service.emails(1, 6, null));
//		System.out.println(service.email(5));
//		service.ToTrash(1);
		service.send(new EmailBean("LOL抽皮肤","只要你运气好，稀有又好看的皮肤轻松获得","抽皮肤攻略",3), new int[]{1,2,3}, "张三,李四");
	}

	
}
