package com.project.employee.client.service.Impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.ClientBean;
import com.project.bean.CutPageBean;
import com.project.commonservice.BaseService;
import com.project.employee.client.service.IClientService;
import com.project.employee.orders.service.IOrdersService;

@Service("clientService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class ClientServiceImpl extends BaseService implements IClientService{

	@Override
	public CutPageBean<ClientBean> clients(int pageNo, int userId, String clientName, String profession) {
		Map map = new HashMap<>();
		map.put("userId", userId);
		map.put("clientName", clientName);
		map.put("profession", profession);
		CutPageBean<ClientBean> bean = this.getCutPage(pageNo, "client.findByItem", "client.count", map);
		return bean;
	}

	@Override
	public void clientAdd(ClientBean client) {
		this.session.insert("client.add",client);
	}

	@Override
	public ClientBean clientInfo(int clientId) {
		ClientBean bean = this.session.selectOne("client.findById",clientId);
		return bean;
	}

	@Override
	public void editInfo(int clientId, int salary, String profession, String tel, String family) {
		Map map = new HashMap<>();
		map.put("clientId", clientId);
		map.put("salary", salary);
		map.put("profession", profession);
		map.put("tel", tel);
		map.put("family", family);
		this.session.update("client.update",map);
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IClientService service =  (IClientService) context.getBean("clientService");
//		System.out.println(service.clients(1, 1, "刘", "战").getObjects());
//		service.clientAdd(new ClientBean("吕布","13823412321","男",
//				"将军","三姓家奴",2514124,Date.valueOf("1988-04-21"),2));
//		System.out.println(service.clientInfo(23));
//		service.editInfo(1, 1000, "打野", "13842141241", "恼火");
	}
}
