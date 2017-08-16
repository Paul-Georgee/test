package com.project.admin.gurantee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.admin.gurantee.service.IGuranteeService;
import com.project.bean.GuranteeBean;
import com.project.commonservice.BaseService;

@Service("uploadGuranteeService")
public class GuranteeServiceImpl extends BaseService implements IGuranteeService {

	@Override
	public void upload(List<GuranteeBean> gurantees) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gurantees", gurantees);
		this.session.insert("adminGurantee.uploadGurantees",
				map);
	}
	
}
