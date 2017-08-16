package com.project.departmentleader.gurantees.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.commonservice.BaseService;
import com.project.departmentleader.gurantees.service.IGuranteeService;

/**
 * 保单维护接口实现类
 * 
 * @author Administrator
 *
 */

@Service("usb")
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class GuranteeSetviceImpl extends BaseService implements IGuranteeService {

	//动态分页查询
	@Override
	public CutPageBean<GuranteeBean> gurantees(int pageNo, int departId, Date start, Date end, String favoree,
			String signer, String number) {
		Map map = new HashMap<>();
		map.put("id", departId);
		map.put("start", start);
		map.put("end", end);
		map.put("favoree", favoree);
		map.put("signer", signer);
		map.put("number", number);
		
		CutPageBean<GuranteeBean> cutPageBean=this.getCutPage(pageNo, "Gurantees.listSql", "Gurantees.countSql", map);
		
		return cutPageBean;
	}

	/**
	 * 通过ID查看保单详情
	 */
	@Override
	public GuranteeBean guranteeInfo(int id) {
		GuranteeBean gbean=session.selectOne("Gurantees.findById", id);
		
		return gbean;
	}

	/**
	 * 添加理赔记录 通过ID查询保单 添加理赔理由  修改保单状态
	 */
	@Override
	public void applyClaim(int id, String applyReason) {
		Map map=new HashMap();
		map.put("id", id);
		map.put("applyReason", applyReason);
		map.put("applyTime", new Date(System.currentTimeMillis()));
		session.insert("Gurantees.addAuditBean", map);
		session.update("Gurantees.updateInsurance", id);

	}
	/**
	 * 终止保单  修改保单状态
	 */
	@Override
	public void terminate(int id) {
		session.update("Gurantees.updateInsuranceById", id);
	}

	
//	public static void main(String[] args) {
//		
//		ApplicationContext aContext=new ClassPathXmlApplicationContext("app-service.xml");
//		IGuranteeService iGuranteeService=(IGuranteeService)aContext.getBean("usb");
////		System.out.println(iGuranteeService.gurantees(1, 4, null, null, null, null, null));
//		System.out.println(iGuranteeService.guranteeInfo(1));
////		iGuranteeService.applyClaim(1, "有钱任性");
////		iGuranteeService.terminate(1);
//	}
}
