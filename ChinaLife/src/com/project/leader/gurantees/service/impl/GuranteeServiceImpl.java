package com.project.leader.gurantees.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.GuranteeBean;
import com.project.commonservice.BaseService;
import com.project.leader.gurantees.service.IGuranteeService;

@Service("guranteeService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class GuranteeServiceImpl extends BaseService implements IGuranteeService {

	@Override
	public CutPageBean<GuranteeBean> gurantees(int pageNo,Integer departmentId,
			String clientName,String insureName,String signer,String state,Date start,Date end) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("departmentId", departmentId);
		map.put("clientName", clientName);
		map.put("insuName", insureName);
		map.put("signer", signer);
		map.put("state", state);
		map.put("start", start);
		map.put("end", end);
		
		CutPageBean<GuranteeBean> cutBean = this.getCutPage(pageNo, "check.listSql", "check.countSql", map);
		
		return cutBean;
	}

	@Override
	public void update(int id,String auditReason) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("auditReason", auditReason);
		this.session.update("check.checkPass",map);
	}

	@Override
	public void update(int id) {
		this.session.update("check.checkBack",id);
	}

	@Override
	public GuranteeBean findById(int id) {
		GuranteeBean bean = this.session.selectOne("check.findById",id);
		return bean;
	}

	@Override
	public List<GuranteeBean> gurantees() {
		List<GuranteeBean> list = this.session.selectList("check.listSqlCheck");
		return list;
	}

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IGuranteeService service = (IGuranteeService) context.getBean("guranteeService");
		
		//测试：查看所有表单
		CutPageBean cutBean = service.gurantees(1, null, null, "商业险", null, 
				null, Date.valueOf("1111-11-11"), Date.valueOf("2111-11-11"));
		List<GuranteeBean> b = cutBean.getObjects();
		System.out.println(b+"||||||"+b.get(0).getAudit());
		//测试：查看保单详情 ID
//		GuranteeBean g = service.findById(3);
//		System.out.println(g+" ++ "+g.getClient()+"++ "+g.getInsurance()+"++ "+g.getAudit());
		//测试：查看理赔中的保单
//		List<GuranteeBean> list = service.gurantees();
//		System.out.println(list);
		//测试：通过理赔
//		service.update(5, "6的飞起");
		//测试：驳回理赔
//		service.update(5);
		
		
		
	}
}
