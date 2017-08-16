package com.project.publicinfo.insurance.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.CutPageBean;
import com.project.bean.InsuranceBean;
import com.project.commonservice.BaseService;
import com.project.publicinfo.insurance.service.IInsuranceService;

@Service("insuranceService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class InsuranceServiceImpl extends BaseService implements IInsuranceService {

	@Override
	public CutPageBean<InsuranceBean> insurances(int pageNo, String insuName) {
		Map<String, Object> map = new HashMap<>();
		map.put("insuName", insuName);
		return this.getCutPage(pageNo, "publicinfoinsurance.all",
				"publicinfoinsurance.getCount", map);
	}

	@Override
	public InsuranceBean findByid(int id) {
		return session.selectOne("publicinfoinsurance.findById", id);
	}
	
	
}
