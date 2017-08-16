package com.project.system.employee.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.bean.UserBean;
import com.project.commonservice.BaseService;
import com.project.system.employee.service.IChangeTrackService;
import com.sun.activation.registries.MailcapParseException;
/**
 * 系统管理员用户管理接口实现类
 * @author Administrator
 *
 */
@Service("sys")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class ChangeTrackServiceImpl extends BaseService implements IChangeTrackService {

	@Override
	public CutPageBean<GuranteeBean> gurantees(int userId, int pageNo) {
		Map map=new HashMap();
		map.put("id", userId);
		CutPageBean<GuranteeBean> cutPageBean=this.getCutPage(pageNo, "system.findInsurancesList", "system.findInsuranceCount", map);
		return cutPageBean;
	}

	
	
	//修改用户有效保单跟单人
	@Override
	public void changeTrack(int userId, int[] gurantees) {
			Map map=new HashMap<>();
			map.put("id", userId);
			map.put("gurantees", gurantees);
			session.update("system.updateFollow", map);

	}
	//参看同一部门的其他业务员
	@Override
	public CutPageBean<UserBean> findUserInDepartment(int id, int pageNo, String trueName) {
		Map map=new  HashMap<>();
		map.put("id", id);
		map.put("trueName", trueName);
		CutPageBean<UserBean> cutBean=this.getCutPage(pageNo, "system.listSql2", "system.countSql2", map);			
		return cutBean;
	}
	
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("app-service.xml");
		IChangeTrackService service=(IChangeTrackService)context.getBean("sys");
//		System.out.println(service.gurantees(9, 1).getObjects().get(1));
//		service.changeTrack(10, new int[]{});
//		System.out.println(service.findUserInDepartment(1, 1, null));
	}



	
}
