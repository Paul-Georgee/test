package com.project.admin.rules.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.admin.rules.service.IRulesService;
import com.project.bean.RulesBean;
import com.project.commonservice.BaseService;

@Service("ruleService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class RuleServiceImpl extends BaseService implements IRulesService{

	@Override
	public List<RulesBean> rules() {
		List<RulesBean> list = this.session.selectList("rule.findAll");
		return list;
	}

	@Override
	public void update(int id, String content) {
		Map map = new HashMap<>();
		map.put("id", id);
		map.put("content", content);
		this.session.update("rule.update",map);
	}

	@Override
	public RulesBean findById(int id) {
		RulesBean bean = this.session.selectOne("rule.findById",id);
		return bean;
	}

	@Override
	public void add(RulesBean rule) {
		this.session.insert("rule.add",rule);
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-service.xml");
		IRulesService service = (IRulesService) context.getBean("ruleService");
//		System.out.println(service.rules());
//		service.update(5, "不能抽烟");
		service.add(new RulesBean("第六条","不能穿拖鞋"));
	}
}
