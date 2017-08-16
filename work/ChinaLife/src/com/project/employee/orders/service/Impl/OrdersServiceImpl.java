package com.project.employee.orders.service.Impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.commonservice.BaseService;
import com.project.employee.orders.service.IOrdersService;

@Service("orderService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class OrdersServiceImpl extends BaseService implements IOrdersService{

	@Override
	public CutPageBean<GuranteeBean> gurantees(int pageNo, int followId) {
		Map map = new HashMap<>();
		map.put("id", followId);
		CutPageBean<GuranteeBean> cutBean =  this.getCutPage(pageNo, "oders.findAll", "oders.count", map);
		return cutBean;
	}

	@Override
	public GuranteeBean guranteeInfo(int guranteeId) {
		GuranteeBean bean = this.session.selectOne("oders.showGurantee",guranteeId);
		return bean;
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IOrdersService service =  (IOrdersService) context.getBean("orderService");
//		System.out.println(service.gurantees(1, 9).getObjects().get(0).getClient().getClientName());
//		System.out.println(service.gurantees(1, 9).getCount());
		System.out.println(service.guranteeInfo(001).getClient().getGender());
	}
}
