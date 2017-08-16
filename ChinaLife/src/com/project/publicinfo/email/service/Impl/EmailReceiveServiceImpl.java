package com.project.publicinfo.email.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.ReceiveBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.email.service.IEmailReceiveService;


@Service("emailService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class EmailReceiveServiceImpl extends BaseService implements IEmailReceiveService {

	@Override
	public CutPageBean<ReceiveBean> receives(int pageNo, int receiverId, String title, String sender) {
		Map map = new HashMap();
		map.put("title", title);
		map.put("sender", sender);
		map.put("receiverId", receiverId);
		CutPageBean cutBean = this.getCutPage(pageNo, "publicinfoEmail.listSql", "publicinfoEmail.countSql", map);
		return cutBean;
	}

	@Override
	public void toTrash(int id) {
		this.session.update("publicinfoEmail.update",id);
	}

	@Override
	public ReceiveBean email(int id) {
		this.session.update("publicinfoEmail.lookUpdate",id);
		return this.session.selectOne("publicinfoEmail.findById",id);
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IEmailReceiveService service = (IEmailReceiveService)context.getBean("emailService");
//		System.out.println(service.receives(1, 9, null, null));
//		service.toTrash(9);
		System.out.println(service.email(8));
	}
}
