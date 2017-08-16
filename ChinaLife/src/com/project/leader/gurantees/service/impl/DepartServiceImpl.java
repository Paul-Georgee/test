package com.project.leader.gurantees.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.DepartmentBean;
import com.project.bean.InsuranceBean;
import com.project.commonservice.BaseService;
import com.project.leader.gurantees.service.IDepartmentService;

@Service("departService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class DepartServiceImpl extends BaseService implements IDepartmentService {

	@Override
	public List<DepartmentBean> departments() {
		// TODO Auto-generated method stub
		List<DepartmentBean> list = this.session.selectList("depart.allDepart");
		return list;
	}
	
	@Override
	public int countDepart() {
		// TODO Auto-generated method stub
		return this.session.selectOne("depart.countDepart");
	}

	@Override
	public List<InsuranceBean> insurances() {
		// TODO Auto-generated method stub
		List<InsuranceBean> list = this.session.selectList("depart.allInsurance");
		return list;
	}

	@Override
	public int countInsurance() {
		// TODO Auto-generated method stub
		return this.session.selectOne("depart.countInsurance");
	}

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
//		IDepartmentService service =  (IDepartmentService) context.getBean("departService");
//		
//		System.out.println(service.departments());
//		System.out.println(service.countDepart());
//		System.out.println(service.insurances());
//		System.out.println(service.countInsurance());
	}






}
