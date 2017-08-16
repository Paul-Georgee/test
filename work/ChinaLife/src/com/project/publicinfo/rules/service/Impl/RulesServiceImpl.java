package com.project.publicinfo.rules.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.RulesBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.rules.service.IRulesService;
@Service("rules")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class RulesServiceImpl extends BaseService implements IRulesService {

	@Override
	public List<RulesBean> rules() {
		
		List<RulesBean> list=this.session.selectList("publicinforules.findByAll");
		
		return list;
	}

	@Override
	public List<RulesBean> findTop3() {
	
			List<RulesBean> list=this.session.selectList("publicinforules.find1");
			
		return list;
	}

}
