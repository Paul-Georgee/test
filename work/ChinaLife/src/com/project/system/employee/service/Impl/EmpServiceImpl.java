package com.project.system.employee.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.DepartmentBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;
import com.project.system.employee.service.IEmpService;

/**
 * 系统管理员业务接口实现类
 * 
 * @author Administrator
 *
 */
@Service("syss")
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class EmpServiceImpl extends BaseService implements IEmpService {

	// 动态分页查询
	@Override
	public CutPageBean<UserBean> emps(int pageNo, String trueName, String duty) {
		Map map = new HashMap<>();
		map.put("trueName", trueName);
		map.put("duty", duty);

		CutPageBean<UserBean> cutPageBean = this.getCutPage(pageNo, "system.listSql", "system.countSql", map);
		return cutPageBean;
	}

	// 修改前先查询用户
	@Override
	public UserBean findById(int id) {
		UserBean ubean = session.selectOne("system.findUserById", id);
		return ubean;
	}

	// 查询所有部们
	@Override
	public List<DepartmentBean> findItem() {
		List<DepartmentBean> list = session.selectList("system.findDepartment");
		return list;
	}

	@Override
	public void empsAdd(UserBean user) {
		session.insert("system.addUserBean", user);
	}

	@Override
	public void update(int userId, String duty, String tel, int departId, String role) {
		Map map = new HashMap<>();
		map.put("id", userId);
		map.put("duty", duty);
		map.put("tel", tel);
		map.put("role", role);
		map.put("departId", departId);
		/**
		 * 当跟换的是不同部门的负责人时! 先根据ID进行查询当前用用户是不是某个部门的部门负责人 如果是更换时就该把用户当前部门 负责人设置为空
		 * ,将选择部门的负责人的修改为当前用户
		 */
		// 先查询出当前用户的部门与职务
		UserBean ubean = session.selectOne("system.findUserRole", userId);
		// 判断当前用户的部门职务是不是部门负责人 如果是那么修改时就应该将当前用户的部门负责人设置为null
		Map map3 = new HashMap();
		map3.put("id", ubean.getDepartId());
		if ("部门负责人".equals(ubean.getRole())) {
			session.update("system.updateDepartHeaderToNull", map3);
		}		
		// 同部门内的更换
		Map map2 = new HashMap();
		map2.put("id", userId);
		map2.put("departId", departId);
		if ("部门负责人".equals(role)) {
			session.update("system.updateDepartmentHeader", map2);
		}
		session.update("system.updateInfo", map);
	}

	// 删除 如果还有有效保单就不能删除 返回为false 如果没有 就会修改用户信息为离职,如果该员工为部门负责人 那就会将该部门管理人置空
	@Override
	public boolean del(int userId) {
		int count = session.selectOne("system.findInsuranceById", userId);
		if (count > 0) {
			return false;
		} else {
			session.update("system.updateUserState", userId);
			return true;
		}

	}

//	 public static void main(String[] args) {
//	 ApplicationContext aContext=new ClassPathXmlApplicationContext("app-service.xml");
//	 IEmpService service=(IEmpService)aContext.getBean("syss");
//	 System.out.println(service.emps(1, null, null).getObjects());
//	// System.out.println(service.findItem().get(0).getDepartName());
//	// service.empsAdd(new UserBean("xxxxx", "王大宝", "23dsdas32322@qq.com",
//	 //"13700980277", "男", Date.valueOf("1998-02-22"), "321321.jpg","管理", "大专",
//	 //1));
//	// service.update(1, "总管", "13777081132", 2, "部门负责人");
//	// System.out.println(service.findById(1));
//	 }

}
