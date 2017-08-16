package com.project.admin.train.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.train.service.IEmployeeService;
import com.project.bean.CutPageBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;

@Service("adminEmpService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class EmployeeServiceImpl extends BaseService implements IEmployeeService {

	@Override
	public CutPageBean<UserBean> trainers(int pageNo, String trueName) {
		Map<String, Object> map = new HashMap<>();
		map.put("trueName", trueName);
		return this.getCutPage(pageNo, "adminTrain.getEmployees",
				"adminTrain.getCount", map);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IEmployeeService service = (IEmployeeService)context.getBean("adminEmpService");
		System.out.println(service.trainers(1, null));
	}
}
