package com.project.publicinfo.changePwd.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.commonservice.BaseService;
import com.project.publicinfo.changePwd.service.IChangePwdService;

@Service("userChangeService")
@Transactional(readOnly=false,rollbackFor=Exception.class)
public class ChangePwdServiceImpl extends BaseService implements IChangePwdService {

	@Override
	public void updatePwd(int id, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		session.update("employee.changePwd", map);
	}
	
}
