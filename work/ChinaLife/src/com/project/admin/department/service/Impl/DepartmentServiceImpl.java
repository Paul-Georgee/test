package com.project.admin.department.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.department.service.IDepartmentService;
import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;

@Service("departmentService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class DepartmentServiceImpl extends BaseService implements IDepartmentService {

	@Override
	public void add(DepartmentBean dbean) {
		this.session.insert("adminDepartment.add",dbean);
	}

	@Override
	public void update(int id, int employId,int departHeaderId) {
		String a =this.session.selectOne("adminDepartment.findDepartHeader",employId);
		if("部门负责人".equals(a)){
			this.session.update("adminDepartment.udpateDepartHeaderNull",employId);
		}
		if(departHeaderId != 0){
			this.session.update("adminDepartment.updateIsNull",departHeaderId);
		}
		Map map = new HashMap();
		map.put("employId", employId);
		map.put("id", id);
		this.session.update("adminDepartment.update",map);
	}

	@Override
	public DepartmentBean findById(int id) {
		return this.session.selectOne("adminDepartment.findById",id);
	}

	@Override
	public int del(int id) {
		
		List<UserBean> list = this.session.selectList("adminDepartment.findByIdForDepart",id);
		if(list.size() == 0){
			this.session.delete("adminDepartment.del",id);
			return 0;
		}else{
			return 1;
		}
		
	}
	
	@Override
	public List<DepartmentBean> departments() {
		return this.session.selectList("adminDepartment.findAll");
	}
	
	@Override
	public CutPageBean<UserBean> findByItemForUser(int pageNo, String userName) {
		Map map = new HashMap();
		map.put("userName", userName);
		CutPageBean cutBean = this.getCutPage(pageNo, "adminDepartment.listSql", "adminDepartment.countSql", map);
		return cutBean;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IDepartmentService service = (IDepartmentService)context.getBean("departmentService");
//		service.add(new DepartmentBean("财务部","专门管钱的！"));
		service.update(10,7,23);
//		service.del(6);
//		System.out.println(service.findById(10));
//		System.out.println(service.departments());
//		System.out.println(service.findByItemForUser(1, null));
	}

	
}
