 package com.project.leader.employees.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;
import com.project.leader.employees.service.IEmployeeService;

@Service("leaderDepartService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class DepartmentServiceImpl extends BaseService implements IEmployeeService {

	@Override
	public CutPageBean<UserBean> employees(int pageNo, String trueName, Integer departmentId, String duty) {
		Map<String, Object> map = new HashMap<>();
		map.put("trueName", trueName);
		map.put("departmentId", departmentId);
		map.put("duty", duty);
		return this.getCutPage(pageNo, "leaderEmployees.getEmployees",
				"leaderEmployees.getCount", map);
	}

	@Override
	public UserBean findById(int userId) {
		
		return this.session.selectOne("leaderEmployees.getEmpInfo", userId);
	}
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
//		IEmployeeService service = (IEmployeeService)context.getBean("leaderDepartService");
////		System.out.println(service.employees(1, null, 6, "ÒµÎñÔ±"));
////		System.out.println(service.findById(3));
//	}
}
