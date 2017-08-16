package com.project.departmentleader.employees.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.TrainBean;
import com.project.bean.UserBean;
import com.project.bean.UserTrainBean;
import com.project.commonservice.BaseService;
import com.project.departmentleader.employees.service.IEmployeeService;
import com.sun.org.apache.bcel.internal.generic.Select;

@Service("us")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class EmployeeServiceImpl extends BaseService implements IEmployeeService {

	//分页条件查询部门下有哪些员工
	@Override
	public CutPageBean<UserBean> employees(int pageNo, int departId, String trueName, String duty) {
		Map map=new HashMap<>();
		map.put("id", departId);
		map.put("trueName", trueName);
		map.put("duty", duty);
		
		CutPageBean<UserBean> cutPageBean=this.getCutPage(pageNo, "employees.listSql", "employees.countSql", map);
		return cutPageBean;
	}

	@Override
	public UserBean employeeInfo(int userId) {
		UserBean ubean=session.selectOne("employees.findUserById", userId);
		List<UserTrainBean> list=session.selectList("employees.findPoint", userId);
		ubean.setTrains(list);
		return ubean;
	}



	
//	public static void main(String[] args) {
//		ApplicationContext aContext=new ClassPathXmlApplicationContext("app-service.xml");
//		IEmployeeService service=(IEmployeeService)aContext.getBean("us");
//		System.out.println(service.employees(1, 2, null, null).getObjects().size());
////		System.out.println(service.employeeInfo(2));
		
//	}
}
