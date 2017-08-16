package com.project.publicinfo.contacts.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.contacts.service.IContactsService;

@Service("contactService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class ContactServiceImpl extends BaseService implements IContactsService {

	@Override
	public CutPageBean<UserBean> contacts(int pageNo, String trueName, String duty, Integer departmentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("trueName", trueName);
		map.put("duty", duty);
		map.put("departmentId", departmentId);
		return this.getCutPage(pageNo,"publicinfocontacts.contact",
				"publicinfocontacts.getCount",map);
	}
	
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
//		IContactsService service = (IContactsService)context.getBean("contactService");
//		System.out.println(service.contacts(1, null, null, null));
//	}
}
